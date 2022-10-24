package SimonsCompany.Gestionale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String cognome;

    private int eta;

    private boolean eMagiorenne;

    private String nullValueCauseJsonIncludeNonNull;

    @JsonIgnore
    private String guid;

    private  String password;

    public Persona(Long id, String nome, String cognome, int eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Persona(Long id, String nome, String cognome, int eta, boolean eMagiorenne, String nullValueCauseJsonIncludeNonNull) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.eMagiorenne = eMagiorenne;
        this.nullValueCauseJsonIncludeNonNull = nullValueCauseJsonIncludeNonNull;
    }
}
