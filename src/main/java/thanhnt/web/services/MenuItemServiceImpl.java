package thanhnt.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import thanhnt.web.entities.Menu;
import thanhnt.web.entities.MenuItem;
import thanhnt.web.repositories.MenuItemRepository;
@Service
public class MenuItemServiceImpl implements MenuItemService{
	@Autowired
	private MenuItemRepository menuItemRepository;
	@Override
	public List<MenuItem> getAllMenuItem() {
		// TODO Auto-generated method stub
		return menuItemRepository.findAll();
	}

	@Override
	public Optional<MenuItem> getMenuItemByid(Long id) {
		// TODO Auto-generated method stub
		return menuItemRepository.findById(id);
	}

	@Override
	public MenuItem saveMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return menuItemRepository.save(menuItem);
	}

	@Override
	public void deleteMenuItem(Long id) {
		 try {
		        menuItemRepository.deleteById(id);
		    } catch (EmptyResultDataAccessException e) {
		        // Log the exception or handle it as needed
		        System.out.println("Error: MenuItem with id " + id + " does not exist.");
		    }
	}

	@Override
	public List<MenuItem> getAllTopLevelMenuItems() {
		// TODO Auto-generated method stub
		return menuItemRepository.findByMenuParentIsNull();
	}
	

}
