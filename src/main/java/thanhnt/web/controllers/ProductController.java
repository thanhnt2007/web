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
import thanhnt.web.entities.Product;
import thanhnt.web.services.CategoryService;
import thanhnt.web.services.ProductService;
import thanhnt.web.services.StorageService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private StorageService storageService;
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/product")
	public String listProduct(Model model, @Param("keyword") String keyword,@RequestParam(name="pageNo", defaultValue = "1") Integer pageNo) {
		Page<Product> list = this.productService.getAll(pageNo);
		if (keyword != null) {
			list = this.productService.searchProduct(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("list", list);
		return"products/product";
	}
	@GetMapping("/add-product")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		List<Category> listAdd = this.categoryService.getAll();
		model.addAttribute("listAdd", listAdd);
		return"products/add";
	}
	@PostMapping("/add-product")
	public String saveAdd(@ModelAttribute("product")Product product,@RequestParam("fileImage") MultipartFile file) {
		this.storageService.store(file);
		String fileName = file.getOriginalFilename();
		product.setImage(fileName);
		if (this.productService.create(product)) {
			return"redirect:/admin/product";
		}
		return"products/errors";
	}
	@GetMapping("/edit-product/{id}")
	public String update(Model model, @PathVariable("id")Integer id) {
		List<Category> listAdds = this.categoryService.getAll();
		Product product = this.productService.findById(id);
		model.addAttribute("product", product);
		model.addAttribute("listAdds", listAdds);
		return"products/edit";
	}
	@PostMapping("/edit-product")
	public String save(@ModelAttribute("product")Product product,@RequestParam("fileImage")MultipartFile file) {
		if (!file.isEmpty()) {
			this.storageService.store(file);
			String fileName = file.getOriginalFilename();
			product.setImage(fileName);
		}
		if(this.productService.update(product)) {
			return"redirect:/admin/product";
		}
		return"products/errors";
	}
	@GetMapping("/delete-product/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		if (this.productService.delete(id)) {
			return"redirect:/admin/product";
		} else {
			return"products/errors";
		}
	}
}
