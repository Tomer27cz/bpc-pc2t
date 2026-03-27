import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

/**
 * @author Moje Jméno
 *
 * Vysvětlení 9 (Abstraktní třída vs Interface):
 * - Abstraktní třída: Když máme příbuzné třídy které mají společné atributy nebo část kódu.
 * Třída může v Javě dědit jenom z jedné abstraktní třídy.
 * - Interface: Definuje "schopnost" (co má objekt umět), nezávisle na hierarchii tříd.
 * Obsahuje pouze "signatures" metod a konstanty. Třída může implementovat "nekonečně" rozhraní.
 *
 * Vysvětlení 10 (Enumerace vs String):
 * - Enumerace (Enum) se používá místo typu String pro type-safety. Zabraňuje překlepům (např. "ACTVIE" místo "ACTIVE"),
 * protože variable může nabývat jenom předem definovaných hodnot.
 */
public class App {

    public static void main(String[] args) {
        Employee emp1 = new Employee("Jan", "jan@firma.cz", "heslo123".toCharArray(), EmployeeType.ACTIVE);
        Employee emp2 = new Employee("Petr", "petr@firma.cz", "heslo123".toCharArray(), EmployeeType.INACTIVE);
        Employee emp3 = new Employee("Eva", "eva@firma.cz", "heslo123".toCharArray(), EmployeeType.ACTIVE);
        Employee emp4 = new Employee("Karel", "karel@firma.cz", "heslo123".toCharArray(), EmployeeType.DELETED);
        Employee emp5 = new Employee("Zdeněk", "zdenek@firma.cz", "heslo123".toCharArray(), EmployeeType.ACTIVE);

        Secretarian sec1 = new Secretarian("Anna", "anna@firma.cz", "sec123".toCharArray(), EmployeeType.ACTIVE, 30);
        Secretarian sec2 = new Secretarian("Lucie", "lucie@firma.cz", "sec123".toCharArray(), EmployeeType.ACTIVE, 25);

        Manager<Secretarian> manager = new Manager<>("Boss", "boss@firma.cz", "boss123".toCharArray(), EmployeeType.ACTIVE);
        manager.addRelationship(sec1);

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);
        manager.addEmployee(emp4);
        manager.addEmployee(emp5);

        Collections.sort(manager.getListOfEmployees());

        System.out.println("--- Zaměstnanci podřízeni Managerovi ---");
        for (Employee e : manager.getListOfEmployees()) {
            System.out.println(e);
        }

        System.out.println("\n--- Vztahy Managera ---");
        for (Secretarian s : manager.getListOfRelationships()) {
            System.out.println(s);
        }

        System.out.println("\n--- Zvuky zvířat (Abstraktní třída) ---");
        AbstractAnimal[] abstractAnimals = {
                new Cat((byte)3), new Dog((byte)5), new Pig((byte)2), new Cow((byte)4), new Goat((byte)6)
        };

        for (AbstractAnimal animal : abstractAnimals) {animal.sound();}

        System.out.println("\n--- Zvuky zvířat (Interface) ---");
        Animal[] interfacesAnimals = {
                new CatImpl((byte)3),
                new DogImpl((byte)5),
                new PigImpl((byte)2),
                new CowImpl((byte)4),
                new GoatImpl((byte)6)
        };

        for (Animal animal : interfacesAnimals) {animal.sound();}

        saveAnimalSoundToFile(interfacesAnimals[0], "zvuk_kocky.txt");
    }

    public static void saveAnimalSoundToFile(Animal animal, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(animal.getSoundString());
            System.out.println("\nZvuk zvířete byl úspěšně uložen do souboru: " + fileName);
        } catch (IOException e) {
            System.err.println("Chyba při zápisu do souboru: " + e.getMessage());
        }
    }
}