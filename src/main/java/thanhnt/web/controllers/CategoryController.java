package thanhnt.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import thanhnt.web.entities.Category;
import thanhnt.web.repositories.CategoryRepository;
import thanhnt.web.services.CategoryService;
import thanhnt.web.services.StorageService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private StorageService storageService;
	@GetMapping("/category")
	public String listcategory(Model model,@Param("keyword")String keyword,@RequestParam(name = "pageNo",defaultValue = "1")Integer pageNo) {
		Page<Category> list = this.categoryService.getAll(pageNo);
		if (keyword != null) {
			list = this.categoryService.searchCategory(keyword,pageNo);
		model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("list", list);
		return"categories/category";
	}
	@GetMapping("/category/{id}")
	public String viewCategoryDetail(Model model, @PathVariable("id") Integer id) {
		Category category = categoryService.findById(id);
		 if (category != null) {
	            model.addAttribute("category", category);
	            model.addAttribute("products", category.getProducts());
	            return "categories/details";
	        }
		 return "categories/errors";
	}
	@GetMapping("/add-category")
	public String add(Model model) {
		List<Category> list = this.categoryService.getAll();
		Category category = new Category();
		model.addAttribute("list", list);
		model.addAttribute("category", category);
		return"categories/add";
	}
	@PostMapping("/add-category")
	public String save(@ModelAttribute("category") Category category,@RequestParam("imageFile") MultipartFile file) {
		this.storageService.store(file);
		String fileName = file.getOriginalFilename();
		category.setCategoryImage(fileName);
		if (this.categoryService.create(category)) {
			return"redirect:/admin/category";
		}
		return"categories/add";
	}
	@GetMapping("/edit-category/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Category category = this.categoryService.findById(id);
		model.addAttribute("category", category);
		return"categories/edit";
	}
	@PostMapping("/edit-category")
	public String update(@ModelAttribute("category") Category category,@RequestParam("imageFile")MultipartFile file) {
		if (!file.isEmpty()) {
			this.storageService.store(file);
			String fileName = file.getOriginalFilename();
			category.setCategoryImage(fileName);
		}
		if (this.categoryService.update(category)) {
			return"redirect:/admin/category";
		}
		return"categories/edit";
	}
	@GetMapping("/delete-category/{id}")
	public String delete(@PathVariable("id") Integer id) {
		this.categoryService.delete(id);
		return"redirect:/admin/category"; 
	}
}
