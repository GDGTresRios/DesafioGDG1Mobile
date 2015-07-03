package br.com.gdgtresrios.centrosultnegocios.viewcontroller.listviewadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;

/**
 * Created by Wanderlei on 02/07/2015.
 */

public class CategoriaColaboradorAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final List<CategoriaColaborador> categoriaColaboradores;
    private final Activity context;

    public CategoriaColaboradorAdapter(List<CategoriaColaborador> categoriaColaboradores, Activity context) {
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
            int layout = 0;
            convertView = inflater.inflate(layout, null);
            convertView.setTag(holder);

            holder.tNome = (TextView) convertView.findViewById(R.id.tNome);
            holder.imgFoto = (ImageView) convertView.findViewById(R.id.img);
            holder.progress = (ProgressBar) convertView.findViewById(R.id.progress);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imgFoto.setImageBitmap(null);

        CategoriaColaborador c = categoriaColaboradores.get(position);
        holder.tNome.setText(c.getNome());
        ///holder.imgFoto

        return convertView;
    }

    static class ViewHolder{
        TextView tNome;
        ImageView imgFoto;
        ProgressBar progress;
    }
}
