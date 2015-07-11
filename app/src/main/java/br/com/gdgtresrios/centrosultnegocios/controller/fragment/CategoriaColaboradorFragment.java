package br.com.gdgtresrios.centrosultnegocios.controller.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;
import br.com.gdgtresrios.centrosulnegocios.model.dao.CategoriaColaboradorDao;
import br.com.gdgtresrios.centrosulnegocios.model.dao.DatabaseConnection;
import br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter.CategoriaColaboradorAdapter;

public class CategoriaColaboradorFragment extends Fragment {

    private ListView listViewCategoriaColaborador;
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

        listViewCategoriaColaborador = (ListView) view.findViewById(R.id.listview_categoriacolaborador);
        listViewCategoriaColaborador.setAdapter(new CategoriaColaboradorAdapter(categoriaColaboradorList, getActivity()));

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
