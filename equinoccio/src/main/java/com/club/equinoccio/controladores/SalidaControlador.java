
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Salida;
import com.club.equinoccio.servicios.SalidaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller 

public class SalidaControlador {
    private final SalidaServicio salidaServicio;
    
    public SalidaControlador (SalidaServicio salidaServicio){
        this.salidaServicio = salidaServicio;
    }

    @GetMapping("/salida")
    public ModelAndView listar_salidas(){
        ModelAndView mv= new ModelAndView ("list-salidas");
        mv.addObject("salidas", salidaServicio.buscarTodos());
        return mv;
    }
    
    @PostMapping("/salida/save")
    public RedirectView guardar_salida(Salida salida) throws Exception{
        salidaServicio.guardar(salida);
        return new RedirectView("list_salidas");
    }
    @GetMapping("/salida/form/{id}")
    public ModelAndView editar (Salida salida) throws Exception {
        ModelAndView mv = new ModelAndView("form-salidas");
        mv.addObject("salida", salida);
        return mv;
    }
//    @GetMapping("/usuario/eliminar/{id} ")
    
//    public ModelAndView eliminar (Salida salida){
//        ModelAndView mv= new ModelAndView("list-salidas");
//        mv.addObject("salida",salida);
//        return mv;
//                           
//    }
//    @GetMapping("/usuario/eliminar/{id}")
//    public RedirectView eliminar (@PathVariable("id") String id, RedirectAttributes attributes){
//        RedirectView redirectView = new RedirectView("salida");
//        return redirectView;
//    }
}
