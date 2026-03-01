public class BPC1 implements Predmet {
    private static final int MAX_BODY_AKTIVITA = 20;
    private static final int MAX_BODY_ZKOUSKA = 80;

    private int bodyAktivita = 0;
    private int bodyZkouska = 0;

    @Override
    public String getNazev() {return "BPC1";}

    @Override
    public int getPocetBodu() {return bodyAktivita + bodyZkouska;}

    @Override
    public boolean maZapocet() {return getPocetBodu() >= MIN_BODY_ZAPOCET;}

    public void pridejBodyAktivita(int body) {
        if (body < 0) throw new IllegalArgumentException("Body nesmí být záporné.");
        if (bodyAktivita + body > MAX_BODY_AKTIVITA) throw new IllegalArgumentException("Maximální počet bodů za aktivitu je " + MAX_BODY_AKTIVITA);

        this.bodyAktivita += body;
    }

    public void setBodyZkouska(int body) {
        if (body < 0 || body > MAX_BODY_ZKOUSKA) throw new IllegalArgumentException("Body ze zkoušky musí být v rozmezí 0 až " + MAX_BODY_ZKOUSKA);

        this.bodyZkouska = body;
    }
}
