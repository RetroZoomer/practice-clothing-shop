package ru.retrozoomer.practiceclothingshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.retrozoomer.practiceclothingshop.entity.user.ERole;
import ru.retrozoomer.practiceclothingshop.entity.user.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
