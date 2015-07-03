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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Evento;

/**
 * Created by Wanderlei on 02/07/2015.
 */
public class EventoAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final List<Evento> eventos;
    private final Activity context;
    private DateFormat mFormatter = new SimpleDateFormat("dd-MM-yyyy");

    public EventoAdapter(List<Evento> eventos, Activity context) {
        this.eventos = eventos;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return eventos != null ? eventos.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return eventos != null ? eventos.get(position) : null;
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

            int layout = R.layout.evento_list;
            convertView = inflater.inflate(layout, null);
            convertView.setTag(holder);

            holder.tNome = (TextView) convertView.findViewById(R.id.tNome);
            holder.tDescricao = (TextView) convertView.findViewById(R.id.tDescricao);
            holder.tDateEvento = (TextView) convertView.findViewById(R.id.tDateEvento);
            holder.imgFoto = (ImageView) convertView.findViewById(R.id.img);
            holder.progress = (ProgressBar) convertView.findViewById(R.id.progress);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imgFoto.setImageBitmap(null);

        Evento c = eventos.get(position);
        holder.tNome.setText(c.getNome());
        holder.tDescricao.setText(c.getDescricao());

        Date data = c.getDataHora();
        String formatDate = mFormatter.format(data);
        holder.tDateEvento.setText(formatDate);
        //holder.imgFoto

        return convertView;
    }

    static class ViewHolder{
        TextView tNome;
        TextView tDescricao;
        TextView tDateEvento;
        ImageView imgFoto;
        ProgressBar progress;
    }
}
