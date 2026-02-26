public class Databaze {
    private String jmeno;
    private int rok;
    private double uvazek;
    private static double maxUvazek = 1.0;

    public Databaze(String jmeno, int rok) {
        this.jmeno = jmeno;
        this.rok = rok;
        this.uvazek = 0.0;
    }

    public String getJmeno() {return jmeno;}
    public int getRok() {return rok;}
    public double getUvazek() {return uvazek;}

    public static void setMaxUvazek(double newMaxUvazek) {
        maxUvazek = newMaxUvazek;
    }

    boolean addUvazek(double newUvazek) {
        if (this.uvazek + newUvazek > maxUvazek) {return false;}

        this.uvazek += newUvazek;
        return true;
    }
}
