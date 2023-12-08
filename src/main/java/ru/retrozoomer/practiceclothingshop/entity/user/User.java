package ru.retrozoomer.practiceclothingshop.entity.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.retrozoomer.practiceclothingshop.entity.product.Product;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "\"user\"")
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(max = 30)
    private String username;

    @Column(nullable = false)
    @Size(max = 100)
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(	name = "basket",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private Set<Product> products;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
