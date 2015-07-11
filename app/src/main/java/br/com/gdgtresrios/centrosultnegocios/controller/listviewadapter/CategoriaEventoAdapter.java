package br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;

public class CategoriaEventoAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final List<CategoriaEvento> categoriaEventos;
    private final Context context;

    public CategoriaEventoAdapter(List<CategoriaEvento> categoriaEventos, Context context) {
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
            convertView = inflater.inflate(R.layout.categoria_evento_list, null);
            convertView.setTag(holder);

            holder.textViewNome = (TextView) convertView.findViewById(R.id.textview_nome);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CategoriaEvento c = categoriaEventos.get(position);
        holder.textViewNome.setText(c.getNome());

        return convertView;
    }

    static class ViewHolder{
        TextView textViewNome;
    }
}
