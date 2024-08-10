package archivos;

import java.io.*;

public class LeerArchivo {
    public static void main(String[] args) throws FileNotFoundException {
        var nombreArchivo = "mi_archivo_creado.txt";
        var archivo = new File(nombreArchivo);
        try{
            System.out.println("contenido del archivo:");
            // abrir archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            var linea = entrada.readLine();
            // leemos todas las lineas
            while(linea != null){
                System.out.println(linea);
                linea= entrada.readLine();
            }
            //
        }catch(IOException e){
            System.out.println("error!");
        }
    }
}
