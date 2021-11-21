package com.PasswordProject;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h2>DBClass</h2>
 * <p>Klasa odpowiedzialna za obsługę połązcenia i funkcjonalności związanych z bazą danych</p>
 * @author Sebastian Siarczyński
 */
public class DBClass {
    private Connection DBConn = null;
    /**
     * <p>Setter do zmiennej {@link DBClass#DBConn}</p>
     * @param dbname Nazwa bazy danych, do której wykonywane jest połączenie
     * @param dbpass Hasło do użytkownika, na którego się logujemy
     * @param dbuser Nazwa użytkownika, do którego się logujemy
     * @throws SQLException Gdy nie udało się nazwiązać połączenia
     * @aythor Sebastian Siarczyński
     */
    public void setDBConn(@NotNull String dbname, @NotNull String dbpass, @NotNull String dbuser) throws SQLException {
        DBConn = DriverManager.getConnection(String.format("jdbc:mysql://localhost/%s?user=%s&password=%s", dbname, dbuser, dbpass));
    }

    /**
     * <p>Getter do zmiennej {@link DBClass#DBConn}</p>
     * @return {@link DBClass#DBConn}
     */
    public Connection getDBConn() {
        return DBConn;
    }
}
