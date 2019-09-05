package dism3mb3r.shop.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Optional<User> findUserByEmail(Long id);
    boolean existsByEmailAndPassword(String email, String password);
}
