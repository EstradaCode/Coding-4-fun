package Pokemones;

public class MaestroPokemon {
    private String nombre;
    private int edad;
    private String pueblo;
    private int medallasGanadas;

    public MaestroPokemon(String nombre, int edad, String pueblo, int medallasGanadas) {
        this.nombre = nombre;
        this.edad = edad;
        this.pueblo = pueblo;
        this.medallasGanadas = medallasGanadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public int getMedallasGanadas() {
        return medallasGanadas;
    }

    public void setMedallasGanadas(int medallasGanadas) {
        this.medallasGanadas = medallasGanadas;
    }

    @Override
    public String toString() {
        return "MaestroPokemon: " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", pueblo='" + pueblo + '\'' +
                ", medallasGanadas=" + medallasGanadas;
    }
}
