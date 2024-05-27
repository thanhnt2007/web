package thanhnt.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thanhnt.web.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%")
	List<Product> searchProduct(String keyword);
}
