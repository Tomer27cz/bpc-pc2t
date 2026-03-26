import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Databaze mojeDatabaze = new Databaze();
		boolean run = true;

		System.out.println("=== Správa studentské databáze ===");

		while(run) {
			System.out.println("\nVyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho studenta");
			System.out.println("2 .. nastaveni prumeru studenta");
			System.out.println("3 .. vypis informace o studentovi");
			System.out.println("4 .. vypis jmen všech studentů v databázi");
			System.out.println("5 .. odstranění studenta");
			System.out.println("6 .. ukonceni aplikace");
			System.out.print("Vaše volba: ");

			try {
				int volba = sc.nextInt();
				sc.nextLine();

				switch(volba) {
					case 1:
						System.out.print("Zadejte jmeno studenta: ");
						String jmeno = sc.next();
						System.out.print("Zadejte rok narozeni studenta: ");
						int rok = sc.nextInt();
						mojeDatabaze.addStudent(jmeno, rok);
						System.out.println("[INFO] Student " + jmeno + " byl přidán do databáze.");
						break;

					case 2:
						System.out.print("Zadejte jmeno studenta: ");
						String jmenoPrumer = sc.nextLine();
						System.out.print("Zadejte prumer studenta (oddělené čárkou) : ");
						float prumer = sc.nextFloat();

						if (mojeDatabaze.setPrumer(jmenoPrumer, prumer)) {
							System.out.println("[INFO] Průměr úspěšně nastaven.");
						} else {
							System.out.println("[CHYBA - false] Student " + jmenoPrumer + " nebyl v databázi nalezen.");
						}
						break;

					case 3:
						System.out.print("Zadejte jmeno studenta pro výpis: ");
						String jmenoVypis = sc.nextLine();
						Student info = mojeDatabaze.getStudent(jmenoVypis);

						if (info != null) {
							String prumerStr;
							try {
								prumerStr = String.valueOf(info.getStudijniPrumer());
							} catch (NeplatnyPrumerException e) {
								prumerStr = "Nelze vyhodnotit (" + e.getMessage() + ")";
							}

							System.out.println("\n--- KARTA STUDENTA ---");
							System.out.println("Jmeno: " + info.getJmeno());
							System.out.println("Rok narozeni: " + info.getRocnik());
							System.out.println("Studijni prumer: " + prumerStr);
							System.out.println("----------------------");
						} else {
							System.out.println("[CHYBA - false] Student " + jmenoVypis + " nebyl v databázi nalezen.");
						}
						break;

					case 4:
						System.out.println("\n--- SEZNAM STUDENTŮ ---");
						mojeDatabaze.vypisVsechnyStudenty();
						System.out.println("-----------------------");
						break;

					case 5:
						System.out.print("Zadejte jmeno studenta pro odstranění: ");
						String jmenoSmazat = sc.nextLine();
						if (mojeDatabaze.odstranStudenta(jmenoSmazat)) {
							System.out.println("[INFO] Student " + jmenoSmazat + " byl úspěšně smazán.");
						} else {
							System.out.println("[CHYBA - false] Student s tímto jménem v databázi neexistuje.");
						}
						break;

					case 6:
						System.out.println("Aplikace bude ukončena. Na shledanou!");
						run = false;
						break;

					default:
						System.out.println("[VAROVÁNÍ] Neznámá volba. Prosím, zadejte číslo v rozsahu 1-6.");
						break;
				}

			} catch (InputMismatchException e) {
				System.err.println("[CHYBA VSTUPU] Očekávána byla číselná hodnota, zadali jste neplatný znak.");
				sc.nextLine(); // Vyčištění vadného vstupu
			} catch (NeplatnyPrumerException e) {
				System.err.println("[CHYBA PRŮMĚRU] " + e.getMessage());
			} catch (Exception e) {
				System.err.println("[NEOČEKÁVANÁ CHYBA] Došlo k systémové chybě: " + e.getMessage());
			}
		}

		sc.close();
	}
}