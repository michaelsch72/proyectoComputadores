package ms.com.ch.web;

import lombok.extern.slf4j.Slf4j;
import ms.com.ch.domain.Computer;
import ms.com.ch.servicio.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/")
    public String inicio(Model model) {
        var computadores = computerService.listarcomputers();

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("computadores", computadores);

        return "index";
    }

    @GetMapping("/AgregarComputador")

    public String agregar(Computer computer) {
        return "AgregarComputador";
    }

    @PostMapping("/guardar")
    public String guardar(Computer computer) {
        computerService.guardar(computer);
        return "redirect:/";
    }

    @GetMapping("/editar/{Id}")
    public String Editar(Computer computer, Model model) {
        computer = computerService.encontrarComputer(computer);
        model.addAttribute("computer", computer);
        return "AgregarComputador";
    }

    @GetMapping("/eliminar/{Id}")
    public String eliminar(Computer computer) {
        computerService.eliminar(computer);
        return "redirect:/";
    }
}
