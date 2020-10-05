package com.grupo06.tp04.system.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.grupo06.tp04.R;
import com.grupo06.tp04.adapters.CategoriaSpinnerAdapter;
import com.grupo06.tp04.models.ArticuloModel;
import com.grupo06.tp04.models.CategoriaModel;
import com.grupo06.tp04.system.libraries.MySQLDBConnection;
import com.grupo06.tp04.ui.fragments.ModificarFragment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloSelectOneAsync extends AsyncTask<String, Void, String> {
    ArticuloModel articulo;
    Context context;
    View view;
    Boolean hasData;

    public ArticuloSelectOneAsync(Context context, View view, ArticuloModel articulo){
        this.context = context;
        this.view = view;
        this.articulo = articulo;
        this.hasData = false;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            MySQLDBConnection con = new MySQLDBConnection();
            con.connect();
            ResultSet rs = con.select("select a.*, c.* from categoria as c inner join articulo as a on c.id = a.idCategoria where a.id = " + String.valueOf(this.articulo.getId()));
            while(rs.next()){
                CategoriaModel cat = new CategoriaModel();
                articulo.setId(rs.getLong("a.id"));
                articulo.setNombre(rs.getString("a.nombre"));
                articulo.setStock(rs.getInt("a.stock"));
                articulo.setIdCategoria(rs.getInt("a.idCategoria"));
                cat.setId(rs.getInt("c.id"));
                cat.setDescripcion(rs.getString("c.descripcion"));
                articulo.setCategoria(cat);
                this.hasData = true;
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
        EditText txtID = (EditText)view.findViewById(R.id.txtId);
        EditText txtNombre = (EditText)view.findViewById(R.id.txtNombre);
        EditText txtStock = (EditText)view.findViewById(R.id.txtStock);
        Spinner cbxCategorias = (Spinner) view.findViewById(R.id.cbxCategoria);

        if (this.hasData){
            txtNombre.setText(articulo.getNombre());
            txtStock.setText(articulo.getStock().toString());
            CategoriaSpinnerAdapter adaptador = (CategoriaSpinnerAdapter) cbxCategorias.getAdapter();
            cbxCategorias.setSelection(adaptador.getPosition(articulo.getIdCategoria()));
        }
        else{
            this.articulo = null;
            txtID.setText("");
            txtNombre.setText("");
            txtStock.setText("");
            cbxCategorias.setSelection(0);
            Toast.makeText(this.context, "No existe el artículo", Toast.LENGTH_SHORT).show();
        }
    }
}