package at.lukasfreyler.ue01.calc;

/**
 * Created by lukas on 01.11.17.
 */

public class Calc {

    private final double laenge, breite, hoehe;
    private double oberflaeche, diagonale, volumen;
    private boolean istWuerfel;

    public Calc(double laenge, double breite, double hoehe) {
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;

        volumen();
        diagonale();
        oberflaeche();
        istWuerfel();
    }

    public double getOberflaeche() {
        return oberflaeche;
    }

    public double getDiagonale() {
        return diagonale;
    }

    public double getVolumen() {
        return volumen;
    }

    public boolean isIstWuerfel() {
        return istWuerfel;
    }

    private void volumen(){ volumen = laenge * breite * hoehe;}
    private void diagonale(){diagonale = Math.sqrt(Math.pow(laenge,2) + Math.pow(breite,2) + Math.pow(hoehe,2));}
    private void oberflaeche(){oberflaeche = laenge * breite * 2 + laenge * hoehe * 2 + hoehe * breite * 2;}
    private void istWuerfel(){if(laenge == breite && hoehe == laenge) istWuerfel = true; else istWuerfel = false;}
}
