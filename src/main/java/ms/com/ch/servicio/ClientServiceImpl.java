package ms.com.ch.servicio;

import java.util.List;
import ms.com.ch.dao.ClientDao;
import ms.com.ch.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Client> listarclient() {
        return (List<Client>) clientDao.findAll();
    }

    @Override
    public void guardar(Client client) {
        clientDao.save(client);
    }

    @Override
    public void eliminar(Client client) {
        clientDao.delete(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client encontrarClient(Client client) {
        return clientDao.findById(client.getIdcliente()).orElse(null);

    }

}
