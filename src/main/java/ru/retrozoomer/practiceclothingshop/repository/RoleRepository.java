package ru.retrozoomer.practiceclothingshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.retrozoomer.practiceclothingshop.entity.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
