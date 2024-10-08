package br.senac.projeto.useCases.produtos;

import br.senac.projeto.entitys.Produtos;
import br.senac.projeto.useCases.produtos.domains.ProdutosRequestDom;
import br.senac.projeto.useCases.produtos.domains.ProdutosResponseDom;
import br.senac.projeto.useCases.produtos.mappers.ProdutosMapper;
import br.senac.projeto.useCases.produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public ProdutosResponseDom criarProduto(ProdutosRequestDom produto) {

        Produtos produtosPersist = ProdutosMapper.produtosRequestDomToProdutos(produto);

        Produtos produtosResult = produtosRepository.save(produtosPersist);

        return ProdutosMapper.produtosToProdutosResponseDom(produtosResult);
    }

    public ProdutosResponseDom atualizarProduto(Long id, ProdutosRequestDom alterado) throws Exception{

        Optional<Produtos> encontrado = produtosRepository.findById(id);

        if (encontrado.isPresent()) {
            Produtos produtosPersist = encontrado.get();

            produtosPersist.setNome(alterado.getNome());
            produtosPersist.setDescricao(alterado.getDescricao());
            produtosPersist.setPreco(alterado.getPreco());

            Produtos produtosResult = produtosRepository.save(produtosPersist);

            return ProdutosMapper.produtosToProdutosResponseDom(produtosResult);

        }
        throw new Exception("Produto não encontrado com id: " + id);
    }
}
