
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Rol;
import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.servicios.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegistrerControlador {
    
    private final UsuarioServicio usuarioServicio;

    public RegistrerControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
    // Controlador para crear un usuario
    @GetMapping
    public ModelAndView crear(){  
        Usuario usuario = new Usuario();
        ModelAndView mv = new ModelAndView("form-register");
        mv.addObject("usuario",usuario);
        return mv;
    }
    
    //Controlador para registrar o guardar un registro
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
