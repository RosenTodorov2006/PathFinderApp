package bg.soft_uni.pathfinderapp.Config;

import bg.soft_uni.pathfinderapp.Repositories.UserRepository;
import bg.soft_uni.pathfinderapp.Services.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(
                        authorizeRequests->
                            authorizeRequests
                                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                    .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                                    .anyRequest()
                                    .authenticated()

                )
                .formLogin(
                        fromLogin->
                                fromLogin.loginPage("/users/login")
                                        .usernameParameter("username")
                                        .passwordParameter("password")
                                        .defaultSuccessUrl("/", true)
                                        .failureUrl("/users/login-error")
                )
                .logout(
                        logout->
                                logout.logoutUrl("/logout")
                                        .logoutSuccessUrl("/")
                                        .invalidateHttpSession(true)
                )
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder
                .defaultsForSpringSecurity_v5_8();
    }
    @Bean
    public UserDetailsServiceImpl userDetailsService(UserRepository userRepository){
        return new UserDetailsServiceImpl(userRepository);

    }
}
