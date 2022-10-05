package ms.com.ch.servicio;

import java.util.List;
import ms.com.ch.domain.Client;

public interface ClientService {

    public List<Client> listarclient();

    public void guardar(Client client);

    public void eliminar(Client client);

    public Client encontrarClient(Client client);
}
