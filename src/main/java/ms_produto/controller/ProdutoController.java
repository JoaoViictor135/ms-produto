package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.ProdutoEntradaDTO;
import ms_produto.dtos.ProdutoRetornoDTO;
import ms_produto.modelo.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/buscar-por-id/id/{id}")
    public ProdutoRetornoDTO atualizarProdutoPorId(@PathVariable("id") UUID id){
        return servico.buscarProdutoPorId(id);
    }

    @PutMapping("/id/{id}")
    public ProdutoRetornoDTO atualizarProduto(@PathVariable("id") UUID id, @RequestBody @Valid ProdutoEntradaDTO produtoEntradaDTO){
        return servico.atualizaProduto(id, produtoEntradaDTO);
    }

    @DeleteMapping("/deletar/id/{id}")
    public void deletarProduto(@PathVariable("id") UUID id){
        servico.deletarProduto(id);
    }
}
