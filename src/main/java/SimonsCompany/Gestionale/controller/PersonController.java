package SimonsCompany.Gestionale.controller;

import SimonsCompany.Gestionale.model.Persona;
import SimonsCompany.Gestionale.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/listaPersoneReali")
    public ResponseEntity<List<Persona>> trovaPersone(){
        personService.resolve();
        return ResponseEntity.ok(personService.trovaListaPersone());
    }

    @GetMapping("/nomePersona")
    public ResponseEntity<List<Persona>> trovaPersona(@RequestParam @NotBlank @NotNull @NotEmpty String nome){
        personService.resolve();
        return ResponseEntity.ok(personService.trovaSingolaPersonaDalNome(nome));
    }

    @PostMapping("/aggiungiPersona")
    public ResponseEntity<?> aggiungiPersona(@RequestBody Persona persona){
        personService.resolve();
        try {
            return ResponseEntity.ok(personService.aggiungiUnaPersona(persona));
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("controlla di aver inserito tutti i campi");
        }
    }

    @PutMapping("/modificaPersona")
    public ResponseEntity<Persona> modificaPersona(@RequestBody Persona persona){
        personService.resolve();
        return ResponseEntity.ok(personService.modificaPersona(persona));
    }

    @DeleteMapping("/eliminaPersona")
    public ResponseEntity<Persona> eliminaPersona(@RequestParam Long id){
        personService.eliminaPersonaDaId(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/permessiAdmin")
    public ResponseEntity<?> aggiungiPersona(@RequestParam Long id){
        personService.resolve();
        try {
            return ResponseEntity.ok(personService.daiAccessoAdmin(id));
        }catch (RuntimeException e) {
            return ResponseEntity.status(404).body("nessuna persona col seguente id: " + id + " trovata");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam Long id, String nome, String cognome, String password){
        personService.login(id,nome,cognome,password);
        return ResponseEntity.ok().build();
    }

}
