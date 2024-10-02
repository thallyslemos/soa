package br.edu.ifba.soa.servicos;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifba.soa.controlador.Controlador;
import br.edu.ifba.soa.controlador.ControladorUsuario;
import br.edu.ifba.soa.modelo.PersistenciaUsuario;
import br.edu.ifba.soa.modelo.Resultado;
import br.edu.ifba.soa.modelo.Usuario;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuario")
public class ServicoUsuario {

    private static Controlador<Usuario> controlador = null;
    public static Controlador<Usuario> getInsControlador() {
        if (controlador == null) {
            controlador = new ControladorUsuario();
            controlador.iniciarPersistencia(new PersistenciaUsuario());
        }
        return controlador;
    }

    @POST
    @Path("{nome}/{email}/{senha}")
    @Produces(MediaType.TEXT_PLAIN)
    public String gravar(@PathParam("nome")String nome, @PathParam("email")String email, @PathParam("senha")String senha) {
       System.out.println("Gravando usuário...");
        String resposta = "Usuário gravado com sucesso!";

       Resultado resultado = this.getInsControlador().gravar(new Usuario(null, nome, email, senha));
        if(resultado == Resultado.SUCESSO) {
            resultado = resultado;
        }

        return resposta;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        System.out.println("Listando usuários...");
        List<Usuario> lista = this.getInsControlador().listar();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            json = mapper.writeValueAsString(lista);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
