package jpastart.jpa;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import jpastart.guide.model.City;
import jpastart.reserve.model.Grade;
import jpastart.reserve.model.Hotel;
import jpastart.reserve.model.Review;

public class JpaPersistTest extends JpaTestBase {

	@Test
	public void persist() throws Exception {
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Hotel hotel = new Hotel("KR-S-01", "서울호텔", Grade.STAR5);
			entityManager.persist(hotel);

			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}
	}

	@Test
	public void identify() throws Exception {
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();

			Review review = new Review("KR-S-01", 5, "짱입니다.", new Date());
			entityManager.persist(review);
			Long id = review.getId();
			assertThat(id, notNullValue());

			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}
	}

	@Test
	public void tableGenerator() throws Exception {
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();

			City city = new City("서울");
			entityManager.persist(city);
			Long id = city.getId();
			System.out.println("generated city id = " + id);

			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}

	}

}
