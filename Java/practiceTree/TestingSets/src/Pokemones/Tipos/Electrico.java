package Pokemones.Tipos;

import Pokemones.Pokemon;

public class Electrico extends Pokemon {
    public Electrico(String nombre, int nivel, int salud, String tipo) {
        super(nombre, nivel, salud, tipo);
    }

    @Override
    public String ataqueEspecial(Pokemon oponente) {
        oponente.recibirAtaqueEspecial(this,danio + 40);
        oponente.setParalizado(true);
        return "ElectroJaula";
    }

    @Override
    public void recibirAtaqueEspecial(Pokemon oponente, int danio) {
        if(oponente.getTipo().equalsIgnoreCase("Electrico")){
            this.setParalizado(false);
        }
        super.recibirDanio(danio-20);
    }
}
