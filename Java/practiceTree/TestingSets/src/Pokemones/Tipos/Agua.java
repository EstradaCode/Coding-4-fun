package Pokemones.Tipos;

import Pokemones.Pokemon;

public class Agua extends Pokemon {
    public Agua(String nombre, int nivel, int salud, String tipo) {
        super(nombre, nivel, salud, tipo);
    }

    @Override
    public String ataqueEspecial(Pokemon oponente) {
        oponente.recibirAtaqueEspecial(this,danio + 50);
        return "Burbuja";

    }

    @Override
    public void recibirAtaqueEspecial(Pokemon oponente, int danio) {
        if(oponente.getTipo().equalsIgnoreCase("Agua")){
            curarse();
        }
        super.recibirDanio(danio);
    }
    public void curarse(){
        setSalud(getSalud() + 40);
    }

}
