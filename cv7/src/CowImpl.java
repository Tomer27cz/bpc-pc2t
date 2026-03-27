public class CowImpl implements Animal {
    private byte age;
    public CowImpl(byte age) { this.age = age; }

    @Override public void sound() { System.out.println(getSoundString()); }
    @Override public String getSoundString() { return "Bůů (z rozhraní)"; }
    @Override public String toString() { return "CowImpl{age=" + age + "}"; }
}