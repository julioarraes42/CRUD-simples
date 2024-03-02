package org.acme.julio_user.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.julio_user.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public void update(Usuario usuario) {
        Usuario entity = findById(usuario.getId());
        if (entity != null) {
            entity.setNome(usuario.getNome());
            entity.setEmail(usuario.getEmail());
        }
    }

}
