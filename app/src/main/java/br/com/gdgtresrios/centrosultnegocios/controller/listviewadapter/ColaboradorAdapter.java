package br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter;

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
import br.com.gdgtresrios.centrosulnegocios.model.Colaborador;

public class ColaboradorAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final List<Colaborador> colaboradores;
    private final Context context;

    public ColaboradorAdapter(List<Colaborador> colaboradores, Context context) {
        this.colaboradores = colaboradores;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return colaboradores != null ? colaboradores.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return colaboradores != null ? colaboradores.get(position) : null;
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

            int layout = R.layout.colaborador_list;
            convertView = inflater.inflate(layout, null);
            convertView.setTag(holder);

            holder.tNome = (TextView) convertView.findViewById(R.id.textview_nome);
            holder.imgFoto = (ImageView) convertView.findViewById(R.id.img);
            holder.progress = (ProgressBar) convertView.findViewById(R.id.progress);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imgFoto.setImageBitmap(null);

        Colaborador c = colaboradores.get(position);
        holder.tNome.setText(c.getNome());
        //holder.imgFoto

        return convertView;
    }

    static class ViewHolder{
        TextView tNome;
        ImageView imgFoto;
        ProgressBar progress;
    }
}
