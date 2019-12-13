package com.ctr.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNote extends BaseAdapter {

    private Context context;
    private ArrayList<StructNote> arrayList;
    private TextView id, singer, title, otroDato;

    public AdapterNote(Context context, ArrayList<StructNote> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.elemento_lista_ejemplo, parent, false);
        id = convertView.findViewById(R.id.id);
        singer = convertView.findViewById(R.id.singer);
        title = convertView.findViewById(R.id.title);
        otroDato = convertView.findViewById(R.id.otroDato);

        id.setText(" " + arrayList.get(position).getId());
        singer.setText(arrayList.get(position).getSinger());
        title.setText(arrayList.get(position).getTitle());
        otroDato.setText(arrayList.get(position).getOtroDato());
        return convertView;
    }
}

/*
private class AdapterNote extends ArrayAdapter<StructNote> {
    public AdapterNote(ArrayList<StructNote> notesPage, Context context) {
        super(context, R.layout.elemento_lista_ejemplo, notesPage);
    }
}*/