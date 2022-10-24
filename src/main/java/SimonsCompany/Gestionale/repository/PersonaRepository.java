package SimonsCompany.Gestionale.repository;

import SimonsCompany.Gestionale.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findByNome(String nome);
}
