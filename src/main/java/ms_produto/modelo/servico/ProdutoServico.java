package ms_produto.modelo.servico;

import ms_produto.dtos.GrupoRetornoDTO;
import ms_produto.dtos.ProdutoEntradaDTO;
import ms_produto.dtos.ProdutoRetornoDTO;
import ms_produto.modelo.entidades.Produto;
import ms_produto.modelo.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    public List<ProdutoRetornoDTO> retornarListaProduto(){
        List<Produto> listaProduto = repositorio.findAll();
        List<ProdutoRetornoDTO> produtoRetornoDTOS = new ArrayList<>();
        for(int i=0;i < listaProduto.size();i++){
            Produto produto = listaProduto.get(i);
            ProdutoRetornoDTO produtoRetornoDTO = new ProdutoRetornoDTO();
            produtoRetornoDTO.setId(produto.getId());
            produtoRetornoDTO.setFoto(produto.getFoto());
            produtoRetornoDTO.setComplemento(produto.getComplemento());
            produtoRetornoDTO.setNomeProduto(produto.getNomeProduto());
            produtoRetornoDTO.setValorCusto(produto.getValorCusto());
            produtoRetornoDTO.setValorVenda(produto.getValorVenda());
            produtoRetornoDTO.setCodigoBarra(produto.getCodigoBarra());
            produtoRetornoDTO.setCodigo(produto.getCodigo());
            produtoRetornoDTOS.add(produtoRetornoDTO);
        }
        return produtoRetornoDTOS;
    }
}
