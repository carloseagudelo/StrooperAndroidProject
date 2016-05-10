package com.giral.agude.strooper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Index extends AppCompatActivity {

    Chronometer mChronometer;
    Integer vidas = 3;
    TextView segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //region Inicializando los componentes
        segundos = (TextView) findViewById(R.id.segundos);
        TextView colorLetra = (TextView) findViewById(R.id.letrasColor);
        //endregion
        segundos.setText("3");
        new AlertDialog.Builder(Index.this)
                .setTitle("Empezar")
                .setMessage("El juego consta de 3 segundos para confirmar o desconfirmar lo mostrado, cuenta con tres vidas" )
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        InicializarCronometro();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    //region Metodo que inicializa un contador de 3 segundos
    private void InicializarCronometro()
    {
        int contador = 30000;
        while(contador > 0)
        {
            segundos.setText(Integer.toString(contador));
            contador = contador - 1;
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
