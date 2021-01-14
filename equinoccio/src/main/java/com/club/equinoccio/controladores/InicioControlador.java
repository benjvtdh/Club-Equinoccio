
package com.club.equinoccio.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping("/")
public class InicioControlador {
    
    @GetMapping
    public ModelAndView inicio(){
    ModelAndView mv = new ModelAndView("index");
    return mv;
    }
    
}
