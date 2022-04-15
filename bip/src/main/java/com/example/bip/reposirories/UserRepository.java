package com.example.bip.reposirories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sitairis.domain.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Boolean existsByLogin(String login);

}
