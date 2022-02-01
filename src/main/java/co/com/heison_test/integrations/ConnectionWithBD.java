package co.com.heison_test.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionWithBD {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionWithBD.class);
    private int responseInt;

    public ConnectionWithBD() {
        String url = "URL_BASE_DE_DATOS";
        String userBD = "UserBD";
        String passBD = "PassBD";

        try {
          //  DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(url,userBD,passBD);
        } catch (SQLException exception) {
            LOGGER.error("Ocurrio un error de conexion", exception);
        }
    }

    public static ConnectionWithBD postgresql(){return new ConnectionWithBD();}

    public List<String> getInfoOfDataBase(Object[] parameters, String query) throws SQLException {
        List<String> response = new ArrayList<>();
        for(int i=0; i<parameters.length; i++){
            switch (parameters[i].getClass().getSimpleName()){
                case "Integer":
                    preparedStatement.setInt(i+1, (Integer) parameters[i]);
                    break;

                case "String":
                    preparedStatement.setString(i+1, (String) parameters[i]);
                    break;

                case "Boolean":
                    preparedStatement.setBoolean(i+1, (Boolean) parameters[i]);
                    break;
            }
        }

        ResultSet rs = preparedStatement.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int rowcount = rsmd.getColumnCount();

        if(rs.next())
            for(int i=1; i<=rowcount; i++)
                response.add(rs.getString(i));

        return response;
    }

    public int getResponseInt(Object[] parameters, String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        for(int i=0; i<parameters.length; i++){
            switch (parameters[i].getClass().getSimpleName()){
                case "Integer":
                    preparedStatement.setInt(i+1, (Integer) parameters[i]);
                    break;

                case "String":
                    preparedStatement.setString(i+1, (String) parameters[i]);
                    break;

                case "Boolean":
                    preparedStatement.setBoolean(i+1, (Boolean) parameters[i]);
                    break;
            }
        }

        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next())
            responseInt = rs.getInt(1);
        connection.close();

        return responseInt;
    }

    public void updateInformation(Object[] parameters, String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        for(int i=0; i<parameters.length; i++){
            switch (parameters[i].getClass().getSimpleName()){
                case "Integer":
                    preparedStatement.setInt(i+1, (Integer) parameters[i]);
                    break;

                case "String":
                    preparedStatement.setString(i+1, (String) parameters[i]);
                    break;

                case "Boolean":
                    preparedStatement.setBoolean(i+1, (Boolean) parameters[i]);
                    break;
            }
        }
        preparedStatement.executeQuery();
        connection.close();
    }
}

/*
        El funcionamiento de esta clase es el siguiente:

        Lo primero es tener el query, y los parametros que este recibe, ej.
        query = Select cedula, nombre FROM tbl_empleados WHERE edad=? and genero=?

        Lo segundo es crear un array de tipo Object con los parametros.
        Object[] parameters = {edad,genero}

        Lo tercero es invocar a la clase, dependiendo de lo que se necesite.
        ConnectionWithBD.postgresql().getResponseInt(parameters, query).

 */
