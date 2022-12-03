package jpastart.reserve.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

public class GetUserListService {
	public List<User> getAllUsers() {
		EntityManager em = EMF.createEntityManager();

		try {
			em.getTransaction().begin();
			TypedQuery<User> query =
				em.createQuery(
					"SELECT u FROM User u ORDER BY u.name",
					User.class);
			List<User> result = query.getResultList();
			em.getTransaction().commit();
			return result;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			throw ex;
		} finally {
			em.close();
		}
	}
}
