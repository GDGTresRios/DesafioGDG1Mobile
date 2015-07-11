package br.com.gdgtresrios.centrosulnegocios.model.dao;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;
import br.com.gdgtresrios.centrosulnegocios.model.Evento;

public class EventoDao {

    public static final String TABLE_NAME = "evento";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_DESCRICAO = "descricao";
    public static final String COLUMN_DESCRICAO_DETALHADA = "descricao_detalhada";
    public static final String COLUMN_DATA_HORA = "data_hora";
    public static final String COLUMN_DURACAO = "duracao";
    public static final String COLUMN_LOCAL = "local";
    public static final String COLUMN_FK_CATEGORIA_EVENTO = "fkcategoriaevento";
    public static final String COLUMN_FK_COLABORADOR = "fkcolaborador";

    public static final String DROP_TABLE =   "DROP TABLE IF EXISTS " + TABLE_NAME + ";\n";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                                                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                                                    COLUMN_NOME + " TEXT NOT NULL, \n" +
                                                    COLUMN_DESCRICAO + " TEXT , \n" +
                                                    COLUMN_DESCRICAO_DETALHADA + " TEXT , \n" +
                                                    COLUMN_DATA_HORA + " INTEGER NOT NULL, \n" +
                                                    COLUMN_DURACAO + " INTEGER , \n" +
                                                    COLUMN_LOCAL + " TEXT , \n" +
                                                    COLUMN_FK_CATEGORIA_EVENTO + " INTEGER NOT NULL, \n" +
                                                    COLUMN_FK_COLABORADOR + " INTEGER NOT NULL, \n" +
                                                    "FOREIGN KEY(" + COLUMN_FK_CATEGORIA_EVENTO + ") REFERENCES "
                                                    + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_ID + "), \n" +
                                                    "FOREIGN KEY(" + COLUMN_FK_COLABORADOR + ") REFERENCES "
                                                    + ColaboradorDao.TABLE_NAME + "("+ColaboradorDao.COLUMN_ID +") \n" +
                                                ");\n";

    private SQLiteDatabase database;

    public EventoDao(SQLiteDatabase database) {
        this.database = database;
    }


    public Boolean insert(Evento evento) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, evento.getId());
        contentValues.put(COLUMN_NOME, evento.getNome());
        contentValues.put(COLUMN_DESCRICAO, evento.getDescricao());
        contentValues.put(COLUMN_DESCRICAO_DETALHADA, evento.getDescricaoDetalhada());
        contentValues.put(COLUMN_DATA_HORA, evento.getDataHora().getTime());
        contentValues.put(COLUMN_DURACAO, evento.getDuracao().getTime());
        contentValues.put(COLUMN_LOCAL, evento.getLocal());
        contentValues.put(COLUMN_FK_CATEGORIA_EVENTO, evento.getCategoriaEvento().getId());
        contentValues.put(COLUMN_FK_COLABORADOR, evento.getColaborador().getId());

        long rowId = database.insert(TABLE_NAME, null, contentValues);

        if(rowId != -1 ) {
            return true;
        }

        return false;
    }

    public List<Evento> listByCategoria(CategoriaEvento categoriaEvento) {
        List<Evento> eventoList = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_DESCRICAO,
                COLUMN_DESCRICAO_DETALHADA, COLUMN_DATA_HORA, COLUMN_DURACAO, COLUMN_LOCAL,
                COLUMN_FK_CATEGORIA_EVENTO, COLUMN_FK_COLABORADOR}, COLUMN_FK_CATEGORIA_EVENTO + " = ? ",
                new String[]{String.valueOf(categoriaEvento.getId())}, null, null, null);

        while(cursor.moveToNext()) {
            Evento evento = new Evento();
            evento.setId(cursor.getLong(0));
            evento.setNome(cursor.getString(1));
            evento.setDescricao(cursor.getString(2));
            evento.setDescricaoDetalhada(cursor.getString(3));
            evento.setDataHora(new Date(cursor.getLong(4)));
            evento.setDuracao(new Date(cursor.getLong(5)));
            evento.setLocal(cursor.getString(6));
            evento.setCategoriaEvento(new CategoriaEventoDao(database).findById(cursor.getLong(7)));
            evento.setColaborador(new ColaboradorDao(database).findById(cursor.getLong(8)));

            eventoList.add(evento);
        }

        cursor.close();

        return eventoList;
    }

    public List<Evento> listByNome(String nome) {
        List<Evento> eventoList = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_DESCRICAO,
                COLUMN_DESCRICAO_DETALHADA, COLUMN_DATA_HORA, COLUMN_DURACAO, COLUMN_LOCAL,
                COLUMN_FK_CATEGORIA_EVENTO, COLUMN_FK_COLABORADOR}, COLUMN_NOME + " = ? ",
                new String[]{nome}, null, null, null);

        while(cursor.moveToNext()) {
            Evento evento = new Evento();
            evento.setId(cursor.getLong(0));
            evento.setNome(cursor.getString(1));
            evento.setDescricao(cursor.getString(2));
            evento.setDescricaoDetalhada(cursor.getString(3));
            evento.setDataHora(new Date(cursor.getLong(4)));
            evento.setDuracao(new Date(cursor.getLong(5)));
            evento.setLocal(cursor.getString(6));
            evento.setCategoriaEvento(new CategoriaEventoDao(database).findById(cursor.getLong(7)));
            evento.setColaborador(new ColaboradorDao(database).findById(cursor.getLong(8)));

            eventoList.add(evento);
        }

        cursor.close();

        return eventoList;
    }

    public List<Evento> listNext(int number) {
        List<Evento> eventoList = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_DESCRICAO,
                COLUMN_DESCRICAO_DETALHADA, COLUMN_DATA_HORA, COLUMN_DURACAO, COLUMN_LOCAL,
                COLUMN_FK_CATEGORIA_EVENTO, COLUMN_FK_COLABORADOR}, COLUMN_DATA_HORA + " > ? ", null,
                null, null, COLUMN_DATA_HORA + " ASC ");

        for(int i = 0; i < number; i++) {
            if(cursor.moveToNext()) {
                Evento evento = new Evento();
                evento.setId(cursor.getLong(0));
                evento.setNome(cursor.getString(1));
                evento.setDescricao(cursor.getString(2));
                evento.setDescricaoDetalhada(cursor.getString(3));
                evento.setDataHora(new Date(cursor.getLong(4)));
                evento.setDuracao(new Date(cursor.getLong(5)));
                evento.setLocal(cursor.getString(6));
                evento.setCategoriaEvento(new CategoriaEventoDao(database).findById(cursor.getLong(7)));
                evento.setColaborador(new ColaboradorDao(database).findById(cursor.getLong(8)));

                eventoList.add(evento);
            }

            cursor.close();

            return eventoList;
        }

        cursor.close();

        return eventoList;
    }

}
