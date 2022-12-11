package jpastart.jpa;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import jpastart.reserve.model.Hotel;
import jpastart.reserve.model.Room;

public class JpaFindTest extends JpaTestBase {

	@Test
	public void findNotNullEmbeddedValue() throws Exception {
		Hotel hotel = findHotelById("H100-01");
		assertThat(hotel.getAddress(), notNullValue());
	}

	@Test
	public void findNullEmbeddedValue() throws Exception {
		Hotel hotel = findHotelById("H100-02");
		assertThat(hotel.getAddress(), nullValue());
	}

	private Hotel findHotelById(String hotelId) {
		Hotel room = null;
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			room = entityManager.find(Hotel.class, hotelId);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}
		return room;
	}

	@Test
	public void find() throws Exception {
		assertThat(findRoomById("R101"), notNullValue());
		assertThat(findRoomById("NO_ID"), nullValue());
	}

	private Object findRoomById(String roomId) {
		Room room = null;
		EntityManager entityManager = EMF.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			room = entityManager.find(Room.class, roomId);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		} finally {
			entityManager.close();
		}

		return room;
	}

}
