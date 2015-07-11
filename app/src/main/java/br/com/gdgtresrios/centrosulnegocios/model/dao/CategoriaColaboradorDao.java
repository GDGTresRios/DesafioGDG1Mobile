package br.com.gdgtresrios.centrosulnegocios.model.dao;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;

public class CategoriaColaboradorDao {

    public static final String TABLE_NAME = "categoria_colaborador";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_LOGO = "logo";

    private SQLiteDatabase database;

    public CategoriaColaboradorDao(SQLiteDatabase database) {
        this.database = database;
    }

    public Boolean insert(CategoriaColaborador categoriaColaborador) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, categoriaColaborador.getId());
        contentValues.put(COLUMN_NOME, categoriaColaborador.getNome());
        contentValues.put(COLUMN_LOGO, categoriaColaborador.getLogo());

        long rowId = database.insert(TABLE_NAME, null, contentValues);

        if(rowId != -1 ) {
            return true;
        }

        return false;
    }

    public List<CategoriaColaborador> listAll() {
        List<CategoriaColaborador> categoriaColaboradorList = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME}, null, null, null, null, null);

        while(cursor.moveToNext()) {
            CategoriaColaborador categoriaColaborador = new CategoriaColaborador();
            categoriaColaborador.setId(cursor.getLong(0));
            categoriaColaborador.setNome(cursor.getString(1));

            categoriaColaboradorList.add(categoriaColaborador);
        }

        cursor.close();

        return categoriaColaboradorList;
    }

    public CategoriaColaborador findById(Long id) {
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME}, COLUMN_ID + " = ? ",
                new String[]{String.valueOf(id)}, null, null, null);

        if(cursor.moveToNext()) {
            CategoriaColaborador categoriaColaborador = new CategoriaColaborador();
            categoriaColaborador.setId(cursor.getLong(0));
            categoriaColaborador.setNome(cursor.getString(1));

            cursor.close();

            return categoriaColaborador;
        }

        cursor.close();

        return null;
    }

}
