package org.hibernate.bugs;

import org.hibernate.model.TableOneEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;

public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		TableOneEntity e = new TableOneEntity();
		entityManager.persist(e);

		entityManager.getTransaction().commit();
		entityManager.close();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		CriteriaQuery<TableOneEntity> query = entityManager.getCriteriaBuilder().createQuery(TableOneEntity.class);
		query.select(query.from(TableOneEntity.class));
		entityManager.createQuery(query).getResultList(); // throws UnknownTableReferenceException

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
