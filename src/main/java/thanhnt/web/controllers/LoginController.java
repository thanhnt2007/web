package thanhnt.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		
		return"login/login";
	}
	@PostMapping("/login")
	public String checkLogin(Model model) {
		
			model.addAttribute("mess", "Tài khoản hoặc mật khẩu không chính xác! Xin vui lòng nhập lại!");
		
		return"login/login";
	}
}
