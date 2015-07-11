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
import br.com.gdgtresrios.centrosulnegocios.model.Evento;
import br.com.gdgtresrios.centrosulnegocios.model.dao.DatabaseConnection;
import br.com.gdgtresrios.centrosulnegocios.model.dao.EventoDao;
import br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter.EventoAdapter;

public class ProximosEventosFragment extends Fragment {

    private ListView listViewProximosEventos;
    private List<Evento> eventoList;

    private static final String EVENTOLIST_KEY = "eventolist_key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_proximos_eventos, container, false);

        if (savedInstanceState != null) {
            Evento[] eventoArray = (Evento[]) savedInstanceState.getParcelableArray(EVENTOLIST_KEY);
            if(eventoArray != null) {
                eventoList = Arrays.asList(eventoArray);
            } else {
                eventoList = getNextEventosFromDatabase();
            }
        } else {
            eventoList = getNextEventosFromDatabase();
        }

        listViewProximosEventos = (ListView) view.findViewById(R.id.listview_proximos_eventos);
        listViewProximosEventos.setAdapter(new EventoAdapter(eventoList, getActivity()));

        return view;
    }

    private List<Evento> getNextEventosFromDatabase() {
        SQLiteDatabase databaseConnection = new DatabaseConnection(getActivity()).getWritableDatabase();
        EventoDao eventoDao = new EventoDao(databaseConnection);
        List<Evento> eventoList = eventoDao.listNext(20);
        databaseConnection.close();

        return eventoList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(eventoList != null) {
            outState.putParcelableArray(EVENTOLIST_KEY, eventoList.toArray(new Evento[eventoList.size()]));
        }
        super.onSaveInstanceState(outState);
    }

}
