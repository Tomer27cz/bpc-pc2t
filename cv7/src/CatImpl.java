public class CatImpl implements Animal {
    private byte age;
    public CatImpl(byte age) { this.age = age; }

    @Override public void sound() { System.out.println(getSoundString()); }
    @Override public String getSoundString() { return "Mňau (z rozhraní)"; }
    @Override public String toString() { return "CatImpl{age=" + age + ", sound=" + getSoundString() + "}"; }
}