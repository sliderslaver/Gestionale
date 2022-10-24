package SimonsCompany.Gestionale.service;

import SimonsCompany.Gestionale.exception.CustomException.*;
import SimonsCompany.Gestionale.model.Access;
import SimonsCompany.Gestionale.model.Persona;
import SimonsCompany.Gestionale.repository.AccessRepository;
import SimonsCompany.Gestionale.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private String uuid;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private AccessRepository accessRepository;


    public List<Persona> trovaListaPersone() {
        return personaRepository.findAll();
    }

    public List<Persona> trovaSingolaPersonaDalNome(String nome) {
        return personaRepository.findByNome(nome);
    }

    public Persona aggiungiUnaPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona modificaPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void eliminaPersonaDaId(Long id) {
        personaRepository.deleteById(id);
    }

    public String daiAccessoAdmin(Long id) throws NotFoundException {
        Persona persona = personaRepository.findById(id).stream().findFirst().orElseThrow(NotFoundException::new);
        persona.setGuid(UUID.randomUUID().toString());
        accessRepository.save(new Access(1L,persona.getGuid()));
        return "La persona col seguente id: "+id+" ha adesso accesso come amministratore";
    }

    public void login(Long id, String nome, String cognome, String password){
        Persona persona = personaRepository.findById(id).stream().filter(v -> v.getNome().equalsIgnoreCase(nome) && v.getCognome().equalsIgnoreCase(cognome) && v.getPassword().equals(password)).findFirst().orElseThrow(BadRequestException::new);
        uuid = persona.getGuid();
    }

    public void resolve(){
        accessRepository.findByGuid(uuid).stream().findFirst().orElseThrow(UnauthorizedException::new);
    }
}
