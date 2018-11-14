package co.grandcircus.coffeeshopwebapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshopwebapp.dao.CartItemDao;
import co.grandcircus.coffeeshopwebapp.dao.MenuItemDao;
import co.grandcircus.coffeeshopwebapp.dao.UserDao;
import co.grandcircus.coffeeshopwebapp.entity.CartItem;
import co.grandcircus.coffeeshopwebapp.entity.MenuItem;
import co.grandcircus.coffeeshopwebapp.entity.MenuItems;
import co.grandcircus.coffeeshopwebapp.entity.User;

@Controller
public class CoffeeShopWebAppController {
	
	@Autowired
	private MenuItems menuItem;
	
	@Autowired
	private MenuItemDao menuItemDao;
	
	@Autowired
	private CartItemDao cartItemDao;
	
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
	
	@RequestMapping("/userMenu/{id}")
	public ModelAndView addItemToCart(@PathVariable("id") Long id) {
		CartItem cartItem = new CartItem();
		cartItem.setMenuItem(menuItemDao.findById(id));
		cartItem.setQuantity((long) 1);
		
		
		cartItemDao.create(cartItem);
		return new ModelAndView("redirect:/userMenu");
	}
	
	@RequestMapping("/userMenu/{id}/delete")
	public ModelAndView deleteItem(@PathVariable("id") Long id) {
		
		cartItemDao.delete(id);
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping("/cart")
	public ModelAndView showCart() {
		List<CartItem> itemList = cartItemDao.findAll();
		double total = 0;
		
		for (CartItem item : itemList) {
			total = total + item.getMenuItem().getPrice();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("subtotal", total);
		mv.addObject("total", total + (total * .06));
		mv.addObject("items", itemList);
		
		return mv;
	}
	
	@RequestMapping("/menu")
	public ModelAndView showMenu() {
		List<MenuItem> itemList = menuItemDao.findAll();
		return new ModelAndView("menu", "items", itemList);
	}
	@PostMapping("/menu")
	public ModelAndView newMenu(MenuItem menuItem) {
		List<MenuItem> itemList = menuItemDao.findAll();
		
		for (MenuItem item : itemList) {
			if (item.getName().equalsIgnoreCase(menuItem.getName())) {
				System.out.println("That item already exists.");
				return new ModelAndView("redirect:/menu");
			}
		}
		
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
