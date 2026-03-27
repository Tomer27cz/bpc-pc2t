public class PigImpl implements Animal {
    private byte age;
    public PigImpl(byte age) { this.age = age; }

    @Override public void sound() { System.out.println(getSoundString()); }
    @Override public String getSoundString() { return "Chro chro (z rozhraní)"; }
    @Override public String toString() { return "PigImpl{age=" + age + "}"; }
}