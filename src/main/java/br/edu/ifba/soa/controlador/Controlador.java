package br.edu.ifba.soa.controlador;

import java.util.List;

import br.edu.ifba.soa.modelo.Persistencia;
import br.edu.ifba.soa.modelo.Resultado;

public abstract class Controlador<Entidade> {
    
    Persistencia<Entidade> persistencia;

    public void iniciarPersistencia(Persistencia<Entidade> persistencia) {
        this.persistencia = persistencia;
    }

    public Resultado gravar(Entidade entidade) {
        Resultado resultado = Resultado.ERRO;

        List<String> erros = listarErros(entidade);
        if (erros.isEmpty()) {
            resultado = persistencia.gravar(entidade);
        } else {
            System.out.println("Erros:" + erros);
        }

        return resultado;
    }

    public abstract List<String> listarErros(Entidade entidade);

    public abstract List<Entidade> listar();
}
