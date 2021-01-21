package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.servicios.UsuarioServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    
//    @GetMapping("/index")
//    public String recuperar(Authentication auth, HttpSession session){
//        String username = auth.getName();
//        if(session.getAttribute("usuario") == null ){
//            Usuario usuario = usuarioServicio.buscarPorNombre(username);
//            usuario.setPassword(null);
//            System.out.println(usuario);
//            session.setAttribute("usuario", usuario);
//            
//        }
//        return "redirect:/";
//        
//        
//        
//    }
}
