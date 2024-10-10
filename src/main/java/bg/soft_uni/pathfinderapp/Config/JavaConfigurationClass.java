package bg.soft_uni.pathfinderapp.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigurationClass {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
