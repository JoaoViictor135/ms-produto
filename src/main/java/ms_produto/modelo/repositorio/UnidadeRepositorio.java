package ms_produto.modelo.repositorio;

import ms_produto.modelo.entidades.Caracteristica;
import ms_produto.modelo.entidades.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UnidadeRepositorio extends JpaRepository<Unidade, UUID> {
    Optional<Unidade> findByCodigo(String codigo);
}
