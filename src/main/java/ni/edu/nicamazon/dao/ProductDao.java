package ni.edu.nicamazon.dao;

import ni.edu.nicamazon.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends PagingAndSortingRepository<Product, Long>{

    @Query("SELECT this FROM Product this WHERE this.category.id = :idCategory")
    public Page<Product> searchByCategoryId(Pageable pageable, @Param("idCategory") Long idCategory);
}
