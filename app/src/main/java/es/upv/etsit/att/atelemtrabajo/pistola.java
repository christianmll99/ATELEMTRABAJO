package es.upv.etsit.att.atelemtrabajo;

public class pistola {
    private int posicionDisparo;
    private int posicionBala;

    public void revolver(){
        posicionBala = (int) Math.floor(Math.random()*6 + 1);
        posicionDisparo = (int) Math.floor(Math.random()*6 + 1);
    } //En este método es como si pusieramos las balas y eligieramos la posición del primer tiro

    public void actualizaBala() {
        if(posicionDisparo == 6){
            posicionDisparo = 1; //Volvemos a la posición 1 del revolver, sólo tiene 6 espacios para balas
        }
        else{
            posicionDisparo++;
        }
    }

    public boolean disparar() {
        boolean muere = false; //Creamos variable muere
        if(posicionBala == posicionDisparo) {
            muere = true; //El jugador muere
        }
        actualizaBala(); //Pasamos a la siguiente espacio de bala de la pistola
        return muere;
    }
}
