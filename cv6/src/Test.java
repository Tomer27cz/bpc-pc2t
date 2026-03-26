import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Databaze mojeDatabaze = new Databaze(1);
		boolean run = true;

		System.out.println("=== Správa studentské databáze ===");

		while(run) {
			System.out.println("\nVyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. ukonceni aplikace");
			System.out.print("Vaše volba: ");

			try {
				int volba = sc.nextInt();

				switch(volba) {
					case 1:
						System.out.print("Zadejte pocet studentu: ");
						int kapacita = sc.nextInt();
						mojeDatabaze = new Databaze(kapacita);
						System.out.println("[INFO] Databáze o kapacitě " + kapacita + " byla vytvořena.");
						break;

					case 2:
						System.out.print("Zadejte jmeno studenta: ");
						String jmeno = sc.next();
						System.out.print("Zadejte rok narozeni studenta: ");
						int rok = sc.nextInt();
						mojeDatabaze.addStudent(jmeno, rok);
						System.out.println("[INFO] Student " + jmeno + " byl přidán do databáze.");
						break;

					case 3:
						System.out.print("Zadejte index studenta: ");
						int idx = sc.nextInt();
						System.out.print("Zadejte prumer studenta (oddělené čárkou) : ");
						float prumer = sc.nextFloat();
						mojeDatabaze.setPrumer(idx, prumer);
						System.out.println("[INFO] Průměr úspěšně nastaven.");
						break;

					case 4:
						System.out.print("Zadejte index studenta pro výpis: ");
						int idxVypis = sc.nextInt();
						Student info = mojeDatabaze.getStudent(idxVypis);

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
						break;

					case 5:
						System.out.println("Aplikace bude ukončena. Na shledanou!");
						run = false;
						break;

					default:
						System.out.println("[VAROVÁNÍ] Neznámá volba. Prosím, zadejte číslo v rozsahu 1-5.");
						break;
				}

			} catch (InputMismatchException e) {
				System.err.println("[CHYBA VSTUPU] Očekávána byla číselná hodnota, zadali jste neplatný znak.");
				sc.nextLine();

			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("[CHYBA INDEXU] " + e.getMessage());

			} catch (NullPointerException e) {
				System.err.println("[CHYBA DAT] " + e.getMessage());

			} catch (NeplatnyPrumerException e) {
				System.err.println("[CHYBA PRŮMĚRU] " + e.getMessage());

			} catch (IllegalArgumentException e) {
				System.err.println("[CHYBA ZADÁNÍ] " + e.getMessage());

			} catch (Exception e) {
				System.err.println("[NEOČEKÁVANÁ CHYBA] Došlo k systémové chybě: " + e.getMessage());
			}
		}

		sc.close();
	}
}