package ms_produto.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoRetornoDTO {

    private UUID id;

    private String codigo;

    private String descricao;

    private LocalDateTime dtExclusao;

}
