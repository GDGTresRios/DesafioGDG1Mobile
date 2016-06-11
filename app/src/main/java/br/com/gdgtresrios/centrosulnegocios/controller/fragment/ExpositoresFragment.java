package br.com.gdgtresrios.centrosulnegocios.controller.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;
import br.com.gdgtresrios.centrosulnegocios.model.dao.ColaboradorDao;
import br.com.gdgtresrios.centrosulnegocios.model.dao.DatabaseConnection;
import br.com.gdgtresrios.centrosulnegocios.controller.activity.VisualizarColaborador;
import br.com.gdgtresrios.centrosulnegocios.controller.listviewadapter.ColaboradorAdapter;

public class ExpositoresFragment extends Fragment {

    private ListView listViewColaborador;
    private List<Colaborador> colaboradorList;

    private static final String COLABORADORLIST_KEY = "colaboradorlist_key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_expositores, container, false);

        if (savedInstanceState != null) {
            Colaborador[] categoriaColaboradorArray = (Colaborador[]) savedInstanceState.getParcelableArray(COLABORADORLIST_KEY);
            if(categoriaColaboradorArray != null) {
                colaboradorList = Arrays.asList(categoriaColaboradorArray);
            } else {
                colaboradorList = getAllCategoriaColaboradorFromDatabase();
            }
        } else {
            colaboradorList = getAllCategoriaColaboradorFromDatabase();
        }

        listViewColaborador = (ListView) view.findViewById(R.id.listview_colaborador);
        listViewColaborador.setAdapter(new ColaboradorAdapter(colaboradorList, getActivity()));
        listViewColaborador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Colaborador colaborador = (Colaborador) parent.getAdapter().getItem(position);
                startActivity(VisualizarColaborador.newIntent(getActivity(), colaborador));
            }
        });

        return view;
    }

    private List<Colaborador> getAllCategoriaColaboradorFromDatabase() {
        SQLiteDatabase databaseConnection = new DatabaseConnection(getActivity()).getWritableDatabase();
        ColaboradorDao colaboradorDao = new ColaboradorDao(databaseConnection);
        List<Colaborador> categoriaColaboradorList = colaboradorDao.listAllExpositor();
        databaseConnection.close();

        return categoriaColaboradorList;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(colaboradorList != null) {
            outState.putParcelableArray(COLABORADORLIST_KEY, colaboradorList.toArray(new Colaborador[colaboradorList.size()]));
        }
        super.onSaveInstanceState(outState);
    }

}

