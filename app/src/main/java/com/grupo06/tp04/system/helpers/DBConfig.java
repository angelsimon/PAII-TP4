package com.grupo06.tp04.system.helpers;

public class DBConfig {
    public static String host = "174.138.41.228";
    public static String port = "3306";
    public static String nameBD = "TP04";
    public static String user = "tp";
    public static String pass = "Michi_2020";

    public static String urlMySQL = "jdbc:mysql://" + host + ":" + port + "/" + nameBD;
    public static String driver = "com.mysql.jdbc.Driver";

    public static final int MYSQL_DUPLICATE_ENTRY = 1062;
}