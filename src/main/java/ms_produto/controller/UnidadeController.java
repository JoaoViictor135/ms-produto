package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.UnidadeEntradaDTO;
import ms_produto.dtos.UnidadeRetornoDTO;
import ms_produto.modelo.servico.UnidadeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired UnidadeServico servico;

    @PostMapping
    public UnidadeRetornoDTO criarUnidade(@RequestBody @Valid UnidadeEntradaDTO unidadeEntrada){
        return servico.criarUnidade(unidadeEntrada);
    }

    @GetMapping
    public List<UnidadeRetornoDTO> retornarLista(){
        return servico.retornarListaUnidade();
    }
}
