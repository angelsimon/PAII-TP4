package com.grupo06.tp04.system.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.grupo06.tp04.models.ArticuloModel;
import com.grupo06.tp04.system.libraries.MySQLDBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticuloInsertAsync extends AsyncTask<String, Void, String> {
    Context context;
    View view;
    ArticuloModel reg;
    int res;

    public ArticuloInsertAsync(Context context, View view, ArticuloModel reg) {
        this.context = context;
        this.view = view;
        this.reg = reg;
        this.res = 0;
    }

    @Override
    protected String doInBackground(String... strings) {
        MySQLDBConnection con = new MySQLDBConnection();
        String query;
        try {
            query = "INSERT INTO articulo(id, nombre, stock, idCategoria) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.connect().prepareStatement(query);
            statement.setLong(1, reg.getId());
            statement.setString(2, reg.getNombre());
            statement.setInt(3, reg.getStock());
            statement.setInt(4, reg.getIdCategoria());
            con.insert(statement);
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
        if(res != 0){
            Toast.makeText(this.context, "Artículo creado correctamente", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this.context, "No se pudo crear el artículo", Toast.LENGTH_LONG).show();
        }
    }

}
