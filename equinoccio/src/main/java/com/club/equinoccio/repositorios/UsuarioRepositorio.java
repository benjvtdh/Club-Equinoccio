
package com.club.equinoccio.repositorios;

import com.club.equinoccio.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
    Usuario findByUsername(String username);
}
