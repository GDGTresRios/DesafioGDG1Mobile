package br.com.gdgtresrios.centrosulnegocios.controller.fragment;

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
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;
import br.com.gdgtresrios.centrosulnegocios.model.dao.CategoriaColaboradorDao;
import br.com.gdgtresrios.centrosulnegocios.model.dao.DatabaseConnection;
import br.com.gdgtresrios.centrosulnegocios.controller.activity.BuscaColaboradorActivity;
import br.com.gdgtresrios.centrosulnegocios.controller.listviewadapter.CategoriaColaboradorAdapter;

public class CategoriaColaboradorFragment extends Fragment {

    private GridView gridViewCategoriaColaborador;
    private List<CategoriaColaborador> categoriaColaboradorList;

    private static final String CATEGORIACOLABORADORLIST_KEY = "categoriacolaboradorlist_key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_categoriacolaborador, container, false);

        if (savedInstanceState != null) {
            CategoriaColaborador[] categoriaColaboradorArray = (CategoriaColaborador[]) savedInstanceState.getParcelableArray(CATEGORIACOLABORADORLIST_KEY);
            if(categoriaColaboradorArray != null) {
                categoriaColaboradorList = Arrays.asList(categoriaColaboradorArray);
            } else {
                categoriaColaboradorList = getAllCategoriaColaboradorFromDatabase();
            }
        } else {
            categoriaColaboradorList = getAllCategoriaColaboradorFromDatabase();
        }

        gridViewCategoriaColaborador = (GridView) view.findViewById(R.id.gridview_categoriacolaborador);
        gridViewCategoriaColaborador.setAdapter(new CategoriaColaboradorAdapter(categoriaColaboradorList, getActivity()));
        gridViewCategoriaColaborador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoriaColaborador categoriaColaborador = (CategoriaColaborador) parent.getAdapter().getItem(position);
                startActivity(BuscaColaboradorActivity.newIntent(getActivity(), categoriaColaborador, null));
            }
        });
        return view;
    }

    private List<CategoriaColaborador> getAllCategoriaColaboradorFromDatabase() {
        SQLiteDatabase databaseConnection = new DatabaseConnection(getActivity()).getWritableDatabase();
        CategoriaColaboradorDao categoriaColaboradorDao = new CategoriaColaboradorDao(databaseConnection);
        List<CategoriaColaborador> categoriaColaboradorList = categoriaColaboradorDao.listAll();
        databaseConnection.close();

        return categoriaColaboradorList;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(categoriaColaboradorList != null) {
            outState.putParcelableArray(CATEGORIACOLABORADORLIST_KEY, categoriaColaboradorList.toArray(new CategoriaColaborador[categoriaColaboradorList.size()]));
        }
        super.onSaveInstanceState(outState);
    }

}
