package com.PasswrodProjectTests;

import com.PasswordProject.DBClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

/**
 * <h2>DBTest</h2>
 * <p>Klasa odpowiedzialna za testowanie funkcjonalności związanych z bazą danych</p>
 * @author Sebastian Siarczyński
 */
public class DBTest {
    private DBClass DB;
    @BeforeEach
    public void initDB() {
        DB = new DBClass();
    }

    @Test
    public void makeConnTest() throws SQLException {
        DB.setDBConn("PasswordProject", "test1234!", "testinguser");
        assertNotNull(DB.getDBConn());
    }
}
