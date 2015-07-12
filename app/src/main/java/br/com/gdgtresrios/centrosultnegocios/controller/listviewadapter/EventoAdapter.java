package br.com.gdgtresrios.centrosultnegocios.controller.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosulnegocios.model.Evento;

public class EventoAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final List<Evento> eventos;
    private final Context context;

    public EventoAdapter(List<Evento> eventos, Context context) {
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
        ViewHolder viewHolder = null;

        if (convertView == null){
            viewHolder = new ViewHolder();

            int layout = R.layout.evento_list;
            convertView = inflater.inflate(layout, null);
            convertView.setTag(viewHolder);

            viewHolder.textViewNome = (TextView) convertView.findViewById(R.id.textview_nome);
            viewHolder.textViewDescricao = (TextView) convertView.findViewById(R.id.textview_descricao);
            viewHolder.textViewDateEvento = (TextView) convertView.findViewById(R.id.textview_date);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Evento c = eventos.get(position);
        viewHolder.textViewNome.setText(c.getNome());
        viewHolder.textViewDescricao.setText(c.getDescricao());

        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date data = c.getDataHora();
        String formatDate = dateFormat.format(data);
        viewHolder.textViewDateEvento.setText(formatDate);

        return convertView;
    }

    static class ViewHolder{
        TextView textViewNome;
        TextView textViewDescricao;
        TextView textViewDateEvento;
    }
}
