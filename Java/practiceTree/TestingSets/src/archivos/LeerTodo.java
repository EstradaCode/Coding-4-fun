package archivos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeerTodo {
    public static void main(String[] args) {
        var nombre= "mi_archivo_creado.txt";
        try{
            // leer todas las lineas del archivo
            List<String> lineas = Files.readAllLines(Paths.get(nombre));
            System.out.println("Contenido archivo");
            lineas.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("error al leer archivo:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
