package jpastart.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import jpastart.common.model.Address;
import jpastart.reserve.model.Hotel;

public class JpaUpdateTest extends JpaTestBase {

	@Test
	public void updateInTx() throws Exception {
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Hotel hotel = entityManager.find(Hotel.class, "H100-01");
			hotel.changeAddress(new Address("08393", "서울시 구로구", "디지털로32길 72"));
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}

		entityManager = EMF.createEntityManager();
		Hotel hotel = entityManager.find(Hotel.class, "H100-01");
		entityManager.close();

		assertThat(hotel.getAddress().getAddress2(), equalTo("디지털로32길 72"));
	}

}
