package Pokemones;

import Pokemones.Tipos.Agua;
import Pokemones.Tipos.Electrico;
import Pokemones.Tipos.Fuego;

import java.util.Scanner;

public class BatallaPokemon {
    public static void main(String[] args) {
        Pokedex pokedex1= new Pokedex(new MaestroPokemon("Ludmila",20,"Paleta", 12),5);
        Pokedex pokedex2 = new Pokedex(new MaestroPokemon("Giovanna", 19, "Kanto", 3),6);
        pokedex1.agregarPokemon(new Electrico("PIKACHU",1,100,"Electrico"));
        pokedex1.agregarPokemon(new Agua("Squirtle", 2,100, "Agua"));
        pokedex1.agregarPokemon(new Fuego("Flareon", 6, 100,"Fuego"));
        pokedex1.agregarPokemon(new Fuego("Charmander", 5, 100,"Fuego"));

        //turno del 2
        pokedex2.agregarPokemon(new Fuego("Dragonite", 10, 100, "Fuego"));
        pokedex2.agregarPokemon(new Electrico("Raichu", 11, 100, "Electrico"));
        pokedex2.agregarPokemon(new Agua("Blastoise", 3,100,"Agua" ));
        Batalla(pokedex1,pokedex2);
    }
    public static void Batalla(Pokedex pokedex1, Pokedex pokedex2){
        //Scanner in = new Scanner(System.in);
        System.out.println("el jugador1 elije sus 3 pokemones! ");
        Pokemon[] pokemons1 = PokemonesALuchar(pokedex1);
        System.out.println("el jugador1 elije sus 3 pokemones! ");
        Pokemon[] pokemons2 = PokemonesALuchar(pokedex2);
        boolean peleando = true;
        int turno = 1,alternante=1;

        while (peleando) {
            Pokemon atacante, defensor;
            if (turno % 2 != 0) {
                atacante = seleccionarPokemonActivo(pokemons1);
                defensor = seleccionarPokemonActivo(pokemons2);
            } else {
                atacante = seleccionarPokemonActivo(pokemons2);
                defensor = seleccionarPokemonActivo(pokemons1);
            }

            System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + "!");
            if(alternante % 3 != 0){
                atacante.ataque(defensor);
            }else{
                System.out.println(atacante.getNombre() + " usa " + atacante.ataqueEspecial(defensor));
            }

            if (defensor.getSalud() <= 0) {
                System.out.println(defensor.getNombre() + " ha sido derrotado!");
                System.out.println(atacante.getNombre() + " sube de nivel!!");
                atacante.subirNivel();
                System.out.println(atacante.getNombre() + " a nivel " + atacante.getNivel());
            }

            if (equipoDerrotado(pokemons1) || equipoDerrotado(pokemons2)) {
                peleando = false;
                if (equipoDerrotado(pokemons1)) {
                    System.out.println("Jugador 2: " + pokedex2.getMaestro().getNombre() + "  gana la batalla!");
                } else {
                    System.out.println("Jugador 1: " + pokedex1.getMaestro().getNombre() + "  gana la batalla!");
                }
            }

            turno++;
            alternante++;
        }
    }
    public static Pokemon seleccionarPokemonActivo(Pokemon[] equipo){
        for(Pokemon pokemon: equipo){
            if(pokemon.getSalud()>0){
                return pokemon;
            }
        }
        return null;
    }
    public static boolean equipoDerrotado(Pokemon[] equipo){
        for(Pokemon pokemon : equipo){
            if(pokemon.getSalud()>0){
                return false;
            }
        }
        return true;
    }
    public static Pokemon[] PokemonesALuchar(Pokedex pokedex){
        Pokemon[] pokemonesArray = new Pokemon[3]; // a lo sumo 3 pokemones
        Scanner in = new Scanner(System.in);
        Pokemon pokemon; int i = 0 ;
        while(i < 3){
            System.out.println("busca tu pokemon!");
            pokemon = pokedex.PokemonYoTeElijo(in.next()) ;
            if( pokemon != null){
                pokemonesArray[i] = pokemon;
                i++;
            }else {
                System.out.println("ese pokemon no existe! elije otro");
            }
        }
        return pokemonesArray;
    }
}
