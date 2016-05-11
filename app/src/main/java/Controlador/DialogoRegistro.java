package Controlador;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.giral.agude.strooper.Login;
import com.giral.agude.strooper.R;

import Modelos.Jugador;

/**
 * Created by agude on 02/05/2016.
 */
public class DialogoRegistro implements View.OnClickListener {

    //region Variables globales
    View view;
    EditText nombre, email, contraseña;
    Button btnRegistrar, btnCancelar;
    //endregion

    @Override
    public void onClick(View v) {

        LayoutInflater inflater = (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.registro_jugador, null);

        //region Inicialización de componentes
        nombre = (EditText) view.findViewById(R.id.edt_nombreRegistro);
        email = (EditText) view.findViewById(R.id.edt_emailRegitro);
        contraseña = (EditText) view.findViewById(R.id.edt_passwordRegistro);
        btnRegistrar = (Button) view.findViewById(R.id.btn_registarJugador);
        btnCancelar = (Button) view.findViewById(R.id.btn_cancelar);
        // endregion

        //region Configuracion de la pantalla en forma de popup
        final Dialog builder = new Dialog(view.getContext());
        builder.setContentView(view);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(builder.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        builder.getWindow().setAttributes(lp);
        builder.show();
        //endregion

        //region Evento del boton registar jugador
        btnRegistrar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AccesoDatos db = new AccesoDatos(v.getContext());
                Jugador jugador = new Jugador();
                jugador.nickname = nombre.getText().toString();
                jugador.email = email.getText().toString();
                jugador.password = contraseña.getText().toString();
                try
                {
                    db.registrarJugador(jugador);
                    Log.v(null, "guardo");
                }
                catch (Exception ex)
                {
                    Log.v(null, "No se pudo almacenar" + ex);
                }
                builder.cancel();
            }
        });
        //endregion

        //region Evento del boton cancelar
        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                builder.cancel();
            }
        });
        //endregion
    }
}
