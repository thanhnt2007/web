package thanhnt.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thanhnt.web.entities.Menu;
import thanhnt.web.entities.MenuItem;
import thanhnt.web.services.MenuItemService;
import thanhnt.web.services.MenuService;

@Controller
@RequestMapping
public class HomeController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuItemService menuItemService;
	@GetMapping("/")
	public String home(Model model) {
		List<MenuItem> menuItems = menuItemService.getAllTopLevelMenuItems();
        model.addAttribute("menuItems", menuItems);
		return"trangchu/home";
	}
}
