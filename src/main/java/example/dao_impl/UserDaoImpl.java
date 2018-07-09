package example.dao_impl;


import example.dao_abstract.UserDao;
import example.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	public User getUserByUsername(String username) {
		User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.login =:username").setParameter("username", username).getSingleResult();
		return user;
	}

	@Override
	public void update(User entity) {

		entityManager.merge(entity);
	}

	@Override
	public void persist(User entity) {
		super.persist(entity);
	}

	@Override
	public void deleteByKey(Long aLong) {
		User userFromDB = entityManager.find(User.class, aLong);
		entityManager.remove(userFromDB);
	}
}
