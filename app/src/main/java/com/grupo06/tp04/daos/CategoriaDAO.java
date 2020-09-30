package com.grupo06.tp04.daos;

import android.content.Context;
import android.os.AsyncTask;

import com.grupo06.tp04.models.CategoriaModel;
import com.grupo06.tp04.system.libraries.MySQLDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO extends AsyncTask<String, Void, String> {
    Context context;


    public CategoriaDAO(Context context) {
        this.context = context;
    }

    /*ArrayList<CategoriaModel> getAll(){
       ArrayList<CategoriaModel> lista = new ArrayList<CategoriaModel>();
       try {

       }
       catch(Exception ex){

       }
        return lista;
    }*/

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        MySQLDBConnection cn = new MySQLDBConnection();
        try {
            cn.connect();
            ResultSet rs = cn.select("select * from categoria");
            while(rs.next()){
                String nombre = rs.getString("descripcion");
            }
            return rs;
        } catch (SQLException e) {
           throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    @Override
    protected String doInBackground(String... strings) {

        return null;
    }
}
