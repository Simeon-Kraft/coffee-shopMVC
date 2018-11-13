package co.grandcircus.coffeeshopwebapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/userMenu")
	public ModelAndView showUserMenu() {
		List<MenuItem> itemList = menuItemDao.findAll();
		return new ModelAndView("userMenu", "items", itemList);
	}
	
	@RequestMapping("/menu")
	public ModelAndView showMenu() {
		List<MenuItem> itemList = menuItemDao.findAll();
		return new ModelAndView("menu", "items", itemList);
	}
	@PostMapping("/menu")
	public ModelAndView newMenu(MenuItem menuItem) {
		menuItemDao.create(menuItem);
		
		return new ModelAndView("redirect:/menu");
	}
	@RequestMapping("/add")
	public ModelAndView addItem() {
		ModelAndView mv = new ModelAndView("add");
		return mv;
	}
	@RequestMapping("/menu/{id}")
	public ModelAndView showItem(@PathVariable("id") Long id) {
		MenuItem menuItem = menuItemDao.findById(id);
		
		return new ModelAndView("detail", "menuItem", menuItem);
	}
	@RequestMapping("/menu/{id}/delete")
	public ModelAndView remove(@PathVariable("id") Long id) {
		menuItemDao.delete(id);
		return new ModelAndView("redirect:/menu");
	}
	@RequestMapping("/menu/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		MenuItem menuItem = menuItemDao.findById(id);
		
		return new ModelAndView("edit", "menuItem", menuItem);
	}
	@PostMapping("/menu/{id}/edit")
	public ModelAndView save(@PathVariable("id") Long id, MenuItem menuItem) {
		menuItem.setId(id);
		menuItemDao.update(menuItem);
		return new ModelAndView("redirect:/menu");
	}
	

}
