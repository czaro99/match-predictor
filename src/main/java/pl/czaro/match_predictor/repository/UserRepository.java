package pl.czaro.match_predictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.czaro.match_predictor.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
