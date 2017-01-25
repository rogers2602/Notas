package br.com.devmarques.bltnotas.notas.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Roger on 09/01/2017.
 */

public class BancoDados extends SQLiteOpenHelper {

    private static final String NOTASBLR = "Notas";
    private static final int VERSAOBANCO = 1;
    private static final String TABLENOTAS = "CREATE TABLE Notas (id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "nomemateria TEXT, qtdnotas TEXT , nota1 REAL,peso1 REAL,nota2 REAL,peso2 REAL,nota3 REAL,peso3 REAL,nota4 REAL, peso4 REAL, maxima Real, media REAL, resultado REAL);";

    public BancoDados(Context context) {
        super(context, NOTASBLR, null, VERSAOBANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLENOTAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Notas;");

    }
}
