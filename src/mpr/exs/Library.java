package mpr.exs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class Library {
	private Map<String, Set<Integer>> map = new TreeMap<String, Set<Integer>>(Collator.getInstance(Locale.getDefault()));
	public String fname;

	public Library(String fileName) {
		this.fname = fileName;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			PrzeliczSlowa(br);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie mogę otworzyć pliku " + fname);
		} catch (IOException e) {
			System.out.println("Błąd podczas czytania z pliku" + fname);
		}
	}
	
	private void PrzeliczSlowa(BufferedReader br) throws IOException {
		String line = br.readLine();
		Integer lineNumber = 1;
		while (line != null) {
			// oczyszczamy tekst ze znaków interpunkcyjnych, liczb itp. dolozone usuwanie [](
			line = line.replaceAll("\\d+|[:,\\.\"\\?!;\\-/\\[\\](]|\\b[XIV]+\\b", " ");
			// usuwamy ewentualne odstępy na początku i na końcu linii
			line = line.replaceAll("^\\s+|\\s+$", "");
			if (!line.matches("^\\s*$")) {
				String[] words = line.split("\\s+");
				for (String w : words) {
					Set<Integer> set = new TreeSet<Integer>();
					// sprawdzamy czy wpis dla tego slowa juz isnieje
					if (map.get(w.toLowerCase()) == null) {
						set.add(lineNumber);
					} else {
						set = map.get(w.toLowerCase());
						set.add(lineNumber);
					}
					map.put(w.toLowerCase(), set);
				}
			}
			lineNumber++;
			line = br.readLine();
		}
	}
	
	public void WypiszSlowa() {
		for (Map.Entry<String, Set<Integer>> wpis : map.entrySet()) {
            System.out.println(wpis.getKey() + "\t" + wpis.getValue().toString().replaceAll("^\\[|\\]$", ""));
        }
	}
	
	public void znajdzSlowaWLinii(Integer linia) {
		Set<String> set = new TreeSet<String>(Collator.getInstance(Locale.getDefault()));
		String slowa = new String();
		for (Map.Entry<String, Set<Integer>> wpis : map.entrySet()) {
			if (wpis.getValue().contains(linia)) {
				set.add(wpis.getKey());
			}
        }
		slowa = set.toString().replaceAll("^\\[|\\]$", "");
		if (slowa.isEmpty()) {
			System.out.println("Linia nr " + linia + " nie zawiera wyrazów.");
		} else {
			System.out.println("Linia nr " + linia + " zawiera:");
			System.out.println(slowa);
		}
	}
}
