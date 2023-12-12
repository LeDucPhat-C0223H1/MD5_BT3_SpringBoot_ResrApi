package ra.springboot_restfull_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.springboot_restfull_crud.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,String> {
}
