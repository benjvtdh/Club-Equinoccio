
package com.club.equinoccio.controladores;

import com.club.equinoccio.entidades.Salida;
import com.club.equinoccio.servicios.SalidaServicio;
import com.club.equinoccio.utileria.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
;
import org.springframework.web.servlet.view.RedirectView;


@Controller 
public class SalidaControlador {
    @Autowired
    private final SalidaServicio salidaServicio;
    
    public SalidaControlador (SalidaServicio salidaServicio){
        this.salidaServicio = salidaServicio;
    }

    @GetMapping("/salidas")
    public ModelAndView listar_salidas(){
        ModelAndView mv= new ModelAndView ("list-salidas");
        mv.addObject("salidas", salidaServicio.buscarTodos());
        return mv;
    }
    @GetMapping("/salidas/crear")
    public ModelAndView crear_salida(){
        Salida salida = new Salida();
        ModelAndView mv = new ModelAndView("form-salidas");
        mv.addObject("salida", salida);
        System.out.println("Se creo una salida");
        return mv;
    }
    @PostMapping("/salidas/save")
    public String guardar_salida(Salida salida , @RequestParam (required = false, name = "archivoImagen") MultipartFile multiPart) throws Exception{
        if (!multiPart.isEmpty()) {
            
            String ruta = "C:\\Users\\corte\\Documents\\Club-Equinoccio\\equinoccio\\src\\main\\resources\\static\\img\\img-salidas\\"; // Windows
            String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
            if (nombreImagen != null) { // La imagen si se subio
            // Procesamos la variable nombreImagen
                salida.setFoto(nombreImagen);
            }
            else {
                System.out.println("La iamgen es nula");
            }
        
    }
        else {
            System.out.println("To viene vacio");
        }
        salidaServicio.guardar(salida);
        return "redirect:/salidas";
    }
    @GetMapping("/salida/form/{id}")
    public ModelAndView editar (Salida salida) throws Exception {
        ModelAndView mv = new ModelAndView("form-salidas");
        mv.addObject("salida", salida);
        return mv;
    }
    @GetMapping("/salidas/{id}")
    public ModelAndView ver_salida(String id) throws Exception {
        ModelAndView mv = new ModelAndView("single-salida");
        Salida salida = salidaServicio.buscar(id);
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
