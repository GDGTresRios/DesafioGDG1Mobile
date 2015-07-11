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
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;
import br.com.gdgtresrios.centrosulnegocios.model.Evento;
import br.com.gdgtresrios.centrosulnegocios.model.dao.DatabaseConnection;
import br.com.gdgtresrios.centrosulnegocios.model.dao.EventoDao;
import br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter.EventoAdapter;

public class BuscaEventoActivity extends AppCompatActivity {

    private static final String INTENT_KEY_CATEGORIAEVENTO = "intent_key_categoriaevento";
    private final String BUNDLE_KEY_EVENTO = "bundle_key_evento";

    private ListView listViewEvento;
    private List<Evento> eventoList;
    private CategoriaEvento categoriaEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscaevento);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        categoriaEvento = getIntent().getParcelableExtra(INTENT_KEY_CATEGORIAEVENTO);
        if (categoriaEvento == null) {
            getSupportActionBar().setSubtitle(getString(R.string.buscaeventoactivity_substitle_todos));
        } else {
            getSupportActionBar().setSubtitle(categoriaEvento.getNome());
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            eventoList = categoriaEvento == null ? listEventosFromDatabase() : listEventosFromDatabase(categoriaEvento);
        } else {
            Evento[] categoriaColaboradorArray = (Evento[]) savedInstanceState.getParcelableArray(BUNDLE_KEY_EVENTO);
            if (categoriaColaboradorArray != null) {
                eventoList = Arrays.asList(categoriaColaboradorArray);
            } else {
                eventoList = categoriaEvento == null ? listEventosFromDatabase() : listEventosFromDatabase(categoriaEvento);
            }
        }

        listViewEvento = (ListView) findViewById(R.id.listview_evento);
        listViewEvento.setAdapter(new EventoAdapter(eventoList, this));
    }

    private List<Evento> listEventosFromDatabase(CategoriaEvento categoriaEvento) {
        SQLiteDatabase databaseConnection = new DatabaseConnection(this).getWritableDatabase();
        EventoDao eventoDao = new EventoDao(databaseConnection);
        List<Evento> eventoList;
        eventoList = eventoDao.listByCategoria(categoriaEvento);
        databaseConnection.close();

        return eventoList;
    }

    private List<Evento> listEventosFromDatabase(String nome) {
        SQLiteDatabase databaseConnection = new DatabaseConnection(this).getWritableDatabase();
        EventoDao eventoDao = new EventoDao(databaseConnection);
        List<Evento> eventoList = eventoDao.listByNome(nome);
        databaseConnection.close();

        return eventoList;
    }

    private List<Evento> listEventosFromDatabase() {
        SQLiteDatabase databaseConnection = new DatabaseConnection(this).getWritableDatabase();
        EventoDao eventoDao = new EventoDao(databaseConnection);
        List<Evento> eventoList = eventoDao.listAll();
        databaseConnection.close();

        return eventoList;
    }

    public static Intent newIntent(Context context, CategoriaEvento categoriaEvento) {
        Intent intent = new Intent(context, BuscaEventoActivity.class);
        intent.putExtra(INTENT_KEY_CATEGORIAEVENTO, categoriaEvento);

        return intent;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (eventoList != null) {
            outState.putParcelableArray(BUNDLE_KEY_EVENTO, eventoList.toArray(new Evento[eventoList.size()]));
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_buscaevento, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        SearchView searchViewAction = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchViewAction.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchViewAction.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Evento> eventoList = listEventosFromDatabase(query);
                listViewEvento.setAdapter(new EventoAdapter(eventoList, BuscaEventoActivity.this));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.equals("")) {
                    List<Evento> eventoList = listEventosFromDatabase();
                    listViewEvento.setAdapter(new EventoAdapter(eventoList, BuscaEventoActivity.this));
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
