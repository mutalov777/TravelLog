package uz.mutalov.travellog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.mutalov.travellog.domain.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser,Long> {

    @Query(value = "select au.* from auth_user  au where au.username=:name and au.is_deleted=0 ", nativeQuery = true)
    Optional<AuthUser> findByUsernameAndDeletedFalse(String name);

}
