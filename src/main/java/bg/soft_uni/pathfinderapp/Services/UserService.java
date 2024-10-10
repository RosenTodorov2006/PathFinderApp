package bg.soft_uni.pathfinderapp.Services;
import bg.soft_uni.pathfinderapp.Model.Dtos.RegisterSeedDto;
import bg.soft_uni.pathfinderapp.Model.Entities.Enums.Level;
import bg.soft_uni.pathfinderapp.Model.Entities.Enums.RoleNames;
import bg.soft_uni.pathfinderapp.Model.Entities.User;
import bg.soft_uni.pathfinderapp.Repositories.RoleRepository;
import bg.soft_uni.pathfinderapp.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    public void addUser(RegisterSeedDto registerSeedDto){
        User map = modelMapper.map(registerSeedDto, User.class);
        map.setLevel(Level.ADVANCED);
        map.setPassword(this.passwordEncoder.encode(registerSeedDto.getPassword()));
        if(userRepository.count()==0){
            map.setRoles(List.of(roleRepository.findByName(RoleNames.ADMIN).get(),roleRepository.findByName(RoleNames.USER).get()));
        }else{
            map.setRoles(List.of(roleRepository.findByName(RoleNames.USER).get()));
        }
        this.userRepository.saveAndFlush(map);
    }
    public boolean validUsername(String username){
        return this.userRepository.findByUsername(username).isEmpty();
    }

    public User findUserByUsername(String name) {
        return this.userRepository.findByUsername(name).get();
    }

    public boolean validEmail(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }
}
