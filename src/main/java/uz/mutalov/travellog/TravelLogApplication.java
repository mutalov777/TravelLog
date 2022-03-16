package uz.mutalov.travellog;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.mutalov.travellog.domain.AuthUser;
import uz.mutalov.travellog.enums.AuthRole;
import uz.mutalov.travellog.properties.OpenApiProperties;
import uz.mutalov.travellog.properties.ServerProperties;
import uz.mutalov.travellog.repository.AuthUserRepository;

@SpringBootApplication
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServerProperties.class
})
@OpenAPIDefinition
public class TravelLogApplication {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public TravelLogApplication(
            AuthUserRepository authUserRepository,
            PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(TravelLogApplication.class, args);
    }


//      @Bean
    CommandLineRunner runner() {
        return (args) -> {
            authUserRepository.deleteAll();
            String encode = passwordEncoder.encode("123");
            System.out.println("encode = " + encode);

            AuthUser admin = AuthUser.childBuilder()
                    .username("admin")
                    .password(encode)
                    .role(AuthRole.ADMIN)
                    .build();
            authUserRepository.save(admin);

            AuthUser user = AuthUser.childBuilder()
                    .username("user")
                    .password(encode)
                    .role(AuthRole.USER)
                    .build();
            authUserRepository.save(user);
        };
    }

}
