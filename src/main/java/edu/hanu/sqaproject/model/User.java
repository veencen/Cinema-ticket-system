package edu.hanu.sqaproject.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", nullable = false)
    @Size(min = 4, message = "Username must be at least 4 characters long.")
    @Size(max = 50, message = "Username maximum length is 50 characters.")
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Enter your e-mail adress")
    @Email(message = "Please enter correct e-mail adress")
    private String email;

    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "\\d{9}", message = "Please enter correct phone number.")
    private String phone;

    @Column(name = "name", nullable = false)
    @Size(max = 50, message = "Maximum length is 50 characters.")
    @NotBlank(message = "Enter your name.")
    private String name;

    @Column(name = "surname", nullable = false)
    @Size(max = 50, message = "Maximum length is 50 chracters.")
    @NotBlank(message = "Enter your surname.")
    private String surname;

    @Column(name = "active", nullable = false)
    private boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return isEnabled;
    }

}