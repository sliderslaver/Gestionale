package SimonsCompany.Gestionale.fakecontroller;

import SimonsCompany.Gestionale.exception.CustomException.*;
import SimonsCompany.Gestionale.model.Persona;
import SimonsCompany.Gestionale.fakeservice.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    public ResponseEntity<Persona> dammiUnaPersona(){
        return ResponseEntity.ok(personaService.dammiUnaPersona());
    }

    @GetMapping("/listaPersone")
    public ResponseEntity<List<Persona>> listaDiPersone(){
        return ResponseEntity.ok(personaService.listaDiPersone());
    }

    @PostMapping("/creaPersona")
    public ResponseEntity<Persona> creazionePersona(@RequestBody Persona persona){
        return ResponseEntity.ok(personaService.creaPersona(persona));
    }

    @GetMapping("/trovaSingolaPersona")
    public ResponseEntity<?> trovaPersonaTramiteId(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(personaService.trovaUnaPersonaDaId(id));
        }catch (NotFoundException e) {
            return ResponseEntity.status(404).body("nessuna persona trovata con l'id" + id);
        }
    }

    @PutMapping("/modificaLaPersona")
    public ResponseEntity<?> modificaPersona(@RequestBody Persona persona){
        try {
            return ResponseEntity.ok(personaService.modificaPersona(persona));
        }catch (NotFoundException e) {
            return ResponseEntity.status(404).body("nessuna persona trovata con l'id" + persona.getId());
        }
    }
}
