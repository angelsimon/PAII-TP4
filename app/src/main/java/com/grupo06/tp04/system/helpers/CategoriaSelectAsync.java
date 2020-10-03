package com.grupo06.tp04.system.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Spinner;

import com.grupo06.tp04.R;
import com.grupo06.tp04.adapters.CategoriaSpinnerAdapter;
import com.grupo06.tp04.models.CategoriaModel;
import com.grupo06.tp04.system.libraries.MySQLDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaSelectAsync extends AsyncTask<String, Void, String> {
    ArrayList<CategoriaModel> lista = new ArrayList<CategoriaModel>();
    Context context;
    View view;

    public CategoriaSelectAsync(Context context, View view){
        this.context = context;
        this.view = view;
    }

    @Override
    protected String doInBackground(String... strings) {
        MySQLDBConnection con = new MySQLDBConnection();
        try {
            con.connect();
            ResultSet rs = con.select("select * from categoria");
            while(rs.next()){
                CategoriaModel cat = new CategoriaModel();
                cat.setId(rs.getLong("id"));
                cat.setDescripcion(rs.getString("descripcion"));
                lista.add(cat);
            }
            con.close();
            return "OK";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    @Override
    protected void onPostExecute(String response) {
        Spinner cbx = (Spinner) this.view.findViewById(R.id.cbxCategoria);
        CategoriaModel[] elements = lista.toArray(new CategoriaModel[0]);
        CategoriaSpinnerAdapter adapter = new CategoriaSpinnerAdapter(this.view.getContext(), android.R.layout.simple_spinner_dropdown_item, elements);
        cbx.setAdapter(adapter);
    }
}
