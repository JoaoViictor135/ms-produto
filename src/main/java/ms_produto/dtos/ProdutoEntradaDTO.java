package ms_produto.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntradaDTO {

    private String codigo;

    @NotBlank
    private String nomeProduto;

    private String complemento;

    private BigDecimal valorCusto;

    private BigDecimal valorVenda;

    private String foto;

    private String codigoBarra;
}
