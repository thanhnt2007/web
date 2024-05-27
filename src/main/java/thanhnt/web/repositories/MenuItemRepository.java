package thanhnt.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import thanhnt.web.entities.Menu;
import thanhnt.web.entities.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{
	List<MenuItem> findByMenuParentIsNull();
}
