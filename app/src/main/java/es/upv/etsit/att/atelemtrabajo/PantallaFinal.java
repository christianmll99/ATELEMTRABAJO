package es.upv.etsit.att.atelemtrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PantallaFinal extends AppCompatActivity {
    private EditText nombrefin1;
    private EditText nombrefin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        String nombrefin1 = getIntent().getStringExtra("nombre11");
        String nombrefin2 = getIntent().getStringExtra("nombre22");

    }


    public void reinicio(View view) {
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }

    public void reinicioconnombres(View view) {
        Intent siguiente = new Intent(this, Pantalla1.class);
        siguiente.putExtra("nombre11", nombrefin1.getText().toString());
        siguiente.putExtra("nombre22", nombrefin2.getText().toString());
        startActivity(siguiente);
    }
}
