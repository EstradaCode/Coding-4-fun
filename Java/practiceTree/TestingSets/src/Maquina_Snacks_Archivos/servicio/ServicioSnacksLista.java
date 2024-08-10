package Maquina_Snacks_Archivos.servicio;

import Maquina_Snacks_Archivos.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements  IServicioSnacks{
    private static final List<Snack> snacks;
    // bloque static inicializador
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("refresco", 500));
        snacks.add(new Snack("papas",2000));
        snacks.add(new Snack("Sandwich",120));
    }
    public void agregarSnack(Snack snack){
        snacks.add(snack);
    }
    public void mostrarSnacks(){
        var inventarioSnacks= "";
        for(var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el inventario---");
        System.out.println(inventarioSnacks);
    }
    public List<Snack> getSnacks() {
        return snacks;
    }
}
