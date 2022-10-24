package SimonsCompany.Gestionale.repository;

import SimonsCompany.Gestionale.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessRepository extends JpaRepository<Access, Long> {

    Optional<String> findByGuid(String guid);
}
