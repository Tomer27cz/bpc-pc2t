public class BPC2 implements Predmet {
    private static final int MAX_BODY_PROJEKT = 30;
    private static final int MAX_BODY_PULSEMESTR = 20;
    private static final int MAX_BODY_ZKOUSKA = 50;

    private int bodyProjekt = 0;
    private int bodyPulsemestr = 0;
    private int bodyZkouska = 0;

    @Override
    public String getNazev() { return "BPC2"; }

    @Override
    public int getPocetBodu() { return bodyProjekt + bodyPulsemestr + bodyZkouska; }

    @Override
    public boolean maZapocet() { return getPocetBodu() >= MIN_BODY_ZAPOCET; }

    public void setBodyProjekt(int body) {
        if (body < 0 || body > MAX_BODY_PROJEKT) throw new IllegalArgumentException("Body za projekt musí být 0-" + MAX_BODY_PROJEKT);
        this.bodyProjekt = body;
    }
    public void setBodyPulsemestr(int body) {
        if (body < 0 || body > MAX_BODY_PULSEMESTR) throw new IllegalArgumentException("Body z půlsemestrální zkoušky musí být 0-" + MAX_BODY_PULSEMESTR);
        this.bodyPulsemestr = body;
    }
    public void setBodyZkouska(int body) {
        if (body < 0 || body > MAX_BODY_ZKOUSKA) throw new IllegalArgumentException("Body ze závěrečné zkoušky musí být 0-" + MAX_BODY_ZKOUSKA);
        this.bodyZkouska = body;
    }
}
