package bg.soft_uni.pathfinderapp.Services;
import bg.soft_uni.pathfinderapp.Repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
