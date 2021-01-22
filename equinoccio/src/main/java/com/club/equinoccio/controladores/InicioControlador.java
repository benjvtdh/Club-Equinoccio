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
    @GetMapping("/")
    public ModelAndView inicio(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    
    @GetMapping("/index")
    public String recuperar(Authentication auth,HttpSession session) throws Exception{
        String username = auth.getName();
//        String id = (String) session.getAttribute("id");
//        System.out.println(session);
//        System.out.println("id: " + session.getAttribute("id"));
//        if(id == null){
//            throw new Exception("El id es nulo");
//        }
////        Usuario usuario = usuarioServicio.buscar(id);
//        usuario.setPassword(null);
        if(session.getAttribute("usuario") == null){
            Usuario usuario = usuarioServicio.buscarPorUsername(username);
            usuario.setPassword(null);
            System.out.println("usuario: "+ usuario.getUsername());
            session.setAttribute("usuario", usuario);
        }
        return "redirect:/";
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("usuario", usuario);
//        return mv;
//        
        
        
    }
}
