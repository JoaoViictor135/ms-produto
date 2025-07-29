package ms_produto.modelo.repositorio;

import ms_produto.modelo.entidades.Caracteristica;
import ms_produto.modelo.entidades.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GrupoRepositorio extends JpaRepository<Grupo, UUID> {
    Optional<Grupo> findByCodigo(String codigo);
}
