package ru.kostyushin.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostyushin.webapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
