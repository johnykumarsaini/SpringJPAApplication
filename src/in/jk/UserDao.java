package in.jk;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDao {

	@PersistenceContext
	EntityManager entityManager;

	public void save(User user) {

		entityManager.persist(user);
	}

	public User get(int id) {

		return entityManager.find(User.class, id);
	}

}
