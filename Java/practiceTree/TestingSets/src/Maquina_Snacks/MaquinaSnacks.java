package Maquina_Snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }
    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        // creamos la lista de productos de tipo snack
        List<Snack> productos = new ArrayList<>();
        System.out.println("** Maquina de Snacks **");
        Snacks.mostrarSnacks();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion,consola,productos);
            }catch(Exception e){
                System.out.println("Hubo un error: " + e.getMessage());

            }
            finally{
                System.out.println();// imprime un salto de linea con cada iteracion;
            }
        }
    }
    private static int mostrarMenu(Scanner consola){
        System.out.println("""
                1- Comprar snack
                2- Mostrar ticket
                3- Agregar Nuevo Snack
                4- Salir
                Elige una opcion : \s""");
        //leemos y retornamos la opcion seleccionada
        return Integer.parseInt(consola.nextLine());
    }
    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> lista){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola,lista);
            case 2 -> mostrarTicket(lista);
            case 3 -> agregarSnack(consola);
            case 4 ->{
                System.out.println("regresa pronto!");
                salir= true;
            }
            default -> System.out.println("opcion invalida");
        }
        return salir;
    }
    private static void agregarSnack(Scanner consola){
        System.out.println("nombre del snack: ");
        var nombre = consola.nextLine();
        System.out.println("precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre,precio));
        System.out.println("Snack agregado correctamente!");
        Snacks.mostrarSnacks();
    }
    private static void mostrarTicket(List<Snack> productos){
        String ticket = "*** ticket de venta ***";
        var total = 0.0;
        for(var producto: productos){
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\t total -> $" + total;
        System.out.println(ticket);
    }
    private static void comprarSnack(Scanner in, List<Snack>lista){
        System.out.println("¿Que snack quieres comprar(id)?");
        var idSnack = Integer.parseInt(in.nextLine());
        // validar que el snack exista en la lista de snacks
        var snackEncontrado = false;
        for(var snack : Snacks.getSnacks()){
            if(snack.getIdSnack()== idSnack){
                lista.add(snack);
                System.out.println("Snack " + snack.getNombre() + " agregado!");
                snackEncontrado= true;
                break;
            }
        }
        if(!snackEncontrado){
            System.out.println("id "+ idSnack+" de snack no encontrado! :(");
        }
    }
}
