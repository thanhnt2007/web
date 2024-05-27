package thanhnt.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thanhnt.web.entities.Menu;
import thanhnt.web.services.MenuService;



@Controller
@RequestMapping("/admin")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/menu")
	public String menu(Model model) {
		List<Menu> menu = menuService.getAllMenus();
		model.addAttribute("menus", new Menu());
		model.addAttribute("menu", menu);
		return"menus/menu";
	}
	@PostMapping("/menu")
	public String create(@ModelAttribute Menu menu) {
		menuService.saveMenu(menu);
		return"redirect:/admin/menu";
	}
	@GetMapping("/menu/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Menu menu = menuService.getMenuByid(id).orElseThrow(() ->new IllegalArgumentException("Ivalid menu id: "+id));
		model.addAttribute("menu", menu);
		return"menus/edit";
	}
	@PostMapping("/menu/edit/{id}")
	public String saveEdit(@PathVariable Long id, @ModelAttribute Menu menuDetails) {
		Menu menu = menuService.getMenuByid(id).orElseThrow(() -> new IllegalArgumentException("invalid menu id: "+id));
		menu.setMenuName(menuDetails.getMenuName());
		menu.setDateCreated(menuDetails.getDateCreated());
		menu.setDateUpdated(menuDetails.getDateUpdated());
		menu.setStatus(menuDetails.getStatus());
		menuService.saveMenu(menu);
		return"redirect:/admin/menu";
	}
	@GetMapping("/menu/delete/{id}")
	public String delete(@PathVariable Long id) {
		menuService.deleteMenu(id);
		return"redirect:/admin/menu";
	}
}
