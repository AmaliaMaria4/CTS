package ro.ase.acs.main;

import ro.ase.acs.classes.DataInserter;
import ro.ase.acs.classes.DataReader;
import ro.ase.acs.classes.TableCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String  CONEXIUNE = "jdbc:sqlite:database.db";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(CONEXIUNE);
            connection.setAutoCommit(false);

            TableCreator tableCreator = new TableCreator();
            tableCreator.createTable(connection);

            DataInserter dataInserter = new DataInserter();
            dataInserter.insertData(connection);

            DataReader dataReader = new DataReader();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
