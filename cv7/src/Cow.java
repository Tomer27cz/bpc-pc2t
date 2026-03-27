public class Cow extends AbstractAnimal {
    public Cow(byte age) { super(age); }
    @Override public void sound() { System.out.println("Bůů"); }
}