/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Rol;
import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.repositorios.UsuarioRepositorio;
import com.club.equinoccio.servicios.UsuarioServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsuarioControlador {
    
    @Autowired
    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
    
    //Controlador para listar los usuarios
    @GetMapping("/perfil")
    public ModelAndView perfil(Authentication auth, HttpSession session) throws Exception {
    
        
        String username = auth.getName();
//        if(session.getAttribute("usuario") == null){
        Usuario usuario = usuarioServicio.buscarPorUsername(username);
        usuario.setPassword(null);
        System.out.println("usuario: "+ usuario.getUsername());
        ModelAndView mv = new ModelAndView("panel_perfil");
        mv.addObject("usuario",usuario);
        
            
//        }
        
        
        return mv;
        
        
    }
    
    @GetMapping("/perfil/lista-usuarios")
    public ModelAndView listar_usuarios(){
        ModelAndView mv = new ModelAndView("list-users");
        mv.addObject("usuarios", usuarioServicio.buscarTodos());
        return mv;
    }
    
//     Controlador para editar un usuario
//    @PostMapping("/perfil/save")
//    public RedirectView actualizarUsuario(Usuario usuario) throws Exception{
//        usuarioServicio.guardar(usuario);
//        return new RedirectView("/perfil",true);
//         
//    }
    
    // TODO ESTO QUEDA EN REPOSO
    
//    @GetMapping("/users/desactivate/{id}")
//    public String desactivar(Usuario usuario, Model model) throws Exception{
//        usuario = usuarioServicio.buscar(usuario.getId());
//        
//        Desactivando cuenta, ya que 0 = false
//        usuario.setEstado(0);
//        usuarioServicio.guardar(usuario);
//        return "redirect:/users";
//        
//    }
//    
//    @GetMapping("/users/activate/{id}")
//    public String activar(Usuario usuario, Model model) throws Exception{
//        usuario = usuarioServicio.buscar(usuario.getId());
//        
//        Activuar cuenta, ya que 1 = true
//        usuario.setEstado(1);
//        usuarioServicio.guardar(usuario);
//        return "redirect:/users";
//        
//    }
    
    
}
