package Controlador;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import Datos.DataBaseHandler;
import Modelos.Jugador;

/**
 * Created by agude on 04/05/2016.
 */

public class AccesoDatos extends DataBaseHandler {

    // Constructor de la clase
    public AccesoDatos(Context context) {
        super(context);
    }

    // Metodo que almacena la información del Jugador
    public void registrarJugador(Jugador jugador)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues ctx = new ContentValues();
        ctx.put("email", jugador.email);
        ctx.put("name", jugador.nickname);
        ctx.put("password", jugador.password);
        db.insert("players",null,ctx);
        db.close();
    }

    public boolean login (String[] args)
    {
        String query = "Select * FROM  players "  + " WHERE email" + " ==  \"" + args[0] + "\"" + " AND password"  + " ==  \"" + args[1] + "\"";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        if(c.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
