package mpr.exs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import mpr.exs.Library;
/*
 * Korzystając z mechanizmów kolekcji (w tym z odwzorowań/map) zmodyfikuj
 * poniższy kod tak, żeby na standardowym wyjściu produkować „indeks wystapień
 * słów” w załączonym tekście „Księcia” Machiavellego. Indeks powinien składać się 
 * z linii postaci:
 * 
 * <słowo><tabulacja><w1>, <w2>, <w3>, ..., <wk>
 * 
 * gdzie:
 *   - <słowo> oznacza dowolne słowo wystepujące w tekście
 *   - <tabulacja> oznacza znak tabulacji
 *   - <w1>,...,<wk> oznaczają numery wierszy w tekście, w których słowo występuje
 *   
 * Dodatkowe założenia:
 * 
 *   - Sporządzając indeks pomijamy różnice pomiędzy wielkimi i małymi literami.
 *   - Indeks powinien być posortowany alfabetycznie.
 *   - Słowa w indeksie powinny występować bez powtórzeń.
 *   - Numery wierszy (w rwmach pojedynczego wpisu) powinny być uporządkowane rosnąco (bez powtórzeń).
 * 
 */
public class Ex03 {

	public static void main(String[] args) {
		Library slowaWPliku = new Library("Machiavelli.txt");
		slowaWPliku.WypiszSlowa();
		slowaWPliku.znajdzSlowaWLinii(4);
		slowaWPliku.znajdzSlowaWLinii(118);
		slowaWPliku.znajdzSlowaWLinii(224);
	}

}
