package org.acme.julio_user.resource;

import java.util.List;

import org.acme.julio_user.model.Usuario;
import org.acme.julio_user.repository.UsuarioRepository;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/usuario")
public class UsuarioResource {

    @Inject
    public UsuarioRepository usuarioRepository;

    @GET
    public List<Usuario> findAll() {
        return usuarioRepository.listAll();
    }

    @POST
    @Transactional
    public void create(Usuario usuario) {
        usuarioRepository.persist(usuario);
    }

    @PUT
    @Transactional
    public void update(Usuario usuario) {
        usuarioRepository.update(usuario);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        usuarioRepository.deleteById(id);
    }

}
