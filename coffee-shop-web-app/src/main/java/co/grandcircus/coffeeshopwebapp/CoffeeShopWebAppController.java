package co.grandcircus.coffeeshopwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopWebAppController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}
	@RequestMapping("/summary")
	public ModelAndView showSummary(@RequestParam("first") String first, @RequestParam("last") String last,
			@RequestParam("email") String email, @RequestParam("title") String title, 
			@RequestParam("number")String number, @RequestParam("favorite")String favorite) {
	
		ModelAndView  mv = new ModelAndView();
		mv.addObject("first", first);
		mv.addObject("last", last);
		mv.addObject("number", number);
		mv.addObject("email", email);
		mv.addObject("favorite", favorite);
		mv.addObject("title", title);
	
		return mv;
	}

}
