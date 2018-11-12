package co.grandcircus.coffeeshopwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopWebAppController {
	
	@Autowired
	MenuItems menuItem;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}
	@RequestMapping("/summary")
	public ModelAndView showSummary(User user) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("user", user);
		return mv;
	}
	@RequestMapping("/menu")
	public ModelAndView showMenu() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("items", menuItem.getAllItems());
		return mv;
	}

}
