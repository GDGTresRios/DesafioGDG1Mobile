package br.com.gdgtresrios.centrosultnegocios.controller.activity;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
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

        Evento evento = getIntent().getParcelableExtra(INTENT_KEY_EVENTO);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(evento.getNome());
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textViewNome = (TextView) findViewById(R.id.textview_nome);
        textViewNome.setText(evento.getNome());
        TextView textViewColaborador = (TextView) findViewById(R.id.textview_colaborador);
        textViewColaborador.setText(evento.getColaborador().getNome());

        TextView textViewDescricaoDetalhada = (TextView) findViewById(R.id.textview_descricaodetalhada);
        TextView textViewCategoria = (TextView) findViewById(R.id.textview_categoria);
        TextView textViewData = (TextView) findViewById(R.id.textview_date);
        TextView textViewLocal = (TextView) findViewById(R.id.textview_local);
        TextView textViewColaboradorNome = (TextView) findViewById(R.id.textview_colaboradornome);
        TextView textViewColaboradorDescricao = (TextView) findViewById(R.id.textview_colaboradordescricao);
        final LinearLayout linearLayoutHead = (LinearLayout) findViewById(R.id.layout_head);

        Glide.with(this)
        .load(evento.getColaborador().getLogo())
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(800, 300) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                        linearLayoutHead.setBackground(new BitmapDrawable(getResources(), bitmap));
                    }
                });
        textViewDescricaoDetalhada.setText(evento.getDescricaoDetalhada());
        textViewCategoria.setText(evento.getCategoriaEvento().getNome());
        textViewColaboradorNome.setText(evento.getColaborador().getNome());
        textViewColaboradorDescricao.setText(evento.getColaborador().getDescricaoDetalhada());
        textViewLocal.setText(evento.getLocal().equals("") ? getString(R.string.activityvisualizaevento_indefinido)
                : evento.getLocal() );

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
