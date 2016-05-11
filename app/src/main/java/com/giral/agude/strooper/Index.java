package com.giral.agude.strooper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Index extends AppCompatActivity {

    //region Variables globales
    Chronometer mChronometer;
    Integer vidas = 3;
    TextView segundos, nombreJugador, colorLetra;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //region Inicializando los componentes
        segundos = (TextView) findViewById(R.id.segundos);
        colorLetra  = (TextView) findViewById(R.id.letrasColor);
        nombreJugador = (TextView) findViewById(R.id.nombre_jugador);
        segundos.setText("5");
        colorLetra.setText("INICIAR JUEGO");
        //endregion

        //region Recibe lo que se manda el formulario anterior
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        String j =(String) b.get("name");
        nombreJugador.setText(j);
        //endregion
    }

    //region Metodo que inicializa un contador de 3 segundos
    CountDownTimer cuenta;
    int seg = 4;
    public void iniciarCuentaAtras(){
        cuenta = new CountDownTimer(5 * 1000, 1000)
        {
            public void onTick(long milisegundos)
            {
                seg = (int) (milisegundos / 1000);
                segundos.setText("" + (seg - 1));
            }
            public void onFinish()
            {
                if (vidas > 0)
                {
                    iniciarCuentaAtras();
                    vidas--;
                }
            }
        };
        cuenta.start();
    }
    //endregion

    //region Evento del textView para iniciar el juego
    public void iniciarJuego(View view)
    {
        if(colorLetra.getText().toString().equalsIgnoreCase("INICIAR JUEGO"))
        {
            iniciarCuentaAtras();
        }
    }
    //endregion

    //region Evento del boton mala decision
    public void btn_mal(View view) {

    }
    //endregion

    //region Evento del boton bien hecho
    public void btn_bien(View view) {

    }
    //endregion
}
