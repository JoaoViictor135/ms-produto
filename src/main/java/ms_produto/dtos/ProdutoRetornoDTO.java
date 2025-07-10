package ms_produto.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRetornoDTO {

    private UUID id;

    private String codigo;

    private String nomeProduto;

    private String complemento;

    private BigDecimal valorCusto;

    private BigDecimal valorVenda;

    private String foto;

    private String codigoBarra;
}
