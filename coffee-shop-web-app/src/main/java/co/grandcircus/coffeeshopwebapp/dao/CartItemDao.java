package co.grandcircus.coffeeshopwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshopwebapp.entity.CartItem;
import co.grandcircus.coffeeshopwebapp.entity.User;

@Repository
@Transactional
public class CartItemDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<CartItem> findAll() {
		return em.createQuery("FROM CartItem", CartItem.class).getResultList();
	}
	
	public List<CartItem> findUserItems(User user) {
		return em.createQuery("FROM CartItem WHERE user = :user", CartItem.class).setParameter("user", user).getResultList();
	}

	public void create(CartItem cartItem) {
		em.persist(cartItem);
	}
	
	public void update(CartItem cartItem) {
		em.merge(cartItem);
	}
	
	public CartItem findById(Long id) {
		return em.find(CartItem.class, id);
	}
	
	public void delete(Long id) {
		CartItem cartItem = em.getReference(CartItem.class, id);
		em.remove(cartItem);
	}

}
