package Controlador;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.giral.agude.strooper.Login;
import com.giral.agude.strooper.R;

/**
 * Created by agude on 02/05/2016.
 */
public class DialogoRegistro implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.registro_jugador, null);

        EditText nombre = (EditText) view.findViewById(R.id.edt_nombreRegistro);
        EditText email = (EditText) view.findViewById(R.id.edt_emailRegitro);
        EditText contraseña = (EditText) view.findViewById(R.id.edt_passwordRegistro);

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Registro");
        builder.setView(inflater.inflate(R.layout.registro_jugador, null));
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.create();
        builder.show();



    }
}
