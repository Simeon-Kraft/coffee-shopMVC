package co.grandcircus.coffeeshopwebapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll(){
		return jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
	}
	
	public void create(User user) {
		String sql = "INSERT INTO user (title, first_name, last_name, birthday, favorite_drink,"
				+ "email, phone_number, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
			jdbcTemplate.update(sql, user.getTitle(), user.getFirst(), user.getLast(), user.getBirthday(),
					user.getfavorite(), user.getEmail(), user.getNumber(), user.getPassword());
			
		}

}
