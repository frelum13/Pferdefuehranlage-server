package at.lukasfreyler.ue01.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Scanner;

import at.lukasfreyler.ue01.R;
import at.lukasfreyler.ue01.calc.Calc;

public class MainActivity extends AppCompatActivity {

    private double getValue(int rsid)
    {
        final EditText editText = findViewById(rsid);
        final String string = editText.getText().toString();

        return new Scanner(string).nextDouble();
    }

    public void onBerechnen(View view)
    {
        try {
            double laenge = getValue(R.id.etLaenge);
            double breite = getValue(R.id.etBreite);
            double hoahe = getValue(R.id.etHoehe);

            Calc calc = new Calc(laenge, breite, hoahe);
            double volumen = calc.getVolumen();
            double oberflaeche = calc.getOberflaeche();
            double diagonale = calc.getDiagonale();
            boolean istWuerfel = calc.isIstWuerfel();

            final Intent intent = new Intent(this, Ergebnisse.class);
            intent.putExtra("istWuerfel", istWuerfel);
            intent.putExtra("volumen", volumen);
            intent.putExtra("oberflaeche", oberflaeche);
            intent.putExtra("diagonale", diagonale);
            startActivity(intent);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
