package Pokemones;

public class Pokedex {
    private Pokemon [] pokemones;
    private int cantidadPokemones;
    private MaestroPokemon maestro;

    public Pokedex(MaestroPokemon maestro,int n){
        pokemones= new Pokemon[n];
        cantidadPokemones=0;
        this.maestro = maestro;

    }
    public Pokedex(){}
    public void agregarPokemon(Pokemon pokemon){
        if(cantidadPokemones < pokemones.length ) {
            pokemones[cantidadPokemones] = pokemon;
            cantidadPokemones++;
        }
    }
    public Pokemon PokemonYoTeElijo(String nombre){
        Pokemon pokemonAct = null;
        for(int i = 0; i< cantidadPokemones;i++){
            if(pokemones[i].getNombre().equals(nombre)) {
                pokemonAct = pokemones[i];
            }
        }
        return pokemonAct;
    }
    public MaestroPokemon getMaestro() {
        return maestro;
    }

    public void setMaestro(MaestroPokemon maestro) {
        this.maestro = maestro;
    }
    public String verInfoPokemones(){
        String info = "";
        for( Pokemon pokemon : pokemones){
            info += pokemon.Informacion() + "\n";
        }
        return info;
    }
}
