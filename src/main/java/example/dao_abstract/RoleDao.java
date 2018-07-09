package example.dao_abstract;


import example.models.Role;

public interface RoleDao extends GenericDao<Long,Role> {

	Role getRoleByRoleName(String roleName);

}