package com.example.myapplicationlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptadorNoticias extends ArrayAdapter<Noticias> {
    public AdaptadorNoticias(Context context, Noticias[] datos) {
        super(context, R.layout.ly_noticias, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) { //controla los datos
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_noticias, null);// colocar  el layaut que posee la estuctura de los listView

        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(getItem(position).getTitulo());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(getItem(position).getSubtitulo());
        return(item);
    }
}
