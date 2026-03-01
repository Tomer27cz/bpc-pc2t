public class BPIS implements Predmet {
    private boolean zapocetUdelen = false;

    @Override
    public String getNazev() { return "BPIS"; }

    @Override
    public int getPocetBodu() {return 0;}

    @Override
    public boolean maZapocet() { return zapocetUdelen; }

    public void udelitZapocet() {this.zapocetUdelen = true;}
}