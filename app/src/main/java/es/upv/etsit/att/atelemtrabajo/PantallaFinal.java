package es.upv.etsit.att.atelemtrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PantallaFinal extends AppCompatActivity {
    private String nombrefin1;
    private String nombrefin2;
    private ImageView imagen;
    private int contador;
    private TextView tv8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        tv8 = (TextView) findViewById(R.id.tv1);
        nombrefin1 = getIntent().getStringExtra("nombre11");
        nombrefin2 = getIntent().getStringExtra("nombre22");
        contador = getIntent().getIntExtra("contador");
        imagen = (ImageView) findViewById(R.id.image4);
        seleccionimagen(null);


//Meter un if para mostrar con un textview el ganador y la imagen del jugador
    }
    public void seleccionimagen(View v){

        if(contador % 2 == 0){
            imagen.setImageResource(R.drawable.vaqueros1rec);
            tv8.setText("El ganador ha sido"+ nombrefin1);
            //TextView diciendo que ha ganado el primero
        }else
            imagen.setImageResource(R.drawable.vaqueros2rec);
            tv8.setText("El ganador ha sido"+ nombrefin2);


    }

    public void reinicio(View view) {
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }

    public void reinicioconnombres(View view) {
        Intent siguiente = new Intent(this, Pantalla1.class);
        siguiente.putExtra("nombre1", nombrefin1);
        siguiente.putExtra("nombre2", nombrefin2);
        startActivity(siguiente);
    }

}