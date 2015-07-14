package br.com.gdgtresrios.centrosultnegocios.controller.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;
import br.com.gdgtresrios.centrosulnegocios.model.dao.ColaboradorDao;
import br.com.gdgtresrios.centrosulnegocios.model.dao.DatabaseConnection;
import br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter.ColaboradorAdapter;

public class BuscaColaboradorActivity extends AppCompatActivity {

    private static final String INTENT_KEY_CATEGORIACOLABORADOR = "intent_key_categoriacolaborador";
    private static final String INTENT_KEY_NOME = "intent_key_nome";
    private final String BUNDLE_KEY_COLABORADOR = "bundle_key_colaborador";

    private ListView listViewColaborador;
    private List<Colaborador> colaboradorList;
    private CategoriaColaborador categoriaColaborador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscacolaborador);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        categoriaColaborador = getIntent().getParcelableExtra(INTENT_KEY_CATEGORIACOLABORADOR);
        String nome = getIntent().getStringExtra(INTENT_KEY_NOME);
        if (categoriaColaborador == null){
            getSupportActionBar().setSubtitle(getString(R.string.buscaorganizacaoactivity_substitle_todos));
        } else {
            getSupportActionBar().setSubtitle(categoriaColaborador.getNome());
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null){
            colaboradorList = listColaboradorFromDatabase(categoriaColaborador, nome);
        } else{
            Colaborador[] categoriaColaboradorArray = (Colaborador[]) savedInstanceState.getParcelableArray(BUNDLE_KEY_COLABORADOR);
            if (categoriaColaboradorArray != null) {
                colaboradorList = Arrays.asList(categoriaColaboradorArray);
            } else {
                colaboradorList = listColaboradorFromDatabase(categoriaColaborador, nome);
            }
        }

        listViewColaborador = (ListView) findViewById(R.id.listview_colaborador);
        listViewColaborador.setAdapter(new ColaboradorAdapter(colaboradorList, this));
        listViewColaborador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Colaborador colaborador = (Colaborador) parent.getAdapter().getItem(position);
                startActivity(VisualizarColaborador.newIntent(BuscaColaboradorActivity.this, colaborador));
            }
        });
    }

    private List<Colaborador> listColaboradorFromDatabase(@Nullable CategoriaColaborador categoriaColaborador, @Nullable String nome) {
        SQLiteDatabase databaseConnection = new DatabaseConnection(this).getWritableDatabase();
        ColaboradorDao colaboradorDao = new ColaboradorDao(databaseConnection);
        List<Colaborador> colaboradorList;
        if(categoriaColaborador == null) {
            if(nome == null) {
                colaboradorList = colaboradorDao.listAll();
            } else {
                colaboradorList = colaboradorDao.listByNome(nome);
            }
        } else {
            if(nome == null) {
                colaboradorList = colaboradorDao.listByCategoria(categoriaColaborador);
            } else {
                colaboradorList = colaboradorDao.listByNomeCategoria(categoriaColaborador, nome);
            }
        }
        databaseConnection.close();

        return colaboradorList;
    }

    public static Intent newIntent(Context context, @Nullable CategoriaColaborador categoriaColaborador, @Nullable String nome) {
        Intent intent = new Intent(context, BuscaColaboradorActivity.class);
        intent.putExtra(INTENT_KEY_CATEGORIACOLABORADOR, categoriaColaborador);
        intent.putExtra(INTENT_KEY_NOME, nome);

        return intent;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (colaboradorList != null) {
            outState.putParcelableArray(BUNDLE_KEY_COLABORADOR, colaboradorList.toArray(new Colaborador[colaboradorList.size()]));
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_buscacolaborador, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        SearchView searchViewAction = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchViewAction.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchViewAction.setQueryHint(getString(R.string.buscarcolaborador));
        searchViewAction.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Colaborador> colaboradorList = listColaboradorFromDatabase(categoriaColaborador, query);
                listViewColaborador.setAdapter(new ColaboradorAdapter(colaboradorList, BuscaColaboradorActivity.this));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.equals("")) {
                    List<Colaborador> colaboradorList = listColaboradorFromDatabase(categoriaColaborador, null);
                    listViewColaborador.setAdapter(new ColaboradorAdapter(colaboradorList, BuscaColaboradorActivity.this));
                }
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
