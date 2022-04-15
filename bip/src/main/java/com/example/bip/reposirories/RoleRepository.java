package com.example.bip.reposirories;

import java.util.Optional;

import com.example.sitairis.domain.Role;
import com.example.sitairis.domain.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
