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

public class CategoriaDAO {
    Context context;


    public CategoriaDAO(Context context) {
        this.context = context;
    }


}
