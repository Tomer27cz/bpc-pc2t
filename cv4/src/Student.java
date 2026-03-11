public class Student {
	public Student(String jmeno, int rocnik) {
		this.jmeno=jmeno;
		this.rocnik=rocnik;
		this.studijniPrumer = 0.0f;
	}

	public String getJmeno() {
		return jmeno;
	}

	public int getRocnik() {
		return rocnik;
	}

	public float getStudijniPrumer() throws NeplatnyPrumerException {
		if (this.studijniPrumer == 0.0f) {
			throw new NeplatnyPrumerException("U tohoto studenta dosud nebyl zadán žádný studijní průměr.");
		}
		return studijniPrumer;
	}

	public void setStudijniPrumer(float studijniPrumer) throws NeplatnyPrumerException {
		if (studijniPrumer < 1.0f || studijniPrumer > 5.0f) {
			throw new NeplatnyPrumerException("Zadaný průměr (" + studijniPrumer + ") není platný. Průměr musí být v rozsahu 1 až 5.");
		}
		this.studijniPrumer = studijniPrumer;
	}

	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}