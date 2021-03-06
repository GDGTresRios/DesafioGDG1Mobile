package br.com.gdgtresrios.centrosulnegocios.model.dao;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;

public class CategoriaEventoDao {

    public static final String TABLE_NAME = "categoria_evento";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";

    public static final String DROP_TABLE =   "DROP TABLE IF EXISTS " + TABLE_NAME + ";\n";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                                                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                                                    COLUMN_NOME + " TEXT NOT NULL \n" +
                                                ");\n";

    private SQLiteDatabase database;

    public CategoriaEventoDao(SQLiteDatabase database) {
        this.database = database;
    }

    public Boolean insert(CategoriaEvento categoriaEvento) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, categoriaEvento.getId());
        contentValues.put(COLUMN_NOME, categoriaEvento.getNome());

        long rowId = database.insert(TABLE_NAME, null, contentValues);

        if(rowId != -1 ) {
            return true;
        }

        return false;
    }

    public List<CategoriaEvento> listAll() {
        List<CategoriaEvento> categoriaEventoList = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME}, null, null, null, null, null);

        while(cursor.moveToNext()) {
            CategoriaEvento categoriaEvento = new CategoriaEvento();
            categoriaEvento.setId(cursor.getLong(0));
            categoriaEvento.setNome(cursor.getString(1));

            categoriaEventoList.add(categoriaEvento);
        }

        cursor.close();

        return categoriaEventoList;
    }

    public CategoriaEvento findById(Long id) {
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME}, COLUMN_ID + " = ? ",
                new String[]{String.valueOf(id)}, null, null, null);

        if(cursor.moveToNext()) {
            CategoriaEvento categoriaEvento = new CategoriaEvento();
            categoriaEvento.setId(cursor.getLong(0));
            categoriaEvento.setNome(cursor.getString(1));

            cursor.close();

            return categoriaEvento;
        }

        cursor.close();

        return null;
    }
}
