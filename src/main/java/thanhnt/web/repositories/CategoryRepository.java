package thanhnt.web.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thanhnt.web.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("SELECT c FROM Category c WHERE c.categoryName LIKE %?1%")
	List<Category> searchCategory(String keyword);
}
