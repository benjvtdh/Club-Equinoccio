package com.club.equinoccio;

import com.club.equinoccio.entidades.Rol;
import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.repositorios.UsuarioRepositorio;
import com.club.equinoccio.servicios.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EquinoccioApplication implements CommandLineRunner{

    @Autowired
    UsuarioServicio usuarioServicio;

    public static void main(String[] args) {
        SpringApplication.run(EquinoccioApplication.class, args);
    }
    

    public void run(String... args) throws Exception {
        crearUsuarioConDosRoles();
        

    }

    public void crearUsuarioConDosRoles() {
        Usuario usuario = new Usuario();
        usuario.setUsername("fernanda");
        usuario.setPassword("12345");
        usuario.setNombres("Fernanda");
        usuario.setApellidos("Cortes");
        usuario.setCorreo("fernanda@gmail.com");

        Rol rol1 = new Rol();
        rol1.setPerfilId(2);

        Rol rol2 = new Rol();
        rol2.setPerfilId(3);
        
        usuario.setEstado(1);

        usuario.agregar(rol1);
        usuario.agregar(rol2);
        usuarioServicio.guardar(usuario);

    }

}
