package com.grupo06.tp04.system.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.grupo06.tp04.R;
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
        String query;
        String responseError = "No se pudo crear el artículo";
        try {
            MySQLDBConnection con = new MySQLDBConnection();
            query = "INSERT INTO articulo(id, nombre, stock, idCategoria) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.connect().prepareStatement(query);
            statement.setLong(1, reg.getId());
            statement.setString(2, reg.getNombre());
            statement.setInt(3, reg.getStock());
            statement.setInt(4, reg.getIdCategoria());
            res = con.executeNonQuery(statement);
            con.close();
            return "OK";
        } catch (SQLException e) {
            if (e.getErrorCode() == DBConfig.MYSQL_DUPLICATE_ENTRY){
                responseError = "Ya existe un artículo con el ID especificado";
            }
            res = 0;
        } catch (ClassNotFoundException e) {
            res = 0;
        }
        catch(Exception e){
            res = 0;
        }
            return responseError;
    }

    @Override
    protected void onPostExecute(String response) {
        if(res != 0){
            Toast.makeText(this.context, "Artículo creado correctamente", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this.context, response, Toast.LENGTH_LONG).show();
        }
        limpiar();
    }

    private void limpiar(){
        EditText txtId, txtNombre, txtStock;
        Spinner cbxCategoria;
        //bind
        txtId = (EditText) view.findViewById(R.id.txtID);
        txtNombre = (EditText) view.findViewById(R.id.txtNombre);
        txtStock = (EditText) view.findViewById(R.id.txtStock);
        cbxCategoria = (Spinner) view.findViewById(R.id.cbxCategoria);
        //set default values
        txtId.setText("");
        txtNombre.setText("");
        txtStock.setText("");
        cbxCategoria.setSelection(0);
        //focus
        txtId.requestFocus();
    }

}
