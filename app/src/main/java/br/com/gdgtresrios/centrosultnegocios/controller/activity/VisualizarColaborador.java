package br.com.gdgtresrios.centrosultnegocios.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;
import br.com.gdgtresrios.centrosulnegocios.model.Evento;

public class VisualizarColaborador extends AppCompatActivity {

    private static final String INTENT_KEY_COLABORADOR = "intent_key_colaborador";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizarcolaborador);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Colaborador colaborador = getIntent().getParcelableExtra(INTENT_KEY_COLABORADOR);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(colaborador.getNome());
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        TextView textViewNome = (TextView) findViewById(R.id.textview_nome);
        TextView textViewDescricaoDetalhada = (TextView) findViewById(R.id.textview_descricaodetalhada);

        textViewNome.setText(colaborador.getNome());
        textViewDescricaoDetalhada.setText(colaborador.getDescricaoDetalhada());

    }

    public static Intent newIntent(Context context, Colaborador colaborador) {
        Intent intent = new Intent(context, VisualizarColaborador.class);
        intent.putExtra(INTENT_KEY_COLABORADOR, colaborador);

        return intent;
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
