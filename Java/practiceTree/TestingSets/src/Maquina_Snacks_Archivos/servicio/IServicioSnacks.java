package Maquina_Snacks_Archivos.servicio;
import Maquina_Snacks_Archivos.dominio.Snack;
import java.util.List;

public interface IServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnacks();
    List<Snack> getSnacks();
}
