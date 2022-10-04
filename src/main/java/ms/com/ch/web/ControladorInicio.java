package ms.com.ch.web;

import lombok.extern.slf4j.Slf4j;
import ms.com.ch.servicio.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private ComputerService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listarcomputers();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
}
