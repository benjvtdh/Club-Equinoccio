/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Rol;
import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.servicios.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/register")
public class UsuarioControlador {
    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
    
    
    @GetMapping
    public ModelAndView crear(){  
        Usuario usuario = new Usuario();
        ModelAndView mv = new ModelAndView("form-register");
        mv.addObject("usuario",usuario);
        return mv;
    }
    @PostMapping
    public String regitrar(Usuario usuario){
        usuario.setEstado(1);
        Rol rol = new Rol();
        rol.setPerfilId(3);
        usuario.agregar(rol);
        usuarioServicio.guardar(usuario);
        return "redirect:/";
    }
}
