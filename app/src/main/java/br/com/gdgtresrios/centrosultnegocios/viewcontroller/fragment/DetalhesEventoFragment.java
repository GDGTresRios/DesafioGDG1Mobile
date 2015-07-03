package br.com.gdgtresrios.centrosultnegocios.viewcontroller.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Evento;

/**
 * Created by Wanderlei on 03/07/2015.
 */
public class DetalhesEventoFragment extends BaseFragment {

    private Evento evento;
    private DateFormat mFormatter = new SimpleDateFormat("dd-MM-yyyy");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalhes_evento, null);
        view.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        if (args != null ){
            evento = (Evento) args.getSerializable(Evento.KEY);
            updateView();
        }
    }

    private void updateView(){
        View view = getView();

        TextView tNome = (TextView) view.findViewById(R.id.tNome);
        TextView tDescricao = (TextView) view.findViewById(R.id.tDescricao);
        TextView tDescDetalhada = (TextView) view.findViewById(R.id.tDescDetalhada);
        TextView tDateEvento = (TextView) view.findViewById(R.id.tDateEvento);
        final ImageView img = (ImageView) view.findViewById(R.id.imgFoto);

        tNome.setText(evento.getNome());
        tDescricao.setText(evento.getDescricao());
        tDescDetalhada.setText(evento.getDescricaoDetalhada());

        Date data = evento.getDataHora();
        String formatDate = mFormatter.format(data);
        tDateEvento.setText(formatDate);

        Bitmap bitmap = null;
        if (bitmap != null){
            img.setImageBitmap(bitmap);
        }



    }
}
