package co.jiwon.prj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
}
