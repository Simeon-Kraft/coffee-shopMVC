package co.grandcircus.coffeeshopwebapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopWebAppController {
	
	@Autowired
	private MenuItems menuItem;
	
	@Autowired
	private MenuItemDao menuItemDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}
	@PostMapping("/summary")
	public ModelAndView registerSubmit(User user) {
		userDao.create(user);
		
		return new ModelAndView("summary", "user", user);
	}
	
	@RequestMapping("/menu")
	public ModelAndView showMenu() {
		List<MenuItem> itemList = menuItemDao.findAll();
		return new ModelAndView("menu", "items", itemList);
	}
	@PostMapping("/menu")
	public ModelAndView newMenu(MenuItem menuItem) {
		System.out.println("HELLO");
		menuItemDao.create(menuItem);
		
		return new ModelAndView("redirect:/menu");
	}
	@RequestMapping("/add")
	public ModelAndView addItem() {
		ModelAndView mv = new ModelAndView("add");
		return mv;
	}
	

}
