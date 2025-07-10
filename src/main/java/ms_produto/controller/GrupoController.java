package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.GrupoEntradaDTO;
import ms_produto.dtos.GrupoRetornoDTO;
import ms_produto.modelo.servico.GrupoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired GrupoServico servico;

    @PostMapping
    public GrupoRetornoDTO criarGrupo(@RequestBody @Valid GrupoEntradaDTO grupoEntrada){
        return servico.criarGrupo(grupoEntrada);
    }
}
