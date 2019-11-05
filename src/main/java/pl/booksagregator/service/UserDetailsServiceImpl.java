package pl.booksagregator.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.booksagregator.exception.ApiRequestNotFoundException;
import pl.booksagregator.model.dao.UserDao;
import pl.booksagregator.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserDao> userDao = userRepository.findByUsername(username);
        return userDao.map(dao -> {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(dao.getUsername(), dao.getPassword(), grantedAuthorities);
        }).orElseThrow(() -> new ApiRequestNotFoundException("User not found"));
    }
}
