package ms_produto.modelo.repositorio;

import ms_produto.modelo.entidades.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CaracteristicaRepositorio extends JpaRepository<Caracteristica, UUID> {
}
