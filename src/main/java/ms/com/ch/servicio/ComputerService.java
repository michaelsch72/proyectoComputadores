package ms.com.ch.servicio;

import java.util.List;
import ms.com.ch.domain.Computer;

public interface ComputerService {
    
    public List<Computer> listarcomputers();
    
    public void guardar(Computer computer);
    
    public void eliminar(Computer computer);
    
    public Computer encontrarComputer(Computer computer);
}
