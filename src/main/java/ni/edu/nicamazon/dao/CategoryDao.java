package ni.edu.nicamazon.dao;
import ni.edu.nicamazon.entities.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends PagingAndSortingRepository<Category, Long> {

}
