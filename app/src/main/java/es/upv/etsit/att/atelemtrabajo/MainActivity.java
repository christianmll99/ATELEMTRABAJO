package es.upv.etsit.att.atelemtrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText nombre1;
private EditText nombre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre1 = (EditText)findViewById(R.id.nombre1);
        nombre2 = (EditText)findViewById(R.id.nombre2);




    }



public void pasar(View view){
        Intent siguiente = new Intent(this,Pantalla1.class);
        siguiente.putExtra("nombre1" , nombre1.getText().toString());
        siguiente.putExtra("nombre2" , nombre2.getText().toString());
        startActivity(siguiente);

}

}
