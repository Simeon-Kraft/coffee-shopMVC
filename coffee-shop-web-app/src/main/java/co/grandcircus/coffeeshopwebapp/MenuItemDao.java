package co.grandcircus.coffeeshopwebapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository 
public class MenuItemDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MenuItem> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM menu_items", new BeanPropertyRowMapper<>(MenuItem.class));
	}
	
	public void create(MenuItem menuItem) {
		String sql = "INSERT INTO menu-items (name, description, price) VALUES (?, ?, ?)";
		
		jdbcTemplate.update(sql, menuItem.getName(), menuItem.getDescription(), menuItem.getPrice());
	}
}
