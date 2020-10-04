package com.grupo06.tp04.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grupo06.tp04.R;
import com.grupo06.tp04.models.ArticuloModel;

import java.util.ArrayList;

public class ArticuloListAdapter extends BaseAdapter {

    ArrayList<ArticuloModel> lista;
    Context ctx;

    public ArticuloListAdapter(ArrayList<ArticuloModel> lista, Context ctx) {
        this.lista = lista;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public ArticuloModel getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View vista = view;
        String unidad, stock;

        if (vista == null){
            vista = inflater.inflate(R.layout.articulo_list_template,null);
        }

        TextView txtNombreId = (TextView) vista.findViewById(R.id.txtNombreId);
        TextView txtStock = (TextView) vista.findViewById(R.id.txtStock);
        TextView txtCategoria = (TextView) vista.findViewById(R.id.txtCategoria);

        txtNombreId.setText(getItem(i).getNombre() + " (" + getItem(i).getId().toString() + ")");
        unidad = (getItem(i).getStock() == 1? " unidad": " unidades");
        if (getItem(i).getStock() == 0) {
            stock = "Sin stock";
        }
        else{
            stock = getItem(i).getStock().toString() + unidad;
        }
        txtStock.setText(stock);
        txtCategoria.setText(getItem(i).getCategoria().getDescripcion());

        return vista;
    }
}
