package Maquina_Snacks_Archivos.servicio;

import Maquina_Snacks_Archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements  IServicioSnacks{
    private final String NOMBRE_ARCHIVO= "Snacks.txt";
    private List<Snack> snacks = new ArrayList<>();
    public ServicioSnacksArchivos(){
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try{
            existe = archivo.exists();
            if(existe){
                this.snacks = obtenerSnacks();
            }else{
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close(); // en disco
                System.out.println("se ha creado el archivo!");
            }
        }catch (Exception e){
            System.out.println("error al crear el archivo ! " + e.getMessage());
        }
        if(!existe){
            cargarSnacksIniciales();
        }
    }

    @Override
    public void agregarSnack(Snack snack) {
        // agregamos el nuevo snack, 1ero en la lista en memoria
        this.snacks.add(snack);
        // 2- Guardamos el nuevo snack en el archivo;
        this.agregarSnackArchivo(snack);
    }
    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar= archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(snack.escribirEnArchivo());
            salida.close();
        }catch(Exception e){
            System.out.println("Error al agregar Snack:" + e.getMessage());
        }
    }
    private List<Snack> obtenerSnacks(){
        List<Snack> snacks = new ArrayList<>();
        try{
            // lee toda las lineas del archivo, las coloca en un list de strings
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for(String linea : lineas){
                String[] lineaSnack = linea.split(","); // devuelve un array con los 3 contenidos;
                Snack snack = new Snack(lineaSnack[1], Double.parseDouble(lineaSnack[2]));
                snacks.add(snack); // agrego snack leido de la lista
            }
        }catch(Exception e){
            System.out.println("Error al leer archivo de snacks" + e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }
    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack ("papas", 2000));
        this.agregarSnack(new Snack ("coca cola", 2200));
        this.agregarSnack(new Snack ( "turrón", 300));
    }
    @Override
    public void mostrarSnacks() {
        System.out.println("Snacks en el inventario!");
        String inventario= "";
        for(var snack : this.snacks){
            inventario += snack.toString() + "\n";
        }
        System.out.println(inventario);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
