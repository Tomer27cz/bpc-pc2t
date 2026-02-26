import java.util.Scanner;

public class DatabaseOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pocet = 3;
        Databaze[] databaze = new Databaze[pocet];

        System.out.printf("Zadejte informace pro pocet osob: %d%n", pocet);

        for (int i = 0; i < databaze.length; i++) {
            System.out.print("Zadejte jméno: ");
            String jmeno = sc.nextLine();

            System.out.print("Zadejte rok: ");
            int rok = sc.nextInt();
            sc.nextLine();

            databaze[i] = new Databaze(jmeno, rok);

            System.out.println("-------------");
        }

        System.out.print("Zadejte maximální úvazek: ");
        double maxUvazek = sc.nextDouble();
        Databaze.setMaxUvazek(maxUvazek);

        System.out.println("------------------");

        while (true) {
            System.out.print("Zadejte Index osoby (nebo -1 pro ukončení): ");
            int index = sc.nextInt();
            sc.nextLine();

            if (index == -1) {
                System.out.println("Ukončuji program.");
                break;
            }

            if (index < 0 || index >= databaze.length) {
                System.out.printf("Index je mimo rozsah (0 - %d)%n", databaze.length);
                continue;
            }

            System.out.print("Zadejte výši nového úvazku: ");
            double novUvazek = sc.nextDouble();
            sc.nextLine();

            if (!databaze[index].addUvazek(novUvazek)) {
                System.out.println("Maximální úvazek překročen. Nelze přidat tento úvazek.");
                continue;
            }

            System.out.println("Jmeno: " + databaze[index].getJmeno());
            System.out.println("Rok: " + databaze[index].getRok());
            System.out.println("Úvazek: " + databaze[index].getUvazek());
            System.out.println();
        }

        sc.close();
    }

}
