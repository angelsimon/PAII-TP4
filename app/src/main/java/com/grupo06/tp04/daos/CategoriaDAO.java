package com.grupo06.tp04.daos;

import android.content.Context;
import android.os.AsyncTask;

import com.grupo06.tp04.models.CategoriaModel;
import com.grupo06.tp04.system.libraries.MySQLDBConnection;
import com.mysql.jdbc.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public void getAll()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url1 = "jdbc:mysql://angelsimon.com.ar:3306/TP04";
            String user = "tp";
            String password = "Michi_2020";

            Connection conn = DriverManager.getConnection(url1, user, password);
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(String... strings) {

        return null;
    }
}
