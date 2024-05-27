package thanhnt.web.services;

import java.util.List;

import org.springframework.data.domain.Page;

import thanhnt.web.entities.Product;

public interface ProductService {
	List<Product> getAll();
	Boolean create(Product product);
	Product findById(Integer id);
	Boolean update(Product product);
	Boolean delete(Integer id);
	List<Product> searchProduct(String keyword);
	Page<Product> getAll(Integer pageNo);
	Page<Product> searchProduct(String keyword, Integer pageNo);
}
