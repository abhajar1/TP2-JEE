package ma.emsi.tp2rolegrp.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.tp2rolegrp.entities.Role;
import ma.emsi.tp2rolegrp.entities.User;
import ma.emsi.tp2rolegrp.repositories.RoleRepository;
import ma.emsi.tp2rolegrp.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service // pour couche dao
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);

    }

    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=findUserByUsername(username);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);

        }

       // userRepository.save(user); -- on a deja @transactional

    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findByUsername(userName);
        if(user==null)  throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password))
        {
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
