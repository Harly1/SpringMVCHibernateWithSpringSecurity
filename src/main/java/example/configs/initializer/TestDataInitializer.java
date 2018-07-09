package example.configs.initializer;


import example.models.Role;
import example.models.User;
import example.service_abstract.RoleService;
import example.service_abstract.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.Set;


public class TestDataInitializer {



	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;


	private void init() throws Exception {

	/*	Role roleAdmin = new Role();
		roleAdmin.setName("ADMIN");
		roleService.addRole(roleAdmin);

		Role roleUser = new Role();
		roleUser.setName("USER");
		roleService.addRole(roleUser);

		User admin = new User();
		admin.setLogin("admin");
		admin.setPassword("admin");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(roleAdmin);
		adminRoles.add(roleUser);
		admin.setRoles(adminRoles);

		userService.addUser(admin);

		User user = new User();
		user.setLogin("user");
		user.setPassword("user");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(roleUser);
		user.setRoles(userRoles);

		userService.addUser(user);*/

	}
}
