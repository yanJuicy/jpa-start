package jpastart.reserve.application;

import javax.persistence.EntityManager;

import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

public class WithdrawService {
	public void withdraw(String email) {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();

		try {
			User user = em.find(User.class, email);
			if (user == null) {
				throw new UserNotFoundException();
			}
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			throw ex;
		} finally {
			em.close();
		}
	}
}
