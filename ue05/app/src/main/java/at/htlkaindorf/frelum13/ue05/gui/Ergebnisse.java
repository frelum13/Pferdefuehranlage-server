package at.htlkaindorf.frelum13.ue05.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import at.htlkaindorf.frelum13.ue05.R;

public class Ergebnisse extends AppCompatActivity {

    private void setText(int rsid, String data)
    {
        TextView view = (TextView) findViewById(rsid);
        view.setText(data);
    }

    private void setVisible(int rsid, boolean abfrage)
    {
        if(abfrage == true)
            findViewById(rsid).setVisibility(View.VISIBLE);
        else
            findViewById(rsid).setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnisse);
        try
        {
            Intent intnet = getIntent();
            final double flaeche = intnet.getDoubleExtra("flaeche",0.0);
            final double volumen = intnet.getDoubleExtra("volumen", 0.0);
            final boolean istQuadrat = intnet.getBooleanExtra("quader",false);

            setText(R.id.tvflaeche, String.valueOf(flaeche));
            setText(R.id.tvvolumen, String.valueOf(volumen));
            setVisible(R.id.tvquadrat, istQuadrat);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        }
    }

