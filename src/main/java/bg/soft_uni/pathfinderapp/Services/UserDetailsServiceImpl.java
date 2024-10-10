package bg.soft_uni.pathfinderapp.Services;

import bg.soft_uni.pathfinderapp.Model.Entities.User;
import bg.soft_uni.pathfinderapp.Repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {
        private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(UserDetailsServiceImpl::map)
                .orElseThrow(()-> new UsernameNotFoundException("Invalid username"));
    }
    public static UserDetails map(User user){
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(getAllRoles(user))
                .disabled(false)
                .build();
    }
     private static List<SimpleGrantedAuthority> getAllRoles(User user) {
        return user.getRoles().stream()
                .map(role->new SimpleGrantedAuthority("ROLE_"+role.getName()))
                .collect(Collectors.toList());
    }
}
