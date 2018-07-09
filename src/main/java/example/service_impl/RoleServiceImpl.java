package example.service_impl;


import example.dao_abstract.RoleDao;

import example.models.Role;
import example.service_abstract.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	public void addRole(Role role) {
		 roleDao.persist(role);
	}

	public Role getRoleByRoleName(String roleName) {
		return roleDao.getRoleByRoleName(roleName);
	}

	public Role getRoleById(Long id) {
		return roleDao.getByKey(id);
	}

	public List<Role> getAllRoles() {
		return roleDao.getAll();
	}

	public void updateRoles(Role role) {
		 roleDao.update(role);
	}

	public void deleteRoleById(Long id) {
		 roleDao.deleteByKey(id);
	}
}
