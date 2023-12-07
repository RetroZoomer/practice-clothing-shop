package ru.retrozoomer.practiceclothingshop.entity.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "\"role\"")
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private ERole name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }

    public Role() {

    }

    @Override
    public String getAuthority() {
        return String.valueOf(getName());
    }
}
