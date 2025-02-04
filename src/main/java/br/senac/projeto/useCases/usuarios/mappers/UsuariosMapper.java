package br.senac.projeto.useCases.usuarios.mappers;

import br.senac.projeto.entitys.Usuarios;
import br.senac.projeto.useCases.usuarios.domains.UsuariosRequestDom;
import br.senac.projeto.useCases.usuarios.domains.UsuariosResponseDom;

public class UsuariosMapper {
    public static Usuarios
    usuariosRequestDomToUsuarios(UsuariosRequestDom input){
        Usuarios output = new Usuarios();
        output.setLogin(input.getLogin());
        output.setSenha(input.getSenha());

        return output;
    }
    public static UsuariosResponseDom
    usuariosToUsuariosResponseDom(Usuarios input) {
        UsuariosResponseDom output = new UsuariosResponseDom();
        output.setId(input.getId());
        output.setLogin(input.getLogin());

        return output;
    }
}
