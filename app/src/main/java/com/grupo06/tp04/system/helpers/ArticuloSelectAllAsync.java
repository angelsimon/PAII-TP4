package com.grupo06.tp04.system.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.grupo06.tp04.R;
import com.grupo06.tp04.adapters.CategoriaSpinnerAdapter;
import com.grupo06.tp04.models.ArticuloModel;
import com.grupo06.tp04.models.CategoriaModel;
import com.grupo06.tp04.system.libraries.MySQLDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloSelectAllAsync extends AsyncTask<String, Void, String> {
    ArrayList<ArticuloModel> lista = new ArrayList<ArticuloModel>();
    Context context;
    View view;

    public ArticuloSelectAllAsync(Context context, View view){
        this.context = context;
        this.view = view;
    }

    @Override
    protected String doInBackground(String... strings) {
        MySQLDBConnection con = new MySQLDBConnection();
        try {
            con.connect();
            ResultSet rs = con.select("select a.*, c.* from categoria as c inner join articulo as a on c.id = a.idCategoria");
            while(rs.next()){
                ArticuloModel art = new ArticuloModel();
                CategoriaModel cat = new CategoriaModel();
                art.setId(rs.getLong("a.id"));
                art.setNombre(rs.getString("a.nombre"));
                art.setStock(rs.getInt("a.stock"));
                art.setIdCategoria(rs.getInt("a.idCategoria"));
                cat.setId(rs.getInt("c.id"));
                cat.setDescripcion(rs.getString("c.descripcion"));
                art.setCategoria(cat);
                lista.add(art);
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
       TextView txtPrueba = (TextView) view.findViewById(R.id.txtPrueba);
       String elementos = "";
       for(ArticuloModel elemento:lista){
           elementos += elemento.toString() + "\n";
       }
       txtPrueba.setText(elementos);
    }
}
