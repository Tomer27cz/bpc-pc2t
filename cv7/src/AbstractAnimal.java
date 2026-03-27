public abstract class AbstractAnimal {
    protected byte age;

    public AbstractAnimal(byte age) {
        this.age = age;
    }

    public abstract void sound();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{age=" + age + "}";
    }
}