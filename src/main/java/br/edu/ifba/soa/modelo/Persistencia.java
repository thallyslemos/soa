package br.edu.ifba.soa.modelo;

import java.util.List;

public interface Persistencia<Entidade> {
    public Resultado gravar(Entidade entidade);
    public List<Entidade> listar();
}
