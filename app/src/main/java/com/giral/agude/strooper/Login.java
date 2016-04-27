package com.giral.agude.strooper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Se instancia el boton creado en la vista, a nivel de la logica del programa
        Button btn_login = (Button) findViewById(R.id.btn_ingresar);

        //Se crea el evento del boton btn_login
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(v.getContext(), Index.class);
                startActivity(act2);
            }
        });
    }
}
