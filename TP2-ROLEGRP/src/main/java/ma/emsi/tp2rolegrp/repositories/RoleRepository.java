package ma.emsi.tp2rolegrp.repositories;

import ma.emsi.tp2rolegrp.entities.Role;
import ma.emsi.tp2rolegrp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
