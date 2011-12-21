package demo.capteur.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<?> entityClass;

	public AbstractHibernateDao(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public T create(T entity) {
		getSession().persist(entity);
		return entity;
	}

	public T update(T entity) {
		getSession().merge(entity);
		return entity;
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getSession().createCriteria(entityClass).list();
	}

}
