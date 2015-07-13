package br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;

public class CategoriaColaboradorAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final List<CategoriaColaborador> categoriaColaboradores;
    private final Context context;

    public CategoriaColaboradorAdapter(List<CategoriaColaborador> categoriaColaboradores, Context context) {
        this.context = context;
        this.categoriaColaboradores = categoriaColaboradores;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return categoriaColaboradores != null ? categoriaColaboradores.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return categoriaColaboradores != null ? categoriaColaboradores.get(position) : null;
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
            int layout = R.layout.categoria_colaborador_list;
            convertView = inflater.inflate(layout, null);
            convertView.setTag(holder);

            holder.textViewNome = (TextView) convertView.findViewById(R.id.textview_nome);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        CategoriaColaborador c = categoriaColaboradores.get(position);
        holder.textViewNome.setText(c.getNome());

        return convertView;
    }

    static class ViewHolder{
        TextView textViewNome;
    }
}
