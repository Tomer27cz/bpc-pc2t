import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BPC1 bpc1 = new BPC1();
        BPC2 bpc2 = new BPC2();
        BPIS bpis = new BPIS();

        System.out.println("=== ZADÁVÁNÍ HODNOCENÍ ===");

        System.out.println("\n--- Předmět BPC1 ---");
        System.out.print("Zadejte body za aktivitu cvičení: ");
        bpc1.pridejBodyAktivita(scanner.nextInt());
        System.out.print("Zadejte body za aktivitu laboratoře: ");
        bpc1.pridejBodyAktivita(scanner.nextInt());
        System.out.print("Zadejte body za závěrečnou zkoušku: ");
        bpc1.setBodyZkouska(scanner.nextInt());

        System.out.println("\n--- Předmět BPC2 ---");
        System.out.print("Zadejte body za projekt: ");
        bpc2.setBodyProjekt(scanner.nextInt());
        System.out.print("Zadejte body za půlsemestrální zkoušku: ");
        bpc2.setBodyPulsemestr(scanner.nextInt());
        System.out.print("Zadejte body za závěrečnou zkoušku: ");
        bpc2.setBodyZkouska(scanner.nextInt());

        System.out.println("\n--- Předmět BPIS ---");
        System.out.print("Chcete udělit zápočet z BPIS? (a/n): ");
        if (scanner.next().equalsIgnoreCase("a")) {
            bpis.udelitZapocet();
        }

        System.out.println("\n=== VÝSLEDKY ===");

        Predmet[] seznamPredmetu = {bpc1, bpc2, bpis};

        for (Predmet p : seznamPredmetu) {
            System.out.println("Předmět: " + p.getNazev());
            System.out.println("Celkový počet bodů: " + p.getPocetBodu());
            System.out.println("Zápočet: " + (p.maZapocet() ? "UDĚLEN" : "NEUDĚLEN"));
            System.out.println("-----------------");
        }

        scanner.close();
    }
}