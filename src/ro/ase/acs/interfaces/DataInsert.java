package ro.ase.acs.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataInsert {
    void insertData(Connection connection) throws SQLException;

}
