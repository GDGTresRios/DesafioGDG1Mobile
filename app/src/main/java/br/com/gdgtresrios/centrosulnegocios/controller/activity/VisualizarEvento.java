package br.com.gdgtresrios.centrosulnegocios.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Evento;

public class VisualizarEvento extends AppCompatActivity {

    private static final String INTENT_KEY_EVENTO = "intent_key_evento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizarevento);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Evento evento = getIntent().getParcelableExtra(INTENT_KEY_EVENTO);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textViewNomeEvento = (TextView) findViewById(R.id.textview_nomeevento);
        textViewNomeEvento.setText(evento.getNome());
        TextView textViewColaborador = (TextView) findViewById(R.id.textview_colaborador);
        textViewColaborador.setText(evento.getColaborador().getNome());

        TextView textViewDescricaoDetalhada = (TextView) findViewById(R.id.textview_descricaodetalhada);
        Button buttonMaisSobreColaborador = (Button) findViewById(R.id.button_maissobrecolaborador);
        buttonMaisSobreColaborador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(VisualizarColaborador.newIntent(VisualizarEvento.this, evento.getColaborador()));
            }
        });
        Button buttonCategoria = (Button) findViewById(R.id.button_categoria);
        TextView textViewData = (TextView) findViewById(R.id.textview_date);
        TextView textViewLocal = (TextView) findViewById(R.id.textview_local);
        TextView textViewColaboradorNome = (TextView) findViewById(R.id.textview_colaboradornome);
        TextView textViewColaboradorDescricao = (TextView) findViewById(R.id.textview_colaboradordescricao);
        ImageView imageView = (ImageView) findViewById(R.id.imageview_logo);

        Glide.with(this).load(evento.getColaborador().getLogo()).into(imageView);
        textViewDescricaoDetalhada.setText(evento.getDescricaoDetalhada());
        buttonCategoria.setText(String.format(getString(R.string.visualizareventoactivity_vermaisdacategoria),evento.getCategoriaEvento().getNome()));
        buttonCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(BuscaEventoActivity.newIntent(VisualizarEvento.this, evento.getCategoriaEvento(), null));
            }
        });
        textViewColaboradorNome.setText(String.format(getString(R.string.activityvisualizarevento_textview_descricaocolaborador), evento.getColaborador().getNome()));
        textViewColaboradorDescricao.setText(evento.getColaborador().getDescricaoDetalhada());
        textViewLocal.setText(evento.getLocal().equals("") ? getString(R.string.activityvisualizaevento_indefinido) : evento.getLocal() );

        Date data = evento.getDataHora();
        DateFormat simpleDateFormat = new SimpleDateFormat("'Dia' dd/MM ' às ' kk:mm");
        String formatDate = simpleDateFormat.format(data);
        textViewData.setText(formatDate);


    }

    public static Intent newIntent(Context context, Evento evento) {
        Intent intent = new Intent(context, VisualizarEvento.class);
        intent.putExtra(INTENT_KEY_EVENTO, evento);

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
