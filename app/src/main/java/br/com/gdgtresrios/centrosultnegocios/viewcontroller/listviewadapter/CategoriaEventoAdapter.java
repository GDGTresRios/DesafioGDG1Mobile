package br.com.gdgtresrios.centrosultnegocios.viewcontroller.listviewadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;

/**
 * Created by Wanderlei on 02/07/2015.
 */

public class CategoriaEventoAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final List<CategoriaEvento> categoriaEventos;
    private final Activity context;

    public CategoriaEventoAdapter(List<CategoriaEvento> categoriaEventos, Activity context) {
        this.context = context;
        this.categoriaEventos = categoriaEventos;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return categoriaEventos != null ? categoriaEventos.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return categoriaEventos != null ? categoriaEventos.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null){
            holder = new ViewHolder();
            int layout = R.layout.categoria_evento_list;
            convertView = inflater.inflate(layout, null);
            convertView.setTag(holder);

            holder.tNome = (TextView) convertView.findViewById(R.id.tNome);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CategoriaEvento c = categoriaEventos.get(position);
        holder.tNome.setText(c.getNome());

        return convertView;
    }

    static class ViewHolder{
        TextView tNome;
    }
}
