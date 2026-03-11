import java.util.Scanner;

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
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}