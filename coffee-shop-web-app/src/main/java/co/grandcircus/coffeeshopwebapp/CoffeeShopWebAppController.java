package co.grandcircus.coffeeshopwebapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView index(@SessionAttribute(name="user", required=false) User user, HttpSession session) {
		return new ModelAndView("index", "user", user);
	}
	
	
	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}
	@PostMapping("/summary")
	public ModelAndView registerSubmit(User user, HttpSession session, RedirectAttributes redir) {
		List<User> userList = userDao.findAll();
		
		for(User u : userList) {
			if(u.getEmail().equals(user.getEmail())) {
				return new ModelAndView("redirect:/register", "message", "That email is already "
						+ "associated with an account.");
			}
		}
		
		userDao.create(user);
		session.setAttribute("user", user);
		return new ModelAndView("summary", "user", user);
	}
	
	@RequestMapping("/login")
	public ModelAndView showLogin(HttpSession session) {
		session.invalidate();
		return new ModelAndView("login");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		session.invalidate();
		
		redir.addFlashAttribute("message", "You've logged out.");
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/login")
	public ModelAndView postLogin(@RequestParam("email") String email, 
			@RequestParam("password") String password, HttpSession session, RedirectAttributes redir) {
		
		User user = new User();
		try {
			 user = userDao.findByEmail(email);
		}catch(NoResultException e) {
			return new ModelAndView("login", "message", "Incorrect email or password");
		}
		
		if (user == null) {
			return new ModelAndView("login", "message", "Incorrect email or password");
		}
		if (!user.getPassword().equals(password)) {
			return new ModelAndView("login", "message", "Incorrect email or password");
		}
		
		session.setAttribute("user", user);
		redir.addFlashAttribute("message", "Its coffee time.");
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping("/userMenu")
	public ModelAndView showUserMenu(@SessionAttribute(name="user", required=false) User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<MenuItem> itemList = menuItemDao.findAll();
		List<CartItem> cart = cartItemDao.findUserItems(user);
		Long qty = (long) 0;
		for (CartItem c : cart) {
			qty = qty + c.getQuantity();
		}
	
		
		
		mv.addObject("items", itemList);
		mv.addObject("qty", qty);
		
		return mv;
	}
	
	@RequestMapping("/admin-login")
	public ModelAndView adminLogin(HttpSession session) {
		return new ModelAndView("admin-login");
	}
	
	@PostMapping("/admin-login")
	public ModelAndView postAdminLogin(@RequestParam("email") String email, 
			@RequestParam("password") String password, HttpSession session, RedirectAttributes redir) {
		
		User user = new User();
		User admin = userDao.findByEmail("kraft.simeon.sk@gmail.com");
		try {
			 user = userDao.findByEmail(email);
		}catch(NoResultException e) {
			return new ModelAndView("admin-login", "message", "NOPE");
		}
		
		if (!email.equals(admin.getEmail())) {
			return new ModelAndView("admin-login", "message", "NOPE");
		}
		if (!password.equals(admin.getPassword())) {
			return new ModelAndView("admin-login", "message", "NOPE");
		}
		
		session.setAttribute("user", user);
		redir.addFlashAttribute("message", "Its coffee time.");
		return new ModelAndView("redirect:menu");
		
	}
	
	@RequestMapping("/cart/{id}/increase")
	public ModelAndView increaseQuantity(@PathVariable("id") Long id, @SessionAttribute(name="user", required=false) User user, HttpSession session) {
		
		CartItem item = cartItemDao.findById(id);
		Long qty = item.getQuantity();
		item.setQuantity(qty + 1);
		cartItemDao.update(item);
		
		
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping("/cart/{id}/decrease")
	public ModelAndView decreaseQuantity(@PathVariable("id") Long id, @SessionAttribute(name="user", required=false) User user, HttpSession session) {
		CartItem item = cartItemDao.findById(id);
		Long qty = item.getQuantity();
		
		if (qty == 1) {
			cartItemDao.delete(id);
			return new ModelAndView("redirect:/cart");
		}
		
		item.setQuantity(qty - 1);
		cartItemDao.update(item);
		
		
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping("/userMenu/{id}")
	public ModelAndView addItemToCart(@PathVariable("id") Long id, @SessionAttribute(name="user", required=false) User user, HttpSession session, RedirectAttributes redir) {
		CartItem cartItem = new CartItem();
		
		cartItem.setMenuItem(menuItemDao.findById(id));
		cartItem.setUser(user);
		
		for (CartItem c : cartItemDao.findAll()) {
			if ((c.getMenuItem().getId() == cartItem.getMenuItem().getId())) {
				Long qty = c.getQuantity() + 1;
				c.setQuantity(qty);
				cartItemDao.update(c);
				return new ModelAndView("redirect:/userMenu");
			}
		}
		
		cartItem.setQuantity((long) 1);
		cartItemDao.create(cartItem);
		redir.addFlashAttribute("message", "Item added");
		return new ModelAndView("redirect:/userMenu");
	}
	
	@RequestMapping("/userMenu/{id}/delete")
	public ModelAndView deleteItem(@PathVariable("id") Long id) {
		
		cartItemDao.delete(id);
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping("/cart")
	public ModelAndView showCart(@SessionAttribute(name="user", required=false) User user, HttpSession session) {
		List<CartItem> itemList = cartItemDao.findUserItems(user);
		double total = 0;
		
		for (CartItem item : itemList) {
				total = total + (item.getMenuItem().getPrice() * item.getQuantity());
			
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
