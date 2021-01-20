package com.club.equinoccio.servicios;

import com.club.equinoccio.entidades.Rol;
import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.repositorios.UsuarioRepositorio;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicio implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio, BCryptPasswordEncoder encoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.encoder = encoder;
    }
    
    // Funcion para guardar usuario, con la contraseña encriptada
    @Transactional(rollbackFor = Exception.class)
    //recreando usuario//
    public void guardar(Usuario usuario) {
        //encriptando contraseña//
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        //guardando contraseña//
        usuarioRepositorio.save(usuario);
    }
    
    // Funcion para buscar todos los usuarios y listarlos
    public List<Usuario> buscarTodos(){
        return usuarioRepositorio.findAll();
    }
    
    //Funcion para cargar el usuario por username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));

        return new User(usuario.getUsername(), usuario.getPassword(), authorities);

    }

}
