package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.CaracteristicaEntradaDTO;
import ms_produto.dtos.CaracteristicaRetornoDTO;
import ms_produto.modelo.repositorio.CaracteristicaRepositorio;
import ms_produto.modelo.servico.CaracteristicaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caracteristica")
public class CaracteristicaController {

    @Autowired CaracteristicaServico servico;

    @PostMapping
    public CaracteristicaRetornoDTO criarCaracteristica(@RequestBody @Valid CaracteristicaEntradaDTO caracteristicaEntrada){
        return servico.criarCaracteristica(caracteristicaEntrada);
    }
}
