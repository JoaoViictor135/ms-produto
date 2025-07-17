package ms_produto.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String codigo;

    private String descricao;

    private LocalDateTime dtExclusao;

    @OneToMany(mappedBy = "caracteristica")
    private Set<Produto> produtoSet = new HashSet<>();


}
