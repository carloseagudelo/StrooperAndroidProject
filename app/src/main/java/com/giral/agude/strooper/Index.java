package com.giral.agude.strooper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    //region Eveto del boton error, cuando se equiboca en la selecciòn
    public void error(View view) {
    }
    //endregion

    //region Evento del boton correcto, cuando hace bien la selecciòn
    public void correcto(View view) {
    }
    //endregion
}
