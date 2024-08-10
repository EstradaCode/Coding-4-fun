package Pokemones;

import java.util.Random;

public abstract class Pokemon {
    protected static final int danio=20;
    private String nombre;
    private int nivel;
    private int salud;
    private String tipo;
    private boolean paralizado;

    public Pokemon(String nombre, int nivel, int salud, String tipo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }
    public void subirNivel(){
        nivel++;
    }
    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void ataque(Pokemon oponente){
        oponente.recibirDanio(danio + danioExtra());
    }
    public abstract String ataqueEspecial(Pokemon oponente);
    public abstract void recibirAtaqueEspecial(Pokemon oponente, int danio);

    public boolean isParalizado() {
        return paralizado;
    }

    public void setParalizado(boolean paralizado) {
        this.paralizado = paralizado;
    }

    public void recibirDanio(int danio){
        salud -= danio;
    }
    private int danioExtra(){
        return new Random().nextInt(10);
    }
    public String Informacion(){
        return "pokemon: " + nombre + " - nivel : " + nombre + " - salud: " + salud + "- tipo: " + tipo;
    }

}
