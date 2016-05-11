package Datos;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by agude on 29/04/2016.
 */
public class DataBaseHandler extends SQLiteOpenHelper
{
    //region Version de la base de datos
    private static final int DATABASE_VERSION = 2;
    //endregion

    //region Nombre de la base de datos
    private static final String DATABASE_NAME = "Stroopper";
    //endregion

    //region Nombre de las tablas en la base de datos
    private static final String TABLE_PLAYERS = "players";
    //endregion

    //region Columnas de las tablas
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    //endregion

    //region Constructor de la clase
    public DataBaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //endregion

    //region Evento Oncreate donde se creara la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) // Metodo que crea la(s) tabla(s) en la base de datos
    {
        String CREATE_CONTACTS_TABLE =
                "CREATE TABLE " + TABLE_PLAYERS
                + "("
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PASSWORD + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    //endregion

    //region Evento del onUpdate donde se actualiza la versión de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) // Metodo que actualiza la(s) tabla(s) en la base de datos
    {
        // Elimina la tabla si existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        // Crea la nueva version nuevamente
        onCreate(db);
    }
    //endregion
}
