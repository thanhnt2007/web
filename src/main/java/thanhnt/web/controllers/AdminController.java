package thanhnt.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping 
	public String admin() {
		return"redirect:/admin/";
	}
	@GetMapping("/")
	public String view() {
		return"admin/home";
	}
}
