package br.edu.ifba.soa.controlador;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.soa.modelo.Usuario;

public class ControladorUsuario extends Controlador<Usuario> {

    @Override
    public List<String> listarErros(Usuario entidade) {
        List<String> erros = new ArrayList<>();

        if(!entidade.getEmail().contains("@")) {
            erros.add("Email inválido");
        }
        if(entidade.getNome().length() < 3) {
            erros.add("Nome inválido");
        }

        return erros;
    }

    @Override
    public List<Usuario> listar() {
        return persistencia.listar();
    }
    
}
