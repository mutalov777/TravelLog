package uz.mutalov.travellog.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import uz.mutalov.travellog.enums.AuthRole;

import javax.persistence.*;

@Entity
@Table(name = "auth_user", indexes = {
        @Index(name = "auth_user_username_key",
                columnList = "username", unique = true
        )
})
@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser extends Auditable implements GrantedAuthority {

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name="auth_role",nullable=false)
    private AuthRole role;


    @Override
    public String getAuthority() {
        return role.name();
    }
}