
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Rol;
import com.club.equinoccio.entidades.Usuario;
import com.club.equinoccio.servicios.UsuarioServicio;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class RegistrerControlador {
    
    private final UsuarioServicio usuarioServicio;

    public RegistrerControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
    // Controlador para crear un usuario
    @GetMapping("/register")
    public ModelAndView crear(){  
        Usuario usuario = new Usuario();
        ModelAndView mv = new ModelAndView("form-register");
        mv.addObject("usuario",usuario);
        return mv;
    }
    
    //Controlador para registrar o guardar un registro
    @PostMapping("/register")
    public RedirectView regitrar(
            HttpServletRequest request,
            @ModelAttribute Usuario usuario, 
            RedirectAttributes reAttr){
        
        usuario.setEstado(1);
        Rol rol = new Rol();
        rol.setPerfilId(3);
        usuario.agregar(rol);
        usuarioServicio.guardar(usuario);
        return new RedirectView("/",true);
        
        
        
        // Ignoren esta parte
        
//        reAttr.addFlashAttribute("usuario",usuario);
//        return new RedirectView("/register/sucess",true);
    }
    
//    @GetMapping("/register/sucess")
//    public RedirectView getSucess(HttpServletRequest request, RedirectAttributes ra){
//        Map<String, ? > inputFlashMap = RequestContextUtils.getInputFlashMap(request);
//        if(inputFlashMap != null){
//            Usuario usuario = (Usuario) inputFlashMap.get("usuario");
//            usuarioServicio.guardar(usuario);
//            
//            RedirectView rv =  new RedirectView("/",true);
//            ra.addFlashAttribute("msg", "El usuario fue registrado satisfactoriamente");
//            return rv;
//            
//        }
//        
//        else{
//            return new RedirectView("/register",true);
//        }
//                
//    }
}
