package ma.emsi.tp2rolegrp.repositories;

import ma.emsi.tp2rolegrp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);
}
