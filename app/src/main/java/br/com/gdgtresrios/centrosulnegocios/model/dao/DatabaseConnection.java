package br.com.gdgtresrios.centrosulnegocios.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "centrosulnegocios";
    private static final Integer DATABASE_VERSION = 1;

    private final String createTables =
            "CREATE TABLE " + CategoriaEventoDao.TABLE_NAME + " (\n" +
                CategoriaEventoDao.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                CategoriaEventoDao.COLUMN_NOME + " TEXT NOT NULL \n" +
            ");\n" +
            "CREATE TABLE " + CategoriaColaboradorDao.TABLE_NAME + " (\n" +
                CategoriaColaboradorDao.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                CategoriaColaboradorDao.COLUMN_NOME + " TEXT NOT NULL, \n" +
                CategoriaColaboradorDao.COLUMN_LOGO + " TEXT \n" +
            ");\n" +
            "CREATE TABLE " + EventoDao.TABLE_NAME + " (\n" +
                EventoDao.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                EventoDao.COLUMN_NOME + " TEXT NOT NULL, \n" +
                EventoDao.COLUMN_DESCRICAO + " TEXT , \n" +
                EventoDao.COLUMN_DESCRICAO_DETALHADA + " TEXT , \n" +
                EventoDao.COLUMN_DATA_HORA + " INTEGER NOT NULL, \n" +
                EventoDao.COLUMN_DURACAO + " INTEGER , \n" +
                EventoDao.COLUMN_LOCAL + " TEXT , \n" +
                EventoDao.COLUMN_FK_CATEGORIA_EVENTO + " INTEGER NOT NULL, \n" +
                EventoDao.COLUMN_FK_COLABORADOR + " INTEGER NOT NULL \n" +
            ");\n" +
            "CREATE TABLE " + ConfiguracaoDao.TABLE_NAME + " (\n" +
                ConfiguracaoDao.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                ConfiguracaoDao.COLUMN_NOME + " TEXT NOT NULL, \n" +
                ConfiguracaoDao.COLUMN_DESCRICAO + " TEXT , \n" +
                ConfiguracaoDao.COLUMN_LOGO + " TEXT , \n" +
                ConfiguracaoDao.COLUMN_ENDERECO + " TEXT , \n" +
                ConfiguracaoDao.COLUMN_MAPA + " TEXT , \n" +
                ConfiguracaoDao.COLUMN_TELEFONE + " TEXT , \n" +
                ConfiguracaoDao.COLUMN_VERSAO + " TEXT  \n" +
            ");\n";

    private final String dropTables =
            "DROP TABLE " + CategoriaEventoDao.TABLE_NAME + ";\n" +
            "DROP TABLE " + CategoriaEventoDao.TABLE_NAME + ";\n";

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTables);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropTables);
    }
}
