package br.senac.projeto.controllers;

import br.senac.projeto.entitys.Produtos;
import br.senac.projeto.useCases.produtos.ProdutosService;
import br.senac.projeto.useCases.produtos.domains.ProdutosRequestDom;
import br.senac.projeto.useCases.produtos.domains.ProdutosResponseDom;
import br.senac.projeto.useCases.produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosRepository produtosRepository;
    @Autowired
    private ProdutosService produtosService;
    @PostMapping("/cadastrar")
    public ResponseEntity <?> cadastrarProduto(@RequestBody ProdutosRequestDom produto){
        try {
            return ResponseEntity.ok(produtosService.criarProduto(produto));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Erro não mapeado: " + e.getMessage());
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Produtos>> listarTodosProdutos() {
        List<Produtos> produtos = produtosRepository.findAll();
        return ResponseEntity.ok(produtos);
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutosRequestDom produto) {
        try {
            return ResponseEntity.ok(produtosService.atualizarProduto(id, produto));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro não mapeado: " + e.getMessage());
        }
    }
}
