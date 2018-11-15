package co.grandcircus.coffeeshopwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;

import co.grandcircus.coffeeshopwebapp.entity.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	public List<User> findAll() {
		return em.createQuery("FROM User", User.class).getResultList();
	}

	public void create(User user) {
		em.persist(user);
	}
	
	public User findByEmail(String email) {
		
		String hql = "FROM User WHERE email = :email";
		return em.createQuery(hql, User.class).setParameter("email", email).getSingleResult();		
	}

}
