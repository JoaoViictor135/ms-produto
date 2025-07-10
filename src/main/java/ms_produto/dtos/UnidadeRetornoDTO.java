package ms_produto.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeRetornoDTO {

    private UUID id;

    private String codigo;

    private String descricao;
}
