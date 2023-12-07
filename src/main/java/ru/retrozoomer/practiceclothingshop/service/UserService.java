package ru.retrozoomer.practiceclothingshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.retrozoomer.practiceclothingshop.entity.user.ERole;
import ru.retrozoomer.practiceclothingshop.entity.user.Role;
import ru.retrozoomer.practiceclothingshop.entity.user.User;
import ru.retrozoomer.practiceclothingshop.repository.RoleRepository;
import ru.retrozoomer.practiceclothingshop.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User saveUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        Role userRole = roleRepository.findByName(String.valueOf(ERole.ROLE_USER));
        user.setRoles(Collections.singleton(userRole));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    public User updateUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        user.setRoles(userFromDB.getRoles());
        if (!Objects.equals(user.getPassword(), userFromDB.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);

        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
