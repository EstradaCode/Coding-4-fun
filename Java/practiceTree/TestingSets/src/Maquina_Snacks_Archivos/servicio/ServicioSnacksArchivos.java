package Maquina_Snacks_Archivos.servicio;

import Maquina_Snacks.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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
                //this.snacks = obtenerSnacks();
            }else{
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close(); // en disco
                System.out.println("se ha creado el archivo!");
            }
        }catch (Exception e){
            System.out.println("error al crear el archivo ! " + e.getMessage());
        }
        if(!existe){
            //cargarSnacksIniciales();
        }
    }

    @Override
    public void agregarSnack(Maquina_Snacks_Archivos.dominio.Snack snack) {

    }

    @Override
    public void mostrarSnacks() {

    }

    @Override
    public List<Maquina_Snacks_Archivos.dominio.Snack> getSnacks() {
        return List.of();
    }
}
