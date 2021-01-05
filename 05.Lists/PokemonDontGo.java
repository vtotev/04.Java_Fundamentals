package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> gonePokemons = new ArrayList<>();
        while (!pokemons.isEmpty()) {
            int index = Integer.parseInt(scan.nextLine());
            goPokemons(pokemons, gonePokemons, index);
        }
        int sum = 0;
        for (int i = 0; i < gonePokemons.size(); i++) {
            sum += gonePokemons.get(i);
        }
        System.out.println(sum);
    }

    private static void goPokemons(List<Integer> pokemons, List<Integer> gonePokemons, int index) {

        if (index < 0) {
            int removedElement = pokemons.get(0);
            pokemons.set(0, pokemons.get(pokemons.size() - 1));
            IncreaseDecreasePokemons(pokemons, removedElement);
            gonePokemons.add(removedElement);
            return;
        }
        if (index > pokemons.size()-1) {
            int removedElement = pokemons.get(pokemons.size() - 1);
            pokemons.set(pokemons.size() - 1, pokemons.get(0));
            IncreaseDecreasePokemons(pokemons, removedElement);
            gonePokemons.add(removedElement);
            return;
        }

        int pokemonToGo = pokemons.get(index);
        gonePokemons.add(pokemonToGo);
        IncreaseDecreasePokemons(pokemons, pokemonToGo);
        pokemons.remove(index);
    }

    private static void IncreaseDecreasePokemons(List<Integer> pokemons, int pokemonToGo) {
        for (int i = 0; i < pokemons.size(); i++) {
            int currPokemon = pokemons.get(i);
            if (currPokemon <= pokemonToGo)
                pokemons.set(i, currPokemon + pokemonToGo);
            else
                pokemons.set(i, currPokemon - pokemonToGo);
        }
    }
}
