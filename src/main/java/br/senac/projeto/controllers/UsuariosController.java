package br.senac.projeto.controllers;

import  br.senac.projeto.entitys.Usuarios;
import br.senac.projeto.useCases.usuarios.UsuariosService;
import br.senac.projeto.useCases.usuarios.domains.UsuariosRequestDom;
import br.senac.projeto.useCases.usuarios.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private UsuariosService usuariosService;
    @PostMapping("/cadastrar")
    public ResponseEntity<?>
    cadastrarUsuario(@RequestBody UsuariosRequestDom usuario) {

        try {
            return ResponseEntity
                    .ok(usuariosService.criarUsuario(usuario));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro não mapeado: " + e.getMessage());
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Usuarios>> listarTodosUsuarios() {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/listar/{login}")
    public ResponseEntity<?> listarUsuarioPorLogin(@PathVariable("login") String login) {
        try {
            return ResponseEntity.ok(usuariosService.buscarPorLogin(login));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro não mapeado: " + e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuariosRequestDom usuario){
        try{
            return ResponseEntity.ok(usuariosService.loginUsuario(usuario));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Erro não mapeado: " + e.getMessage());
        }
    }
}

