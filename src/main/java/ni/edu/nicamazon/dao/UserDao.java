package ni.edu.nicamazon.dao;

import ni.edu.nicamazon.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    public User findByLogin(String userName);
}
