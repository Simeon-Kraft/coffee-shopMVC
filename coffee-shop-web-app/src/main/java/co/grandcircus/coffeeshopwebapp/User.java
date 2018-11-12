package co.grandcircus.coffeeshopwebapp;

import java.util.Date;

public class User {
	private String title;
	private String first;
	private String last;
	private String birthday;
	private String favorite;
	private String email;
	private String number;
	private String password;
	
	public User() {}
	
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
