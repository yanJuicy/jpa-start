package jpastart.reserve.application;

import java.util.Optional;

import javax.persistence.EntityManager;

import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

public class GetUserService {
	public Optional<User> getUser(String email) {
		EntityManager em = EMF.createEntityManager();
		try {
			User user = em.find(User.class, email);
			return Optional.ofNullable(user);
		} finally {
			em.close();
		}
	}
}
