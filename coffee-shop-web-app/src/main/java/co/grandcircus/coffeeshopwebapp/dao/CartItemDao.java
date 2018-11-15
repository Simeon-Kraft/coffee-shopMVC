package co.grandcircus.coffeeshopwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshopwebapp.entity.CartItem;

@Repository
@Transactional
public class CartItemDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<CartItem> findAll() {
		return em.createQuery("FROM CartItem", CartItem.class).getResultList();
	}
	
	public List<CartItem> findAllDistinct() {
		return em.createQuery("DISTINCT FROM CartItem", CartItem.class).getResultList();
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
