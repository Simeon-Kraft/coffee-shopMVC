package co.grandcircus.coffeeshopwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshopwebapp.entity.MenuItem;



@Repository 
@Transactional
public class MenuItemDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<MenuItem> findAll() {
		return em.createQuery("FROM MenuItem", MenuItem.class).getResultList();
	}
	
	public void create(MenuItem menuItem) {
		em.persist(menuItem);
	}
	
	public void update(MenuItem menuItem) {
		em.merge(menuItem);
	}
	
	public MenuItem findById(Long id) {
		return em.find(MenuItem.class, id);
	}
	
	public void delete(Long id) {
		MenuItem menuItem = em.getReference(MenuItem.class, id);
		em.remove(menuItem);
	}
}
