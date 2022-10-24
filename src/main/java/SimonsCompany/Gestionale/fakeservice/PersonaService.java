package SimonsCompany.Gestionale.fakeservice;

import SimonsCompany.Gestionale.exception.CustomException.*;
import SimonsCompany.Gestionale.model.Persona;

import SimonsCompany.Gestionale.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PersonaService {

    private final List<Persona> listaPersone = new ArrayList<>();

    @Autowired
    private final Utils utils;

    public PersonaService(Utils utils) {
        this.utils = utils;
        for (int i = 0; i <= 12; i++) {
            costruisceListaPersone(i);
        }
    }

    public Persona dammiUnaPersona(){
        return
                new Persona(1L,utils.listaDiNomi().get(1),
                        utils.listaDiCognomi().get(1),
                        utils.listaDiNumeri().get(1),
                        utils.listaDiNumeri().get(1) >= 18,
                        null);
    }

    public List<Persona> listaDiPersone(){return listaPersone;}

    public Persona creaPersona(Persona persona) {
        listaPersone.add(persona);
        return persona;
    }

    public Persona trovaUnaPersonaDaId(Long id) throws NotFoundException {
        return listaPersone.stream()
                .filter(lista -> lista.getId().equals(id)).findFirst().orElseThrow(NotFoundException::new);
    }

    public Stream<Object> modificaPersona(Persona persona) throws NotFoundException {
        Persona person = listaPersone.stream().filter(v -> v.getId().equals(persona.getId())).findFirst().orElseThrow(NotFoundException::new);
        Persona originaryPerson = new Persona(person.getId(), person.getNome(), person.getCognome(), person.getEta());
        person.setNome(persona.getNome());
        person.setCognome(persona.getCognome());
        person.setEta(persona.getEta());
        person.setEMagiorenne(persona.getEta() >= 18);
        return Stream.of("You modified this person:", originaryPerson, "Into this:", person);
    }


    private void costruisceListaPersone(int i) {
        listaPersone.add(
                new Persona(
                        (long) i, utils.listaDiNomi().get(i),
                        utils.listaDiCognomi().get(i),
                        utils.listaDiNumeri().get(i),
                        utils.listaDiNumeri().get(i) >=18,
                        null)
        );
    }
}
