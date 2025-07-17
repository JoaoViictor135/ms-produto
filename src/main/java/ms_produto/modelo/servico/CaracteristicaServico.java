package ms_produto.modelo.servico;

import ms_produto.dtos.CaracteristicaEntradaDTO;
import ms_produto.dtos.CaracteristicaRetornoDTO;
import ms_produto.modelo.entidades.Caracteristica;
import ms_produto.modelo.repositorio.CaracteristicaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CaracteristicaServico {

    @Autowired CaracteristicaRepositorio repositorio;

    public CaracteristicaRetornoDTO criarCaracteristica(CaracteristicaEntradaDTO caracteristicaEntrada){
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setCodigo(caracteristicaEntrada.getCodigo());
        caracteristica.setDescricao(caracteristicaEntrada.getDescricao());
        return parseEntidadeParaDTO(caracteristica);
    }

    public List<CaracteristicaRetornoDTO> retornarListaCaracteristica(){
        List<Caracteristica> listaCaracteristica = repositorio.findAll();
        List<CaracteristicaRetornoDTO> caracteristicaRetornoDTOS = new ArrayList<>();
        for (int i=0;i < listaCaracteristica.size();i++){
            Caracteristica caracteristica = listaCaracteristica.get(i);
            caracteristicaRetornoDTOS.add(parseEntidadeParaDTO(caracteristica));
        }
        return caracteristicaRetornoDTOS;
    }

    public CaracteristicaRetornoDTO atualizarCaracteristica(UUID id, CaracteristicaEntradaDTO caracteristicaEntradaDTO){
        Caracteristica caracteristica = retornarCaracteristica(id);
        caracteristica.setCodigo(caracteristicaEntradaDTO.getCodigo());
        caracteristica.setDescricao(caracteristicaEntradaDTO.getDescricao());
        return parseEntidadeParaDTO(caracteristica);
    }

    public void deletarCaracteristica(UUID id){
        repositorio.delete(retornarCaracteristica(id));
    }

    public CaracteristicaRetornoDTO buscarCaracteristicaPorId(UUID id){
        return parseEntidadeParaDTO(retornarCaracteristica(id));
    }

    private CaracteristicaRetornoDTO parseEntidadeParaDTO(Caracteristica caracteristica){
        CaracteristicaRetornoDTO caracteristicaRetorno = new CaracteristicaRetornoDTO();
        caracteristicaRetorno.setId(caracteristica.getId());
        caracteristicaRetorno.setDescricao(caracteristica.getDescricao());
        caracteristicaRetorno.setCodigo(caracteristica.getCodigo());
        return caracteristicaRetorno;
    }

    private Caracteristica retornarCaracteristica(UUID id){
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Caracteristica não encontrada"));
    }
}
