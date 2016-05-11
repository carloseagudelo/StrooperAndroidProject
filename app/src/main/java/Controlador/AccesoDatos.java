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
 * Created by Carlos Enrique Agudelo on 04/05/2016.
 */

public class AccesoDatos extends DataBaseHandler {

    //region Constructor de la clase
    public AccesoDatos(Context context)
    {
        super(context);
    }
    //endregion

    //region Metodo que almacena la información del Jugador
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
    //endregion

    //region Metodo para realizar el login de la aplicación
    public String login (String[] args)
    {
        String query = "Select name FROM  players "  + " WHERE email" + " ==  \"" + args[0] + "\"" + " AND password"  + " ==  \"" + args[1] + "\"";

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        if(c.moveToFirst())
        {
            return c.getString(c.getColumnIndex("name"));
        }
        else
        {
            return "";
        }
    }
    //endregion
}
