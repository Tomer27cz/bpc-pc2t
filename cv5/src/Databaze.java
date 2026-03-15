import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Databaze {
	public Databaze(int pocetPrvku) {
		if (pocetPrvku <= 0) {
			throw new IllegalArgumentException("Kapacita databáze musí být větší než nula.");
		}
		this.prvkyDatabaze = new Student[pocetPrvku];
		this.posledniStudent = 0;
	}

	public void addStudent(String jmeno, int rok) {
		if (posledniStudent >= prvkyDatabaze.length) {
			throw new ArrayIndexOutOfBoundsException("Kapacita databáze byla překročena. Nelze přidat dalšího studenta.");
		}
		prvkyDatabaze[posledniStudent++] = new Student(jmeno, rok);
	}

	public Student getStudent(int idx) {
		if (idx < 0 || idx >= prvkyDatabaze.length) {
			throw new ArrayIndexOutOfBoundsException("Zadali jste index (" + idx + ") mimo rozsah databáze.");
		}
		if (prvkyDatabaze[idx] == null) {
			throw new NullPointerException("Na indexu " + idx + " se nenachází žádný záznam o studentovi.");
		}
		return prvkyDatabaze[idx];
	}

	public void setPrumer(int idx, float prumer) throws NeplatnyPrumerException {
		Student s = getStudent(idx);
		s.setStudijniPrumer(prumer);
	}

	public void printDatabase() {
		System.out.println("\n--- OBSAH DATABÁZE ---");
		for (int i = 0; i < posledniStudent; i++) {
			Student s = prvkyDatabaze[i];
			String prumerStr;
			try {
				prumerStr = String.valueOf(s.getStudijniPrumer()).replace('.', ',');
			} catch (NeplatnyPrumerException e) {
				prumerStr = "nezadán";
			}
			System.out.println("Jmeno: " + s.getJmeno() + ", rok narozeni: " + s.getRocnik() + ", studijni prumer: " + prumerStr);
		}
		if (posledniStudent == 0) {
			System.out.println("Databáze je prázdná.");
		}
		System.out.println("----------------------");
	}

	public void saveToFile(String nazevSouboru) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nazevSouboru))) {
			bw.write(String.valueOf(prvkyDatabaze.length));
			bw.newLine();
			for (int i = 0; i < posledniStudent; i++) {
				Student s = prvkyDatabaze[i];
				float prumer = 0.0f;
				try {
					prumer = s.getStudijniPrumer();
				} catch (NeplatnyPrumerException e) {
					prumer = 0.0f;
				}
				bw.write(s.getJmeno() + ";" + s.getRocnik() + ";" + prumer);
				bw.newLine();
			}
		}
	}

	public void loadFromFile(String nazevSouboru) throws IOException, NeplatnyPrumerException {
		try (BufferedReader br = new BufferedReader(new FileReader(nazevSouboru))) {
			String line = br.readLine();
			if (line == null) return;

			int kapacita = Integer.parseInt(line);
			this.prvkyDatabaze = new Student[kapacita];
			this.posledniStudent = 0;

			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts.length >= 2) {
					String jmeno = parts[0];
					int rok = Integer.parseInt(parts[1]);
					addStudent(jmeno, rok);

					if (parts.length == 3) {
						float prumer = Float.parseFloat(parts[2]);
						if (prumer != 0.0f) {
							setPrumer(posledniStudent - 1, prumer);
						}
					}
				}
			}
		} catch (NumberFormatException e) {
			throw new IOException("Soubor má poškozený formát dat.", e);
		}
	}

	private Student [] prvkyDatabaze;
	private int posledniStudent;
}