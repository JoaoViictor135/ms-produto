package ms_produto.controller;

import jakarta.validation.Valid;
import ms_produto.dtos.CaracteristicaEntradaDTO;
import ms_produto.dtos.CaracteristicaRetornoDTO;
import ms_produto.modelo.repositorio.CaracteristicaRepositorio;
import ms_produto.modelo.servico.CaracteristicaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/caracteristica")
public class CaracteristicaController {

    @Autowired CaracteristicaServico servico;

    @PostMapping
    public CaracteristicaRetornoDTO criarCaracteristica(@RequestBody @Valid CaracteristicaEntradaDTO caracteristicaEntrada){
        return servico.criarCaracteristica(caracteristicaEntrada);
    }

    @GetMapping
    public List<CaracteristicaRetornoDTO> retornarLista(){
        return servico.retornarListaCaracteristica();
    }

    @GetMapping("/buscar-por-id/id/{id}")
    public CaracteristicaRetornoDTO buscarCaracteristicaPorId(@PathVariable ("id") UUID id){
        return servico.buscarCaracteristicaPorId(id);
    }

    @PutMapping("/id/{id}")
    public CaracteristicaRetornoDTO atualizarCaracteristica(@PathVariable("id") UUID id, @RequestBody @Valid CaracteristicaEntradaDTO caracteristicaEntradaDTO){
        return servico.atualizarCaracteristica(id, caracteristicaEntradaDTO);
    }

    @DeleteMapping("/deletar/id/{id}")
    public void deletarCaracteristica(@PathVariable("id") UUID id){
        servico.deletarCaracteristica(id);
    }
}
