package Pokemones.Tipos;

import Pokemones.Pokemon;

public class Fuego extends Pokemon {
    public Fuego(String nombre, int nivel, int salud, String tipo) {
        super(nombre, nivel, salud, tipo);
    }
    @Override
    public String ataqueEspecial(Pokemon oponente) {
        oponente.recibirAtaqueEspecial( this,danio + 50); // this porque soy el oponente del que ataqué
        return "Llamarada";}

    @Override
    public void recibirAtaqueEspecial(Pokemon oponente,int danio) {
        if(oponente.getTipo().equalsIgnoreCase("Fuego")){
            danio/=2;
        }
        super.recibirDanio(danio);
    }
}
