package uz.mutalov.travellog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.mutalov.travellog.domain.Log;
import uz.mutalov.travellog.repository.base.BaseRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>, BaseRepository {

    Optional<Log> findByIdAndDeletedFalse(Long id);

    Page<Log> findAllByDeletedFalse(Pageable pageable);

    @Query(value = "select l.* from log.log l where l.date between :first and :last and l.is_deleted=0 ",nativeQuery = true)
    List<Log> findByDateAndDeletedFalse(LocalDate first, LocalDate last);

    @Query(value = "select l.* from log.log l where l.registration_number=:rNumber or l.owner_name=:rNumber and l.is_deleted=0 ",nativeQuery = true)
    List<Log> findByRegistrationNumberOrOwnerNameAndDeletedFalse(String rNumber);



}
