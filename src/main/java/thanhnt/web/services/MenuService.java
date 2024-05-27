package thanhnt.web.services;

import java.util.List;
import java.util.Optional;

import thanhnt.web.entities.Menu;

public interface MenuService {
	List<Menu> getAllMenus();
	Optional<Menu> getMenuByid(Long id);
	Menu saveMenu(Menu menu);
	void deleteMenu(Long id);
}
