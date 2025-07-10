package ms_produto.modelo.servico;

import ms_produto.dtos.UnidadeEntradaDTO;
import ms_produto.dtos.UnidadeRetornoDTO;
import ms_produto.modelo.entidades.Unidade;
import ms_produto.modelo.repositorio.UnidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
