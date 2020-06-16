package es.upv.etsit.att.atelemtrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        String nombre11 = getIntent().getStringExtra("nombre1");
        String nombre22 = getIntent().getStringExtra("nombre2");
        tv1.setText(nombre11);
        tv2.setText(nombre22);

    }
}
