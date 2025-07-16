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

        unidade = repositorio.save(unidade);

        UnidadeRetornoDTO unidadeRetorno = new UnidadeRetornoDTO();
        unidadeRetorno.setId(unidade.getId());
        unidadeRetorno.setCodigo(unidade.getCodigo());
        unidadeRetorno.setDescricao(unidade.getDescricao());
        return unidadeRetorno;
    }

    public List<UnidadeRetornoDTO> retornarListaUnidade(){
        List<Unidade> listaUnidade = repositorio.findAll();
        List<UnidadeRetornoDTO> unidadeRetornoDTOS = new ArrayList<>();
        for(int i=0;i < listaUnidade.size();i++){
            Unidade unidade = listaUnidade.get(i);
            UnidadeRetornoDTO unidadeRetornoDTO = new UnidadeRetornoDTO();
            unidadeRetornoDTO.setId(unidade.getId());
            unidadeRetornoDTO.setDescricao(unidade.getDescricao());
            unidadeRetornoDTO.setCodigo(unidade.getCodigo());
            unidadeRetornoDTOS.add(unidadeRetornoDTO);
        }
        return unidadeRetornoDTOS;
    }

    public UnidadeRetornoDTO atualizarUnidade(UUID id, UnidadeEntradaDTO unidadeEntradaDTO){
        Unidade unidade = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
        unidade.setDescricao(unidadeEntradaDTO.getDescricao());
        unidade.setCodigo(unidadeEntradaDTO.getCodigo());

        repositorio.save(unidade);

        UnidadeRetornoDTO unidadeRetornoDTO = new UnidadeRetornoDTO();
        unidadeRetornoDTO.setId(unidade.getId());
        unidadeRetornoDTO.setCodigo(unidade.getCodigo());
        unidadeRetornoDTO.setDescricao(unidade.getDescricao());
        return unidadeRetornoDTO;
    }

    public void deletarServico(UUID id){
        Unidade unidade = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
        repositorio.delete(unidade);
    }

    public UnidadeRetornoDTO buscarUnidadePorid(UUID id){
        Unidade unidade = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));

        UnidadeRetornoDTO unidadeRetornoDTO = new UnidadeRetornoDTO();
        unidadeRetornoDTO.setId(unidade.getId());
        unidadeRetornoDTO.setCodigo(unidade.getCodigo());
        unidadeRetornoDTO.setDescricao(unidade.getDescricao());
        return unidadeRetornoDTO;
    }
}
