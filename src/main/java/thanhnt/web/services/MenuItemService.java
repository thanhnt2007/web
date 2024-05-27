package thanhnt.web.services;

import java.util.List;
import java.util.Optional;

import thanhnt.web.entities.Menu;
import thanhnt.web.entities.MenuItem;

public interface MenuItemService {
	List<MenuItem> getAllMenuItem();
	Optional<MenuItem> getMenuItemByid(Long id);
	MenuItem saveMenuItem(MenuItem menuItem);
	void deleteMenuItem(Long id);
	List<MenuItem> getAllTopLevelMenuItems();
}
