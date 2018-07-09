package example.service_impl;


import example.dao_abstract.UserDao;
import example.models.Role;
import example.models.User;
import example.service_abstract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDAO;

	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}

	public User getUserById(Long id) {
		return userDAO.getByKey(id);
	}

	@Override
	public void addUser(User user) {
		userDAO.persist(user);
	}

	public List<User> getAllUser() {
		return userDAO.getAll();
	}

	public void deleteUserById(Long id) {
		 userDAO.deleteByKey(id);
	}

	public void updateUser(User user) {

	    userDAO.update(user);
	}

	public Set<Role> getUserRoles(String username) {
		return userDAO.getUserByUsername(username).getRoles();
	}


}
