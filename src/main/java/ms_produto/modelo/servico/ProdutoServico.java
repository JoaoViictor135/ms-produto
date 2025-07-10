package ms_produto.modelo.servico;

import ms_produto.dtos.ProdutoEntradaDTO;
import ms_produto.dtos.ProdutoRetornoDTO;
import ms_produto.modelo.entidades.Produto;
import ms_produto.modelo.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ProdutoServico {

    @Autowired ProdutoRepositorio repositorio;

    public ProdutoRetornoDTO criarProduto(ProdutoEntradaDTO produtoEntrada){
        Produto produto = new Produto();
        produto.setNomeProduto(produtoEntrada.getNomeProduto());
        produto.setCodigo(produtoEntrada.getCodigo());
        produto.setFoto(produtoEntrada.getFoto());
        produto.setComplemento(produtoEntrada.getComplemento());
        produto.setCodigoBarra(produtoEntrada.getCodigoBarra());
        produto.setValorCusto(produtoEntrada.getValorCusto());
        produto.setValorVenda(produtoEntrada.getValorVenda());

        produto = repositorio.save(produto);

        ProdutoRetornoDTO produtoRetorno = new ProdutoRetornoDTO();
        produtoRetorno.setId(produto.getId());
        produtoRetorno.setNomeProduto(produto.getNomeProduto());
        produtoRetorno.setCodigo(produto.getCodigo());
        produtoRetorno.setFoto(produto.getFoto());
        produtoRetorno.setComplemento(produto.getComplemento());
        produtoRetorno.setCodigoBarra(produto.getCodigoBarra());
        produtoRetorno.setValorCusto(produto.getValorCusto());
        produtoRetorno.setValorVenda(produto.getValorVenda());
        return produtoRetorno;


    }
}
