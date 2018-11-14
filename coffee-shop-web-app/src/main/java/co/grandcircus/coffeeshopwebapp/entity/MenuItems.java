package co.grandcircus.coffeeshopwebapp.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MenuItems {
	
	private List<MenuItem> list = new ArrayList<>();
	
	public MenuItems() {
		list.add(new MenuItem((long) 1, "Espresso", "The lifeblood of invention", 1.99));
		list.add(new MenuItem((long) 2, "Sparkling Water", "Sweet nectar of the gods", 2.99));
		list.add(new MenuItem((long) 3, "Vanilla Scone", "A necessity", 1.50));
	}
	
	public List<MenuItem> getAllItems() {
		return list;
	}
	
	public void addItem(MenuItem item) {
		list.add(item);
	}

}
