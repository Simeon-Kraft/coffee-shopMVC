package co.grandcircus.coffeeshopwebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Column(name= "first_name")
	private String first;
	@Column(name= "last_name")
	private String last;
	private String birthday;
	@Column(name= "favorite_drink")
	private String favorite;
	private String email;
	@Column(name= "phone_number")
	private String number;
	private String password;
	
	public User() {}
	
	public User(Long id, String title, String first, String last, String birthday, String favorite, String email
			, String number, String password) {
		this.id = id;
		this.title = title;
		this.first = first;
		this.last = last;
		this.birthday = birthday;
		this.favorite = favorite;
		this.email = email;
		this.number = number;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getfavorite() {
		return favorite;
	}
	public void setfavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [title=" + title + ", first=" + first + ", last=" + last + ", birthday=" + birthday + ", favorite="
				+ favorite + ", email=" + email + ", number=" + number + ", password=" + password + "]";
	}
	
}
