public class GoatImpl implements Animal {
    private byte age;
    public GoatImpl(byte age) { this.age = age; }

    @Override public void sound() { System.out.println(getSoundString()); }
    @Override public String getSoundString() { return "Méé (z rozhraní)"; }
    @Override public String toString() { return "GoatImpl{age=" + age + "}"; }
}