package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.servicios.SalidaServicio;
import com.club.equinoccio.servicios.UsuarioServicio;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InicioControlador {
    
    @Autowired
    private final UsuarioServicio usuarioServicio;
    
    @Autowired
    private final SalidaServicio salidaServicio;

    public InicioControlador(UsuarioServicio usuarioServicio, SalidaServicio salidaServicio) {
        this.usuarioServicio = usuarioServicio;
        this.salidaServicio = salidaServicio;
    }

    
    @GetMapping("/")
    public ModelAndView inicio(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("salidas", salidaServicio.buscarTodos());
        return mv;
    }
    
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    
    // Controlador para recuperar el usuario al auntenticarse en el index
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
            System.out.println("objeto usuario" + usuario);
            session.setAttribute("usuario", usuario);
        }
        return "redirect:/";
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("usuario", usuario);
//        return mv;
//        
        
        
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return "redirect:/";
        
    }
}
