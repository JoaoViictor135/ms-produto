package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.CaracteristicaRetornoDTO;
import ms_produto.dtos.GrupoEntradaDTO;
import ms_produto.dtos.GrupoRetornoDTO;
import ms_produto.modelo.servico.GrupoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired GrupoServico servico;

    @PostMapping
    public GrupoRetornoDTO criarGrupo(@RequestBody @Valid GrupoEntradaDTO grupoEntrada){
        return servico.criarGrupo(grupoEntrada);
    }

    @GetMapping
    public List<GrupoRetornoDTO> retornarLista() {
        return servico.retornarListaGrupo();
    }
}
