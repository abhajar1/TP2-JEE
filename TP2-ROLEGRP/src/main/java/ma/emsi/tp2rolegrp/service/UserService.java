package ma.emsi.tp2rolegrp.service;
import ma.emsi.tp2rolegrp.entities.User;
import ma.emsi.tp2rolegrp.entities.Role;
public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName);
    User authenticate(String userName,String password);

}
