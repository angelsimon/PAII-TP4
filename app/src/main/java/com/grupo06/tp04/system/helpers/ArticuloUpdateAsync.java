package com.grupo06.tp04.system.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.grupo06.tp04.models.ArticuloModel;
import com.grupo06.tp04.system.libraries.MySQLDBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticuloUpdateAsync extends AsyncTask<String, Void, String> {
    Context context;
    View view;
    ArticuloModel reg;
    int res;

    public ArticuloUpdateAsync(Context context, View view, ArticuloModel reg) {
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
            query = "UPDATE articulo SET nombre = ?, stock = ?, idCategoria = ? WHERE id = ?";
            PreparedStatement statement = con.connect().prepareStatement(query);
            statement.setString(1, reg.getNombre());
            statement.setInt(2, reg.getStock());
            statement.setInt(3, reg.getIdCategoria());
            statement.setLong(4, reg.getId());
            res = con.executeNonQuery(statement);
            return "OK";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            res = 0;
        }
        return "ERROR";
    }

    @Override
    protected void onPostExecute(String response) {
        if(res != 0){
            Toast.makeText(this.context, "Artículo modificado correctamente", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this.context, "No se pudo modificar el artículo", Toast.LENGTH_LONG).show();
        }
    }

}
