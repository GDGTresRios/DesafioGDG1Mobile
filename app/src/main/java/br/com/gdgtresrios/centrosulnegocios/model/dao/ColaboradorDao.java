package br.com.gdgtresrios.centrosulnegocios.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;

public class ColaboradorDao {

    public static final String TABLE_NAME = "configuracao";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_DESCRICAO = "descricao";
    public static final String COLUMN_LOGO = "logo";
    public static final String COLUMN_DESCRICAO_DETALHADA = "descricao_detalhada";
    public static final String COLUMN_ENDERECO_VIRTUAL = "endereco_virtual";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_TELEFONE = "telefone";
    public static final String COLUMN_ENDERECO = "endereco";
    public static final String COLUMN_PATROCINADOR = "patrocinador";
    public static final String COLUMN_PALESTRANTE = "palestrante";
    public static final String COLUMN_EXPOSITOR = "expositor";
    public static final String COLUMN_FK_CATEGORIA_COLABORADOR = "fkcategoriacolaborador";

    private SQLiteDatabase database;

    public ColaboradorDao(SQLiteDatabase database) {
        this.database = database;
    }

    public List<Colaborador> listByCategoria(CategoriaColaborador categoriaColaborador) {
        List<Colaborador> colaboradorList = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_DESCRICAO, COLUMN_LOGO,
                        COLUMN_DESCRICAO_DETALHADA, COLUMN_ENDERECO_VIRTUAL, COLUMN_EMAIL, COLUMN_TELEFONE, COLUMN_ENDERECO,
                        COLUMN_PATROCINADOR, COLUMN_PALESTRANTE, COLUMN_EXPOSITOR, COLUMN_FK_CATEGORIA_COLABORADOR},
                        COLUMN_FK_CATEGORIA_COLABORADOR + " = ? ", new String[]{String.valueOf(categoriaColaborador.getId())},
                        null, null, null);

        while (cursor.moveToNext()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setId(cursor.getLong(0));
            colaborador.setNome(cursor.getString(1));
            colaborador.setDescricao(cursor.getString(2));
            colaborador.setLogo(cursor.getString(3));
            colaborador.setDescricaoDetalhada(cursor.getString(4));
            colaborador.setEnderecoVirtual(cursor.getString(5));
            colaborador.setEmail(cursor.getString(6));
            colaborador.setTelefone(cursor.getString(7));
            colaborador.setEndereco(cursor.getString(8));
            colaborador.setPatrocinador(cursor.getInt(9) > 0);
            colaborador.setPalestrante(cursor.getInt(10) > 0);
            colaborador.setExpositor(cursor.getInt(11) > 0);
            colaborador.setCategoria(new CategoriaColaboradorDao(database).findById(cursor.getLong(12)));

            colaboradorList.add(colaborador);
        }

        return colaboradorList;
    }

    public ArrayList<Colaborador> listByNome(String nome) {
        ArrayList<Colaborador> colaboradorList = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_DESCRICAO, COLUMN_LOGO,
                        COLUMN_DESCRICAO_DETALHADA, COLUMN_ENDERECO_VIRTUAL, COLUMN_EMAIL, COLUMN_TELEFONE, COLUMN_ENDERECO,
                        COLUMN_PATROCINADOR, COLUMN_PALESTRANTE, COLUMN_EXPOSITOR, COLUMN_FK_CATEGORIA_COLABORADOR},
                        COLUMN_NOME + " = ? ", new String[]{nome}, null, null, null);

        while (cursor.moveToNext()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setId(cursor.getLong(0));
            colaborador.setNome(cursor.getString(1));
            colaborador.setDescricao(cursor.getString(2));
            colaborador.setLogo(cursor.getString(3));
            colaborador.setDescricaoDetalhada(cursor.getString(4));
            colaborador.setEnderecoVirtual(cursor.getString(5));
            colaborador.setEmail(cursor.getString(6));
            colaborador.setTelefone(cursor.getString(7));
            colaborador.setEndereco(cursor.getString(8));
            colaborador.setPatrocinador(cursor.getInt(9) > 0);
            colaborador.setPalestrante(cursor.getInt(10) > 0);
            colaborador.setExpositor(cursor.getInt(11) > 0);
            colaborador.setCategoria(new CategoriaColaboradorDao(database).findById(cursor.getLong(12)));

            colaboradorList.add(colaborador);
        }

        return colaboradorList;
    }

    public Colaborador findById(Long id) {

        Cursor cursor = database.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_DESCRICAO, COLUMN_LOGO,
                        COLUMN_DESCRICAO_DETALHADA, COLUMN_ENDERECO_VIRTUAL, COLUMN_EMAIL, COLUMN_TELEFONE, COLUMN_ENDERECO,
                        COLUMN_PATROCINADOR, COLUMN_PALESTRANTE, COLUMN_EXPOSITOR, COLUMN_FK_CATEGORIA_COLABORADOR},
                COLUMN_ID + " = ? ", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor.moveToNext()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setId(cursor.getLong(0));
            colaborador.setNome(cursor.getString(1));
            colaborador.setDescricao(cursor.getString(2));
            colaborador.setLogo(cursor.getString(3));
            colaborador.setDescricaoDetalhada(cursor.getString(4));
            colaborador.setEnderecoVirtual(cursor.getString(5));
            colaborador.setEmail(cursor.getString(6));
            colaborador.setTelefone(cursor.getString(7));
            colaborador.setEndereco(cursor.getString(8));
            colaborador.setPatrocinador(cursor.getInt(9) > 0);
            colaborador.setPalestrante(cursor.getInt(10) > 0);
            colaborador.setExpositor(cursor.getInt(11) > 0);
            colaborador.setCategoria(new CategoriaColaboradorDao(database).findById(cursor.getLong(12)));

            return colaborador;
        }

        return null;
    }


}
