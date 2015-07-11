package br.com.gdgtresrios.centrosulnegocios.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;

public class DatabaseConnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "centrosulnegocios";
    private static final Integer DATABASE_VERSION = 1;

    private final List<String> createTableList = new ArrayList<>();

    private final List<String> dropTables = new ArrayList<>();

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CategoriaEventoDao.CREATE_TABLE);
        db.execSQL(CategoriaColaboradorDao.CREATE_TABLE);
        db.execSQL(ColaboradorDao.CREATE_TABLE);
        db.execSQL(EventoDao.CREATE_TABLE);
        db.execSQL(ConfiguracaoDao.CREATE_TABLE);

        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Palestras')");
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Shows')");
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Workshops')");
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Estandes')");

        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Informática')");
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Bandas')");
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Comércio')");
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Turismo')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CategoriaEventoDao.DROP_TABLE);
        db.execSQL(CategoriaColaboradorDao.DROP_TABLE);
        db.execSQL(ColaboradorDao.DROP_TABLE);
        db.execSQL(EventoDao.DROP_TABLE);
        db.execSQL(ConfiguracaoDao.DROP_TABLE);
        onCreate(db);
    }
}
