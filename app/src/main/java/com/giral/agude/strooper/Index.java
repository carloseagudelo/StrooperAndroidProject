package com.giral.agude.strooper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Index extends AppCompatActivity {

    //region Variables globales
    Chronometer mChronometer;
    Integer vidas = 1;
    TextView segundos, nombreJugador, colorLetra;
    LinearLayout componente;
    CountDownTimer cuenta;
    int seg, contador, posicionColorNombre, posicionColorValor;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //region Inicializando los componentes
        segundos = (TextView) findViewById(R.id.segundos);
        colorLetra  = (TextView) findViewById(R.id.letrasColor);
        nombreJugador = (TextView) findViewById(R.id.nombre_jugador);
        componente = (LinearLayout) findViewById(R.id.lyt_cuatro);
        segundos.setText("3");
        colorLetra.setText("INICIAR JUEGO");
        //endregion

        //region Recibe lo que se manda el formulario anterior
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        String j =(String) b.get("name");
        nombreJugador.setText(j);
        //endregion
    }

    String[] nombreColor = new String[]{"Verde", "Azul", "Naranja", "Rojo"};
    int[] Color = new int[]{ R.color.Verde, R.color.Azul, R.color.Naranja, R.color.Rojo};

    //region Metodo que inicializa un contador de 3 segundos
    public void iniciarCuentaAtras(){
        seg = 0;
        contador = 3;

        obtenerNombreColor();
        obtenerValorColor();

        colorLetra.setText(nombreColor[posicionColorNombre]);
        componente.setBackgroundColor( getResources().getColor(Color[posicionColorValor]));

        cuenta = new CountDownTimer(5*1000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                segundos.setText("" + contador--);
            }
            @Override
            public void onFinish()
            {
                if (vidas > 0)
                {
                    iniciarCuentaAtras();
                    vidas--;
                    contador = 3;
                }
                else
                {
                    // Aca iria el mensaje de perdio
                    cuenta.cancel();
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
        String  drawable = getResources().getResourceName(Color[posicionColorValor]);
        String valor = drawable.toString().split("/")[1];
        if(!valor.equals(nombreColor[posicionColorNombre]))
        {
            vidas++;
            iniciarCuentaAtras();
        }
        else
        {
            vidas--;
        }
    }
    //endregion

    //region Evento del boton bien hecho
    public void btn_bien(View view) {
        String  drawable = getResources().getResourceName(Color[posicionColorValor]);
        String valor = drawable.toString().split("/")[1];
        if(valor.equals(nombreColor[posicionColorNombre]))
        {
            vidas++;
            iniciarCuentaAtras();
        }
        else
        {
            vidas--;
        }

    }
    //endregion

    //region Metodo que selecciona el nombre del color de un array de nombre de colores
    public void obtenerNombreColor()
    {
        Random generator = new Random();
        posicionColorNombre =  generator.nextInt(nombreColor.length);
    }
    //endregion

    //region Metodo que selecciona el Id de un color de un array de Ids de colores
    public void obtenerValorColor()
    {
        Random generator = new Random();
        posicionColorValor = generator.nextInt(Color.length);
    }
    //endregion
}
