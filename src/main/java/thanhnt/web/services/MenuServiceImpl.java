package thanhnt.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thanhnt.web.entities.Menu;
import thanhnt.web.repositories.MenuRepository;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuRepository menuRepository;
	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

	@Override
	public Optional<Menu> getMenuByid(Long id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id);
	}

	@Override
	public Menu saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

	@Override
	public void deleteMenu(Long id) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(id);
	}
	
}
