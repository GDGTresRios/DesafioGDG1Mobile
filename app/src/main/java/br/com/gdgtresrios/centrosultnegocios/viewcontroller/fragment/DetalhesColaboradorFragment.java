package br.com.gdgtresrios.centrosultnegocios.viewcontroller.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;

public class DetalhesColaboradorFragment extends Fragment {

    private Colaborador colaborador;
    public static final String BUNDLE_KEY_COLABORADOR = "bundle_key_colaborador";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalhes_colaborador, null);
        view.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();

        if (args != null){
            colaborador = (Colaborador) args.getParcelable(BUNDLE_KEY_COLABORADOR);
            updateView();
        }
    }

    private void updateView() {

        View view = getView();

        TextView tNome = (TextView) view.findViewById(R.id.tNome);
        TextView tDescricao = (TextView) view.findViewById(R.id.tDescricao);
        TextView tEndereco = (TextView) view.findViewById(R.id.tEndereco);
        TextView tEmail = (TextView) view.findViewById(R.id.tEmail);
        TextView tFone = (TextView) view.findViewById(R.id.tFone);
        TextView tDescDetalhada = (TextView) view.findViewById(R.id.tDescDetalhada);
        final ImageView img = (ImageView) view.findViewById(R.id.imgFoto);

        tNome.setText(colaborador.getNome());
        tDescricao.setText(colaborador.getDescricao());
        tEndereco.setText(colaborador.getEndereco());
        tEmail.setText(colaborador.getEmail());
        tFone.setText(colaborador.getTelefone());
        tDescDetalhada.setText(colaborador.getDescricaoDetalhada());
        Bitmap bitmap = null;
        if (bitmap != null){
            img.setImageBitmap(bitmap);
        }
    }
}
