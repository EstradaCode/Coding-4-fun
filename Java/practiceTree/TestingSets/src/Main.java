import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> conj = new HashSet<>();
        conj.add("carlos");
        conj.add("carlos");
        conj.add("vicky");
        conj.add("martu");
        System.out.println("elementos del set\n");
        conj.forEach(System.out::println);

        // se define por llave valor
        Map<String, String >persona = new HashMap<>();
        persona.put("nombre", "Diego");
        persona.put("apellido", "Flores"); // no tengo control sobre el orden interno del mapa
        persona.put("edad", "31"); // aunque repita el put no cambia el mapa, no permite duplicados
        System.out.println("mapa:");
        persona.entrySet().forEach(System.out::println);
        persona.put("edad","35"); // modifiqué
        persona.remove("apellido");
        persona.entrySet().forEach(System.out::println);
    }
}