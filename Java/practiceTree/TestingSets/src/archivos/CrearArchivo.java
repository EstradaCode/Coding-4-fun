package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearArchivo {
    public static void main(String[] args) {
        var nombreArchivo = "mi_archivo_creado.txt";
        var archivo = new File(nombreArchivo);
        try{
            if(archivo.exists()){
                System.out.println("archivo ya existe en la carpeta");
            }else{
                // creamos archivo
                PrintWriter salida = new PrintWriter(new FileWriter(archivo)); // file writer crea archivo, para guardar info y que se coloque en disco duro printwriter
                salida.close(); // close guarda la info en disco duro.s
            }
        }catch(IOException e ){
            System.out.println("error! no se pudo crear el archivo!" + e.getMessage());
            e.printStackTrace(); // traza de todos los errores que generaron la exception
        }
    }
}
