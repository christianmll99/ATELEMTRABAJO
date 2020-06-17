package es.upv.etsit.att.atelemtrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    protected static String nombrereal = " ";
    protected static String nombrereal2 = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);


        String nombre11 = getIntent().getStringExtra("nombre1");
        String nombre22 = getIntent().getStringExtra("nombre2");
         nombrereal = nombre11;
         nombrereal2 = nombre22;
        tv1.setText(nombre11);
        tv2.setText(nombre22);



    }




        public void Juego (View v){
            pistola P = new pistola();
            int contador = 1;
            int ronda = 1;
            do {
                if (contador % 2 != 0) { //contador impar,actualizamos ronda
                    tv3.setText(ronda);//mostramos ronda
                    ronda++; // para la proxima ronda
                }

                P.disparar();
                if (contador % 2 != 0) {
                    // enseñar por pantalla Jugador 1 sobrevive
                    tv4.setText(nombrereal + " sobrevive ");
                } else {
                    //print que jugador 2 sobrevive
                    tv5.setText(nombrereal2 + " sobrevive ");
                }
                contador++;


            } while (muere == false);//muere == false
            if (contador % 2 != 0) {
                // enseñar por pantalla Jugador 1 muere
                tv4.setText(nombrereal + " muere");
            } else {
                //print que jugador 2 muere
                tv5.setText(nombrereal2 + " muere");
            }

        }

    }




