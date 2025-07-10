package ms_produto.modelo.servico;

import ms_produto.dtos.CaracteristicaEntradaDTO;
import ms_produto.dtos.CaracteristicaRetornoDTO;
import ms_produto.modelo.entidades.Caracteristica;
import ms_produto.modelo.repositorio.CaracteristicaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicaServico {

    @Autowired CaracteristicaRepositorio repositorio;

    public CaracteristicaRetornoDTO criarCaracteristica(CaracteristicaEntradaDTO caracteristicaEntrada){
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setCodigo(caracteristicaEntrada.getCodigo());
        caracteristica.setDescricao(caracteristicaEntrada.getDescricao());

        caracteristica = repositorio.save(caracteristica);

        CaracteristicaRetornoDTO caracteristicaRetorno = new CaracteristicaRetornoDTO();
        caracteristicaRetorno.setId(caracteristica.getId());
        caracteristicaRetorno.setDescricao(caracteristica.getDescricao());
        caracteristicaRetorno.setCodigo(caracteristica.getCodigo());
        return caracteristicaRetorno;


    }




}
