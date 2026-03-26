import java.util.HashMap;

public class Databaze {
	private HashMap<String, Student> prvkyDatabaze;

	public Databaze() {
		this.prvkyDatabaze = new HashMap<>();
	}

	public void addStudent(String jmeno, int rok) {
		prvkyDatabaze.put(jmeno, new Student(jmeno, rok));
	}

	public Student getStudent(String jmeno) {
		return prvkyDatabaze.get(jmeno);
	}

	public boolean setPrumer(String jmeno, float prumer) throws NeplatnyPrumerException {
		Student s = prvkyDatabaze.get(jmeno);
		if (s != null) {
			s.setStudijniPrumer(prumer);
			return true;
		}
		return false;
	}

	public void vypisVsechnyStudenty() {
		if (prvkyDatabaze.isEmpty()) {
			System.out.println("Databáze je prázdná.");
			return;
		}
		for (String jmeno : prvkyDatabaze.keySet()) {
			System.out.println("- " + jmeno);
		}
	}

	public boolean odstranStudenta(String jmeno) {
		if (prvkyDatabaze.containsKey(jmeno)) {
			prvkyDatabaze.remove(jmeno);
			return true;
		}
		return false;
	}
}