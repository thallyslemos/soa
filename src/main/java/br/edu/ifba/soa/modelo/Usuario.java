package br.edu.ifba.soa.modelo;

public class Usuario{
    
    private String id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(String id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(){}

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        if(id == null) return "Usuario não cadastrado";
            return "Usuario {email=" + email + ", id=" + id + ", nome=" + nome + "}";
    }
}
