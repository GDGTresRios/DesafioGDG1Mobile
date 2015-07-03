package br.com.gdgtresrios.centrosulnegocios.model.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.gdgtresrios.centrosulnegocios.model.Configuracao;

public class ConfiguracaoDao {

    public static final String TABLE_NAME = "configuracao";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_DESCRICAO = "descricao";
    public static final String COLUMN_LOGO = "logo";
    public static final String COLUMN_ENDERECO = "endereco";
    public static final String COLUMN_MAPA = "mapa";
    public static final String COLUMN_TELEFONE = "telefone";
    public static final String COLUMN_VERSAO = "versao";

    private SQLiteDatabase database;


    public ConfiguracaoDao(SQLiteDatabase database) {
        this.database = database;
    }


    public Boolean insert(Configuracao configuracao) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, configuracao.getId());
        contentValues.put(COLUMN_NOME, configuracao.getNome());
        contentValues.put(COLUMN_DESCRICAO, configuracao.getDescricao());
        contentValues.put(COLUMN_LOGO, configuracao.getLogo());
        contentValues.put(COLUMN_ENDERECO, configuracao.getEndereco());
        contentValues.put(COLUMN_MAPA, configuracao.getMapa());
        contentValues.put(COLUMN_TELEFONE, configuracao.getTelefone());
        contentValues.put(COLUMN_VERSAO, configuracao.getVersao());

        long rowId = database.insert(TABLE_NAME, null, contentValues);

        if(rowId != -1 ) {
            return true;
        }

        return false;
    }

    public Configuracao getLastOne() {
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_DESCRICAO, COLUMN_LOGO,
                COLUMN_ENDERECO, COLUMN_MAPA, COLUMN_TELEFONE, COLUMN_VERSAO}, null, null, null, null, COLUMN_VERSAO + " DESC ");

        if(cursor.moveToNext()) {
            Configuracao configuracao = new Configuracao();
            configuracao.setId(cursor.getLong(0));
            configuracao.setNome(cursor.getString(1));
            configuracao.setDescricao(cursor.getString(2));
            configuracao.setLogo(cursor.getString(3));
            configuracao.setEndereco(cursor.getString(4));
            configuracao.setMapa(cursor.getString(5));
            configuracao.setTelefone(cursor.getString(6));
            configuracao.setVersao(cursor.getString(7));

            return configuracao;
        }

        return null;
    }

}
