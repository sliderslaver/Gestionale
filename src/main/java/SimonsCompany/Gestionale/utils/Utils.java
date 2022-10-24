package SimonsCompany.Gestionale.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Utils {
    public List<String> listaDiNomi(){
        return List.of(
                "Simone",
                "Roberto",
                "Alessandro",
                "Lorenzo",
                "Diego",
                "Tommaso",
                "Riccardo",
                "Matteo",
                "Lorenzo",
                "Leonardo",
                "Gabriele",
                "Edoardo",
                "Samuele");
    }

    public List<String> listaDiCognomi(){
        return List.of(
                "Gigantini",
                "Di Mattia",
                "Rossi",
                "Ferrari",
                "Russo",
                "Bianchi",
                "Romano",
                "Gallo",
                "Costa",
                "Fontana",
                "Serra",
                "Farina",
                "Gentile");
    }

    public List<Integer> listaDiNumeri(){
        return List.of(32,42,55,95,78,47,58,24,14,26,35,28,10);
    }

}
