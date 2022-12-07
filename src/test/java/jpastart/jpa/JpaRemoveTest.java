package jpastart.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import jpastart.reserve.model.Room;

public class JpaRemoveTest extends JpaTestBase {

	@Test
	public void removeEntity() throws Exception {
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();

			Room r101 = entityManager.find(Room.class, "R101");
			entityManager.remove(r101);

			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}
	}

	@Test
	public void removeReferenceEntity() throws Exception {
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();

			Room r102 = entityManager.getReference(Room.class, "R102");
			entityManager.remove(r102);

			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}

	}

}
