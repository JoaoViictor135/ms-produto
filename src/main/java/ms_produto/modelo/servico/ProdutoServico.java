package ms_produto.modelo.servico;

import ms_produto.dtos.CaracteristicaRetornoDTO;
import ms_produto.dtos.ProdutoEntradaDTO;
import ms_produto.dtos.ProdutoRetornoDTO;
import ms_produto.modelo.entidades.Caracteristica;
import ms_produto.modelo.entidades.Grupo;
import ms_produto.modelo.entidades.Produto;
import ms_produto.modelo.entidades.Unidade;
import ms_produto.modelo.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServico {

    @Autowired private ProdutoRepositorio repositorio;
    @Autowired private CaracteristicaServico caracteristicaServico;
    @Autowired private GrupoServico grupoServico;
    @Autowired private UnidadeServico unidadeServico;

    public ProdutoRetornoDTO criarProduto(ProdutoEntradaDTO produtoEntrada){
        Caracteristica caracteristica = null;
        if(produtoEntrada.getCaracteristica() != null && produtoEntrada.getCaracteristica().getCodigo() != "") {
            caracteristica = caracteristicaServico.buscarCaracteristicaPorCodigo(produtoEntrada.getCaracteristica().getCodigo());
        }
        Grupo grupo = null;
        if(produtoEntrada.getGrupo() != null && produtoEntrada.getGrupo().getCodigo() != "") {
            grupo = grupoServico.buscarGrupoPorCodigo(produtoEntrada.getGrupo().getCodigo());
        }
        Unidade unidade = null;
        if(produtoEntrada.getUnidade() != null && produtoEntrada.getUnidade().getCodigo() != "") {
            unidade = unidadeServico.buscarUnidadePorCodigo(produtoEntrada.getUnidade().getCodigo());
        }
        Produto produto = repositorio.save(preencherProduto(caracteristica, unidade, grupo, produtoEntrada));
        ProdutoRetornoDTO produtoRetornoDTO = parseEntidadeParaDTO(produto);
        if(caracteristica != null) {
            produtoRetornoDTO.setCaracteristica(caracteristicaServico.parseEntidadeParaDTO(caracteristica));
        }
        if (grupo != null) {
            produtoRetornoDTO.setGrupo(grupoServico.parseEntidadeParaDTO(grupo));
        }
        if(unidade != null) {
            produtoRetornoDTO.setUnidade(unidadeServico.parseEntidadeParaDTO(unidade));
        }
        return produtoRetornoDTO;
    }

    public List<ProdutoRetornoDTO> retornarListaProduto(){
        List<Produto> listaProduto = repositorio.findAll();
        List<ProdutoRetornoDTO> produtoRetornoDTOS = new ArrayList<>();
        for(int i=0;i < listaProduto.size();i++){
            Produto produto = listaProduto.get(i);
            produtoRetornoDTOS.add(parseEntidadeParaDTO(produto));
        }
        return produtoRetornoDTOS;
    }

    public ProdutoRetornoDTO atualizaProduto(UUID id, ProdutoEntradaDTO produtoEntradaDTO){
        Produto produto = retornarProduto(id);
        produto.setValorVenda(produtoEntradaDTO.getValorVenda());
        produto.setFoto(produtoEntradaDTO.getFoto());
        produto.setComplemento(produtoEntradaDTO.getComplemento());
        produto.setNomeProduto(produtoEntradaDTO.getNomeProduto());
        produto.setValorCusto(produtoEntradaDTO.getValorCusto());
        produto.setCodigoBarra(produtoEntradaDTO.getCodigoBarra());
        produto.setCodigo(produtoEntradaDTO.getCodigo());
        return parseEntidadeParaDTO(repositorio.save(produto));
    }

    public void deletarProduto(UUID id){
        repositorio.delete(retornarProduto(id));
    }

    public ProdutoRetornoDTO buscarProdutoPorId(UUID id){
        return parseEntidadeParaDTO(retornarProduto(id));
    }

    private ProdutoRetornoDTO parseEntidadeParaDTO(Produto produto){
        ProdutoRetornoDTO produtoRetorno = new ProdutoRetornoDTO();
        produtoRetorno.setId(produto.getId());
        produtoRetorno.setNomeProduto(produto.getNomeProduto());
        produtoRetorno.setCodigo(produto.getCodigo());
        produtoRetorno.setFoto(produto.getFoto());
        produtoRetorno.setComplemento(produto.getComplemento());
        produtoRetorno.setCodigoBarra(produto.getCodigoBarra());
        produtoRetorno.setValorCusto(produto.getValorCusto());
        produtoRetorno.setValorVenda(produto.getValorVenda());
        return produtoRetorno;
    }

    private Produto retornarProduto(UUID id){
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    private Produto preencherProduto(Caracteristica caracteristica, Unidade unidade, Grupo grupo, ProdutoEntradaDTO produtoEntradaDTO){
        Produto produto = new Produto();
        produto.setNomeProduto(produtoEntradaDTO.getNomeProduto());
        produto.setCodigo(produtoEntradaDTO.getCodigo());
        produto.setFoto(produtoEntradaDTO.getFoto());
        produto.setComplemento(produtoEntradaDTO.getComplemento());
        produto.setCodigoBarra(produtoEntradaDTO.getCodigoBarra());
        produto.setValorCusto(produtoEntradaDTO.getValorCusto());
        produto.setValorVenda(produtoEntradaDTO.getValorVenda());
        produto.setCaracteristica(caracteristica);
        produto.setUnidade(unidade);
        produto.setGrupo(grupo);
        return produto;
    }
}
