package com.giral.agude.strooper;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import Controlador.DialogoRegistro;

public class Login extends AppCompatActivity {
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Se instancia el boton creado en la vista, a nivel de la logica del programa
        Button btn_login = (Button) findViewById(R.id.btn_ingresar);
         email = (EditText) findViewById(R.id.edt_email);
          password = (EditText) findViewById(R.id.edt_password);


        //Se crea el evento del boton btn_login
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if((email.getText().toString() != "") && (password.getText().toString() != "") )
                {
                    if((email.getText().toString().equals("leidy@gmail.com")) && (password.getText().toString().equals("leidy123")))
                    {
                        Toast.makeText(Login.this,"Bienvenida" + "leidy@gmail.com" + "eres  muy bonita y feita",Toast.LENGTH_SHORT).show();
                        Intent act2 = new Intent(v.getContext(), Index.class);
                        act2.putExtra("email",email.getText().toString());
                        startActivity(act2);
                        finish();
                    }
                    else
                    {
                        new AlertDialog.Builder(Login.this)
                                .setTitle("Error")
                                .setMessage("Ha ingresado datos incorrectos" + "/n" + "¿Desea intentar nuevamente ?" )
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // do nothing
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                }
                else if(email.getText().toString() == "")
                {
                    Toast toast = Toast.makeText(Login.this, "No se permite este campo vacio : ingrese email",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (password.getText().toString() == null)
                {
                    Toast toast = Toast.makeText(Login.this, "No se permite este campo vacio : ingrese su contraseña",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }


    public void registrar(View view) {
        DialogoRegistro dlg = new DialogoRegistro();
        dlg.onClick(view);
    }
}
