package es.upv.etsit.att.atelemtrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.IpSecManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private ImageView imagen;
    protected static String nombrereal = " ";
    protected static String nombrereal2 = " ";
    boolean muere = false;
    int contador = 1;
    int ronda = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        imagen = (ImageView) findViewById(R.id.imagenxml);


        String nombre11 = getIntent().getStringExtra("nombre1");
        String nombre22 = getIntent().getStringExtra("nombre2");
        nombrereal = nombre11;
        nombrereal2 = nombre22;
        tv1.setText(nombre11);
        tv2.setText(nombre22);


    }
    public void saltopantallafinal(View view){
        Intent siguiente = new Intent(Pantalla1.this, PantallaFinal.class);
        siguiente.putExtra("nombre11", nombrereal);
        siguiente.putExtra("nombre22", nombrereal2);
        startActivity(siguiente);



    }


    public class Pistola {
        private int posicionDisparo;
        private int posicionBala;

        Pistola() {
            posicionBala = (int) Math.floor(Math.random() * 6 + 1);
            posicionDisparo = (int) Math.floor(Math.random() * 6 + 1);
        } //En este método es como si pusieramos las balas y eligieramos la posición del primer tiro

        public void actualizaBala() {
            if (posicionDisparo == 6) {
                posicionDisparo = 1; //Volvemos a la posición 1 del revolver, sólo tiene 6 espacios para balas
            } else {
                posicionDisparo++;
            }
        }

        public boolean disparar() {
            //Creamos variable muere
            if (posicionBala == posicionDisparo) {
                muere = true; //El jugador muere
            }
            actualizaBala(); //Pasamos a la siguiente espacio de bala de la pistola
            return muere;
        }
    }  // classs Pistola1


    public void Juego(View v) {
        final Pistola P = new Pistola();


        final Handler handler2 = new Handler();

        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv4.setText(nombrereal);
                tv5.setText(nombrereal2);

                if (contador % 2 != 0) { //contador impar,actualizamos ronda
                    tv3.setText(" Ronda : " + ronda);//mostramos ronda
                    ronda++; // para la proxima ronda
                }

                P.disparar();
                if (contador % 2 != 0) {
                    // enseñar por pantalla Jugador 1 sobrevive
                    if (!muere) {
                        tv4.setText(nombrereal + " sobrevive ");
                    } else  {
                        tv4.setText(nombrereal + " muere");
                    }
                } else {
                    //print que jugador 2 sobrevive
                    if (!muere) {
                        tv5.setText(nombrereal2 + " sobrevive ");
                    }else  {
                        tv5.setText(nombrereal2 + " muere");
                    }
                }
                contador++;

                if (!muere) {
                    handler2.postDelayed(this, 3000);
                } else  {
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            saltopantallafinal(null);
                        }
                    }, 3000);
                } // else


            } // run
        },100);


    } // Juego

}  // Pantalla1.class
