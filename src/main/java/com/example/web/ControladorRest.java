
package com.example.web;

import com.example.domain.Individuo;
import com.example.servicio.IndividuoServicio;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
  @Slf4j
public class ControladorRest {
    
    @Autowired
    private IndividuoServicio individuoServicio;
    
    
    
    @GetMapping ("/")
    public String comienzo (Model model){
        
        List<Individuo> individuos = individuoServicio.listaIndividuos();

        log.info ("Estoy ejecutando el primer controlador MVC");
        model.addAttribute("individuos" , individuos);
       return  "indice";
    }
    
    
    @GetMapping("/anexar")
    public String anexar (Individuo individuo){
     return "cambiar";
   }
    
    @PostMapping("/salvar")
    public String salvar (Individuo individuo){
        individuoServicio.salvar(individuo);  
        return "redirect:/";
    }
      @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id_individuo, Model model) {
        // Obtener el individuo a editar usando el servicio
        Individuo individuo = individuoServicio.localizarIndividuo(id_individuo);
        // Agregar el individuo al modelo
        model.addAttribute("individuo", individuo);
        // Devolver la vista para el formulario de edición
        return "editar";
    }
     @PostMapping("/guardarEdicion")
    public String guardarEdicion(@ModelAttribute("individuo") Individuo individuo) {
        // Guardar los cambios en el individuo utilizando el servicio
        individuoServicio.salvar(individuo);
        // Redirigir a la página principal
        return "redirect:/";
    }
    
    @GetMapping ("/borrar/{id}")
    public String borrar(@PathVariable("id") Long id_individuo){
        individuoServicio.borrar(id_individuo);
        return"redirect:/";
        }
    
}
