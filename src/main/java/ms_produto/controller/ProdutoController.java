package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.ProdutoEntradaDTO;
import ms_produto.dtos.ProdutoRetornoDTO;
import ms_produto.modelo.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired ProdutoServico servico;

    @PostMapping
    public ProdutoRetornoDTO criartProduto(@RequestBody @Valid ProdutoEntradaDTO produtoEntrada){
        return servico.criarProduto(produtoEntrada);
    }
}
