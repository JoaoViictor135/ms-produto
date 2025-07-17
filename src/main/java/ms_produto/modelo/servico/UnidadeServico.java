package ms_produto.modelo.servico;

import ms_produto.dtos.UnidadeEntradaDTO;
import ms_produto.dtos.UnidadeRetornoDTO;
import ms_produto.modelo.entidades.Unidade;
import ms_produto.modelo.repositorio.UnidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UnidadeServico {

    @Autowired UnidadeRepositorio repositorio;

    public UnidadeRetornoDTO criarUnidade(UnidadeEntradaDTO unidadeEntrada){
        Unidade unidade = new Unidade();
        unidade.setCodigo(unidadeEntrada.getCodigo());
        unidade.setDescricao(unidadeEntrada.getDescricao());
        return parseEntidadeParaDTO(repositorio.save(unidade));
    }

    public List<UnidadeRetornoDTO> retornarListaUnidade(){
        List<Unidade> listaUnidade = repositorio.findAll();
        List<UnidadeRetornoDTO> unidadeRetornoDTOS = new ArrayList<>();
        for(int i=0;i < listaUnidade.size();i++){
            Unidade unidade = listaUnidade.get(i);
            unidadeRetornoDTOS.add(parseEntidadeParaDTO(unidade));
        }
        return unidadeRetornoDTOS;
    }

    public UnidadeRetornoDTO atualizarUnidade(UUID id, UnidadeEntradaDTO unidadeEntradaDTO){
        Unidade unidade = retornarUnidade(id);
        unidade.setDescricao(unidadeEntradaDTO.getDescricao());
        unidade.setCodigo(unidadeEntradaDTO.getCodigo());
        return parseEntidadeParaDTO(repositorio.save(unidade));
    }

    public void deletarServico(UUID id){
        repositorio.delete(retornarUnidade(id));
    }

    public UnidadeRetornoDTO buscarUnidadePorid(UUID id){
        return parseEntidadeParaDTO(retornarUnidade(id));
    }

    private UnidadeRetornoDTO parseEntidadeParaDTO(Unidade unidade){
        UnidadeRetornoDTO unidadeRetornoDTO = new UnidadeRetornoDTO();
        unidadeRetornoDTO.setId(unidade.getId());
        unidadeRetornoDTO.setCodigo(unidade.getCodigo());
        unidadeRetornoDTO.setDescricao(unidade.getDescricao());
        return unidadeRetornoDTO;
    }

    private Unidade retornarUnidade(UUID id){
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
    }
}
