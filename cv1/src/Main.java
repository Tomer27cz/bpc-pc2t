import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadejte číslo k testování: ");

        if (!sc.hasNextInt()) {
            System.out.println("Nezadali jste celé číslo.");
            sc.close();
            return;
        }

        int cislo = sc.nextInt();

        String vysledek = jePrvocislo(cislo) ? "je prvočíslo" : "není prvočíslo";
        System.out.printf("Číslo %d %s.", cislo, vysledek);

        sc.close();
    }

    public static boolean jePrvocislo(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {

            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
