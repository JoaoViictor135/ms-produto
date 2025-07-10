package ms_produto.modelo.servico;

import ms_produto.dtos.GrupoEntradaDTO;
import ms_produto.dtos.GrupoRetornoDTO;
import ms_produto.modelo.entidades.Grupo;
import ms_produto.modelo.repositorio.GrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoServico {

    @Autowired GrupoRepositorio repositorio;

    public GrupoRetornoDTO criarGrupo(GrupoEntradaDTO grupoEntrada){
        Grupo grupo = new Grupo();
        grupo.setDescricao(grupoEntrada.getDescricao());
        grupo.setCodigo(grupoEntrada.getCodigo());

        grupo = repositorio.save(grupo);

        GrupoRetornoDTO grupoRetorno = new GrupoRetornoDTO();
        grupoRetorno.setId(grupo.getId());
        grupoRetorno.setDescricao(grupo.getDescricao());
        grupoRetorno.setCodigo(grupo.getCodigo());
        return grupoRetorno;

    }
}
