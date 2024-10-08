package br.senac.projeto.useCases.produtos.mappers;

import br.senac.projeto.entitys.Produtos;
import br.senac.projeto.useCases.produtos.domains.ProdutosRequestDom;
import br.senac.projeto.useCases.produtos.domains.ProdutosResponseDom;

public class ProdutosMapper {

    public static Produtos
    produtosRequestDomToProdutos(ProdutosRequestDom input) {
        Produtos output = new Produtos();

        output.setNome(input.getNome());
        output.setDescricao(input.getDescricao());
        output.setPreco(input.getPreco());

        return output;
    }

    public static ProdutosResponseDom
    produtosToProdutosResponseDom(Produtos input) {
        ProdutosResponseDom output = new ProdutosResponseDom();

        output.setId(input.getId());
        output.setNome(input.getNome());
        output.setDescricao(input.getDescricao());
        output.setPreco(input.getPreco());

        return output;
    }
}
