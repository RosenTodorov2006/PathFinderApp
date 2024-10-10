package bg.soft_uni.pathfinderapp.Init;

import bg.soft_uni.pathfinderapp.Model.Entities.Enums.RoleNames;
import bg.soft_uni.pathfinderapp.Model.Entities.Role;
import bg.soft_uni.pathfinderapp.Repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleInit implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public RoleInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count()==0){
            Arrays.stream(RoleNames.values())
                    .map(Role::new)
                    .forEach(roleRepository::save);
        }
    }
}
