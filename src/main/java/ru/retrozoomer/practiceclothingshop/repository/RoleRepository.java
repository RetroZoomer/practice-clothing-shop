package ru.retrozoomer.practiceclothingshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.retrozoomer.practiceclothingshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}