public class DogImpl implements Animal {
    private byte age;
    public DogImpl(byte age) { this.age = age; }

    @Override public void sound() { System.out.println(getSoundString()); }
    @Override public String getSoundString() { return "Haf (z rozhraní)"; }
    @Override public String toString() { return "DogImpl{age=" + age + "}"; }
}