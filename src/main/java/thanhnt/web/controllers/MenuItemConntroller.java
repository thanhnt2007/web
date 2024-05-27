package thanhnt.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thanhnt.web.entities.Menu;
import thanhnt.web.entities.MenuItem;
import thanhnt.web.services.MenuItemService;
import thanhnt.web.services.MenuService;

@Controller
@RequestMapping("/admin")
public class MenuItemConntroller {
	
	@Autowired
	private MenuItemService menuItemService;
	@Autowired 
	private MenuService menuService;
	@GetMapping("/menuitem")
	public String list(Model model) {
		List<MenuItem> menuItems = menuItemService.getAllMenuItem();
	    model.addAttribute("menuItems", menuItems);
	    List<Menu> menus = menuService.getAllMenus();
	    model.addAttribute("menuItem", new MenuItem());
	    model.addAttribute("menus", menus);
	    // Thêm một lựa chọn cho MenuItem cha (nếu muốn)
	    MenuItem defaultParentMenuItem = new MenuItem();
	    defaultParentMenuItem.setId(0L); // Giá trị ID mặc định hoặc không hợp lệ
	    defaultParentMenuItem.setMenuItemName("No Parent"); // Tên lựa chọn mặc định
	    model.addAttribute("defaultParentMenuItem", defaultParentMenuItem);
	    return "menuitems/menuitem";
	}
	
	@PostMapping("/menuitem")
	public String add(@ModelAttribute("menuItem") MenuItem menuItem) {
		// Kiểm tra nếu MenuItem cha là null hoặc có ID mặc định (nếu bạn đã thiết lập)
	    if (menuItem.getMenuParent() == null || menuItem.getMenuParent().getId() == 0L) {
	        menuItem.setMenuParent(null); // Đặt MenuItem cha thành null
	    }
	    menuItemService.saveMenuItem(menuItem);
	    return "redirect:/admin/menuitem";
	}
	@GetMapping("/menuitem/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		MenuItem menuItem = menuItemService.getMenuItemByid(id).orElseThrow(() -> new IllegalArgumentException("Invalid menu item Id:" + id));
		model.addAttribute("menuItem", menuItem);
		List<MenuItem> menuItems = menuItemService.getAllMenuItem();
		model.addAttribute("menuItems", menuItems);
		List<Menu> menus = menuService.getAllMenus();
		model.addAttribute("menus", menus);
		return"menuitems/edit";
	}
	@PostMapping("/menuitem/edit/{id}")
	public String save(@PathVariable Long id, @ModelAttribute MenuItem menuItemDetails) {
		 MenuItem menuItem = menuItemService.getMenuItemByid(id).orElseThrow(() -> new IllegalArgumentException("Invalid menu item Id:" + id));
	        menuItem.setMenuItemName(menuItemDetails.getMenuItemName());
	        menuItem.setUrl(menuItemDetails.getUrl());
	        menuItem.setOder(menuItemDetails.getOder());
	        menuItem.setMenuParent(menuItemDetails.getMenuParent());
	        menuItem.setMenu(menuItemDetails.getMenu());
	        menuItem.setNgayCapNhat(menuItemDetails.getNgayCapNhat());
	        menuItem.setTrangThai(menuItemDetails.getTrangThai());
	        menuItemService.saveMenuItem(menuItem);
	        return"redirect:/admin/menuitem";
	}
	@GetMapping("/menuitem/delete/{id}")
	private String delete(@PathVariable Long id) {
		menuItemService.deleteMenuItem(id);
		return"redirect:/admin/menuitem";
	}
}
