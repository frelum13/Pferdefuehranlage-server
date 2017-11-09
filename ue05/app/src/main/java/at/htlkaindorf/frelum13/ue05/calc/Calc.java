package at.htlkaindorf.frelum13.ue05.calc;

/**
 * Created by Lukas on 09.11.2017.
 */

public class Calc {

    private final double laenge, breite;
    private double flaeche, umfang;
    private boolean istQuader = false;

    public Calc(double laenge, double breite) {
        this.laenge = laenge;
        this.breite = breite;

        calcflaeche();
        calcUmfang();
        calcIstQuader();
    }

    public double getFlaeche() {
        return flaeche;
    }

    public double getUmfang() {
        return umfang;
    }

    public boolean isIstQuader() {
        return istQuader;
    }

    private void calcflaeche()
    {
        flaeche = laenge * breite;
    }
    private void calcUmfang()
    {
        umfang = (laenge+breite)*2;
    }
    private void calcIstQuader()
    {
        if(laenge == breite)
            istQuader = true;
    }
}
