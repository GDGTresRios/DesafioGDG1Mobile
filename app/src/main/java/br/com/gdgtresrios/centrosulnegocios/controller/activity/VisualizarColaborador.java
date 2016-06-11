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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;

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
        final LinearLayout linearLayoutHead = (LinearLayout) findViewById(R.id.layout_head);

        Glide.with(this)
                .load(colaborador.getLogo())
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(800, 300) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                        linearLayoutHead.setBackground(new BitmapDrawable(getResources(), bitmap));
                    }
                });
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
