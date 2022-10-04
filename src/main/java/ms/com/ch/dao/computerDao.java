package ms.com.ch.dao;

import ms.com.ch.domain.Computer;
import org.springframework.data.repository.CrudRepository;

public interface computerDao extends CrudRepository<Computer, Long>{
    
}
