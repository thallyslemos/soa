package br.edu.ifba.soa.modelo;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class PersistenciaUsuario implements Persistencia<Usuario> {
    private final Map<String, Usuario> usuarios;

    public PersistenciaUsuario() {
        usuarios = new TreeMap<>();
    }

    @Override
    public Resultado gravar(Usuario entidade) {
        String id = UUID.randomUUID().toString();
        entidade.setId(id);
        usuarios.put(id, entidade);
        return Resultado.SUCESSO;
    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<Usuario>(usuarios.values());
    }
}
