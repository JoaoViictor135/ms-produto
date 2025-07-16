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
import java.util.UUID;

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

    public ProdutoRetornoDTO atualizaProduto(UUID id, ProdutoEntradaDTO produtoEntradaDTO){
        Produto produto = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Produto Não encontrado"));
        produto.setValorVenda(produtoEntradaDTO.getValorVenda());
        produto.setFoto(produtoEntradaDTO.getFoto());
        produto.setComplemento(produtoEntradaDTO.getComplemento());
        produto.setNomeProduto(produtoEntradaDTO.getNomeProduto());
        produto.setValorCusto(produtoEntradaDTO.getValorCusto());
        produto.setCodigoBarra(produtoEntradaDTO.getCodigoBarra());
        produto.setCodigo(produtoEntradaDTO.getCodigo());

        repositorio.save(produto);

        ProdutoRetornoDTO produtoRetornoDTO = new ProdutoRetornoDTO();
        produtoRetornoDTO.setId(produto.getId());
        produtoRetornoDTO.setCodigo(produto.getCodigo());
        produtoRetornoDTO.setFoto(produto.getFoto());
        produtoRetornoDTO.setNomeProduto(produto.getNomeProduto());
        produtoRetornoDTO.setComplemento(produto.getComplemento());
        produtoRetornoDTO.setCodigoBarra(produto.getCodigoBarra());
        produtoRetornoDTO.setValorVenda(produto.getValorVenda());
        produtoRetornoDTO.setValorCusto(produto.getValorCusto());

        return produtoRetornoDTO;
    }
}
