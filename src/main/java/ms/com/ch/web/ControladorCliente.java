
package ms.com.ch.web;
import lombok.extern.slf4j.Slf4j;
import ms.com.ch.domain.Client;
import ms.com.ch.domain.Computer;
import ms.com.ch.servicio.ClientService;
//import ms.com.ch.servicio.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class ControladorCliente {
    @Autowired
    //private ComputerService computerService;
    private ClientService clientservice;
    @GetMapping("/Cliente")
    public String Cliente(Model model) {
        var cliente = clientservice.listarclient();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("client",cliente);
        return "Cliente";
    }

    @GetMapping("/AñadirCliente")

    public String agregarCliente(Client client) {
        return "AñadirCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(Client client) {
        clientservice.guardar(client);
        return "redirect:/Cliente";
    }

    @GetMapping("/editarclient/{idcliente}")
    public String EditarCliente(Client client, Model model) {
        client = clientservice.encontrarClient(client);
        model.addAttribute("client", client);
        return "AñadirCliente";
    }

    @GetMapping("/eliminarClient/{idcliente}")
    public String eliminarClient(Client client) {
        clientservice.eliminar(client);
        return "redirect:/Cliente";
    }
    
    
}
