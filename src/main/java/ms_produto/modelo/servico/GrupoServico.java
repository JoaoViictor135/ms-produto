package ms_produto.modelo.servico;

import ms_produto.dtos.CaracteristicaRetornoDTO;
import ms_produto.dtos.GrupoEntradaDTO;
import ms_produto.dtos.GrupoRetornoDTO;
import ms_produto.modelo.entidades.Grupo;
import ms_produto.modelo.repositorio.GrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GrupoServico {

    @Autowired GrupoRepositorio repositorio;

    public GrupoRetornoDTO criarGrupo(GrupoEntradaDTO grupoEntrada){
        Grupo grupo = new Grupo();
        grupo.setDescricao(grupoEntrada.getDescricao());
        grupo.setCodigo(grupoEntrada.getCodigo());
        return parseEntidadeParaDTO(repositorio.save(grupo));
    }

    public List<GrupoRetornoDTO> retornarListaGrupo(){
        List<Grupo> listaGrupo = repositorio.findAll();
        List<GrupoRetornoDTO> grupoRetornoDTOS = new ArrayList<>();
        for(int i=0;i < listaGrupo.size();i++){
            Grupo grupo = listaGrupo.get(i);
            grupoRetornoDTOS.add(parseEntidadeParaDTO(grupo));
        }
        return grupoRetornoDTOS;
    }

    public GrupoRetornoDTO atualizaGrupo(UUID id, GrupoEntradaDTO grupoEntradaDTO){
        Grupo grupo = retornarGrupo(id);
        grupo.setCodigo(grupoEntradaDTO.getCodigo());
        grupo.setDescricao(grupoEntradaDTO.getDescricao());
        return parseEntidadeParaDTO(repositorio.save(grupo));
    }

    public void deletarGrupo(UUID id){
        repositorio.delete(retornarGrupo(id));
    }

    public GrupoRetornoDTO buscarGrupoPorId(UUID id){
        return parseEntidadeParaDTO(retornarGrupo(id));
    }

    private GrupoRetornoDTO parseEntidadeParaDTO(Grupo grupo){
        GrupoRetornoDTO grupoRetorno = new GrupoRetornoDTO();
        grupoRetorno.setId(grupo.getId());
        grupoRetorno.setDescricao(grupo.getDescricao());
        grupoRetorno.setCodigo(grupo.getCodigo());
        return grupoRetorno;
    }

    private Grupo retornarGrupo(UUID id){
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
    }
}
