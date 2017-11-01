package at.lukasfreyler.ue01.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import at.lukasfreyler.ue01.R;

public class Ergebnisse extends AppCompatActivity {

    private void setText(int rsid , String text)
            throws Exception
    {
        ((TextView) findViewById(rsid)).setText(text);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnisse);
        try
        {
            Intent intent = getIntent();
            final double volumen = intent.getDoubleExtra("volumen",0.0);
            setText(R.id.volumen, String.valueOf(volumen));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
