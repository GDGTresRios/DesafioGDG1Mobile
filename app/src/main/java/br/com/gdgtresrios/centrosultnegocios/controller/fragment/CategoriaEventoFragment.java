package br.com.gdgtresrios.centrosultnegocios.controller.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Arrays;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;
import br.com.gdgtresrios.centrosulnegocios.model.dao.CategoriaEventoDao;
import br.com.gdgtresrios.centrosulnegocios.model.dao.DatabaseConnection;
import br.com.gdgtresrios.centrosultnegocios.controller.activity.BuscaEventoActivity;
import br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter.CategoriaEventoAdapter;

public class CategoriaEventoFragment extends Fragment {

    private GridView gridViewCategoriaEvento;
    private List<CategoriaEvento> categoriaEventoList;

    private static final String CATEGORIAEVENTOLIST_KEY = "categoriaeventolist_key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_categoriaevento, container, false);

        if (savedInstanceState != null) {
            CategoriaEvento[] categoriaEventoArray = (CategoriaEvento[]) savedInstanceState.getParcelableArray(CATEGORIAEVENTOLIST_KEY);
            if(categoriaEventoArray != null) {
                categoriaEventoList = Arrays.asList(categoriaEventoArray);
            } else {
                categoriaEventoList = getAllCategoriaEventoFromDatabase();
            }
        } else {
            categoriaEventoList = getAllCategoriaEventoFromDatabase();
        }

        gridViewCategoriaEvento = (GridView) view.findViewById(R.id.gridview_categoriaevento);
        gridViewCategoriaEvento.setAdapter(new CategoriaEventoAdapter(categoriaEventoList, getActivity()));
        gridViewCategoriaEvento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoriaEvento categoriaEvento = (CategoriaEvento) parent.getAdapter().getItem(position);
                startActivity(BuscaEventoActivity.newIntent(getActivity(), categoriaEvento));
            }
        });
        return view;
    }

    private List<CategoriaEvento> getAllCategoriaEventoFromDatabase() {
        SQLiteDatabase databaseConnection = new DatabaseConnection(getActivity()).getWritableDatabase();
        CategoriaEventoDao categoriaEventoDao = new CategoriaEventoDao(databaseConnection);
        List<CategoriaEvento> categoriaEventoList = categoriaEventoDao.listAll();
        databaseConnection.close();

        return categoriaEventoList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(categoriaEventoList != null) {
            outState.putParcelableArray(CATEGORIAEVENTOLIST_KEY, categoriaEventoList.toArray(new CategoriaEvento[categoriaEventoList.size()]));
        }
        super.onSaveInstanceState(outState);
    }

}
