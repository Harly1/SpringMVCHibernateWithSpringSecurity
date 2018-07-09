package example.dao_abstract;



import example.models.User;

public interface UserDao extends GenericDao<Long,User>{
    User getUserByUsername(String username);
}