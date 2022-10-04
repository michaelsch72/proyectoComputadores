package ms.com.ch.servicio;

import java.util.List;
import ms.com.ch.dao.computerDao;
import ms.com.ch.domain.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private computerDao computerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Computer> listarcomputers() {
        return (List<Computer>) computerDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Computer computer) {
        computerDao.save(computer);
    }

    @Override
    @Transactional
    public void eliminar(Computer computer) {
        computerDao.delete(computer);
    }

    @Override
    @Transactional(readOnly = true)
    public Computer encontrarComputer(Computer persona) {
        return computerDao.findById(persona.getId()).orElse(null);
    }

}
