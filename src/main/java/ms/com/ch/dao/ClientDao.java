
package ms.com.ch.dao;

import ms.com.ch.domain.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientDao extends CrudRepository<Client, Long> {
    
}
