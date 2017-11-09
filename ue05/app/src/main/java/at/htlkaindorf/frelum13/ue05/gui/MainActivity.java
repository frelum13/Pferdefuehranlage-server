package at.htlkaindorf.frelum13.ue05.gui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Scanner;

import at.htlkaindorf.frelum13.ue05.R;
import at.htlkaindorf.frelum13.ue05.calc.Calc;

public class MainActivity extends AppCompatActivity {

    private double setText(int rsid)
    {
        EditText editText = (EditText) findViewById(rsid);
        String string = editText.getText().toString();

        return new Scanner(string).nextDouble();
    }

    private void onBerechnen()
    {
        final double laenge = setText(R.id.etlaenge);
        final double breite = setText(R.id.etbreite);

        Calc calc = new Calc(laenge,breite);
        final double flaeche = calc.getFlaeche();
        final double umfang = calc.getUmfang();
        final boolean istQuader = calc.isIstQuader();

        Intent intent = new Intent(this, Ergebnisse.class);
        intent.putExtra("flaeche",flaeche);
        intent.putExtra("umfang",flaeche);
        intent.putExtra("quader",istQuader);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
