package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.ProdutoEntradaDTO;
import ms_produto.dtos.ProdutoRetornoDTO;
import ms_produto.modelo.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired ProdutoServico servico;

    @PostMapping
    public ProdutoRetornoDTO criartProduto(@RequestBody @Valid ProdutoEntradaDTO produtoEntrada){
        return servico.criarProduto(produtoEntrada);
    }

    @GetMapping
    public List<ProdutoRetornoDTO> retornarLista(){
        return servico.retornarListaProduto();
    }
}
