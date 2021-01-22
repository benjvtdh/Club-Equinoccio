package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.servicios.UsuarioServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InicioControlador {
    
    @Autowired
    private final UsuarioServicio usuarioServicio;

    public InicioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
    
    @GetMapping
    public ModelAndView inicio() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    
    @GetMapping("/index")
    public String recuperar(Authentication auth, HttpSession session){
        String username = auth.getName();
        System.out.println("Nombre del usuario: " + username);
        for (GrantedAuthority rol : auth.getAuthorities()) {
            System.out.println("ROL: " + rol.getAuthority());
        }
        
//        if(session.getAttribute("usuario") == null ){
//            UserDetails usuario = usuarioServicio.loadUserByUsername(username);
//            usuario.g
//            usuario.setPassword(null);
//            System.out.println(usuario);
//            session.setAttribute("usuario", usuario);
//            
//        }
        return "redirect:/";
        
        
        
    }
}
