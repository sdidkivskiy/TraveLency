package org.TraveLency.repository;

import org.TraveLency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailOrLogin(String email, String login);

    boolean existsByLoginOrEmailAndPassword(String login, String email, String password);

    User findByLogin(String login);
}
