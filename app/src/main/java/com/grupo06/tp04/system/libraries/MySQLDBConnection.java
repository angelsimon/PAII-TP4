package com.grupo06.tp04.system.libraries;
import com.grupo06.tp04.system.helpers.DBConfig;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDBConnection {
    private String host;
    private String port;
    private String nameBD;
    private String user;
    private String pass;

    private Connection con;


    public MySQLDBConnection() {
        this.host = DBConfig.host;
        this.port = DBConfig.port;
        this.nameBD = DBConfig.nameBD;
        this.user = DBConfig.user;
        this.pass = DBConfig.pass;
    }

    public MySQLDBConnection(String host, String port, String nameBD, String user, String pass) {
        this.host = host;
        this.port = port;
        this.nameBD = nameBD;
        this.user = user;
        this.pass = pass;
    }

    private String getUrlConnection(){
        return "jdbc:mysql://" + host + ":" + port + "/" + nameBD;
    }

    public Connection connect() throws SQLException, ClassNotFoundException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(this.getUrlConnection(), this.user, this.pass);
            return this.con;
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public ResultSet select(String sqlQuery) throws SQLException {
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            return resultSet;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public int insert(PreparedStatement statement) throws SQLException {
        int res;
        try{
            res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void close() throws SQLException {
        try {
            if (!this.con.isClosed()) {
                this.con.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
