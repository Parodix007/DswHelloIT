package com.PasswrodProjectTests;

import com.PasswordProject.FilesClass;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <h2>FilesTest</h2>
 * <p>Klasa testowa odpowiedzialna za testowanie funkcjonalności związanych z zapisem danych do pliku w podanej przez użytwkonika lokalizacji</p>
 * @author Sebastian Siarczyński
 */
public class FilesTest {
    private FilesClass filesClass;
    private String path = "/Users/sebastiansiarczynski/";

    /**
     * <p>Metoda, która pozwala na inicjowanie klasy {@link FilesClass} przed każdym testem</p>
     * TODO: Czy nie będzie to bardziej efketywne aby wyekstraktować to do po prostu inicjowania w lini 16
     * @author Sebastian Siarczyński
     */
    @BeforeEach
    public void initFilesClass() {
        filesClass = new FilesClass(path);
    }

    /**
     * <p>Metoda sprawdzająca czy podana ścieżka w konstruktorze klasy {@link FilesClass#FilesClass(String)} jest folderem i czy isteniej</p>
     * @author Sebastian Siarczyński
     */
    @Test
    public void checkIfFile() {
        assertTrue(filesClass.checkIfProperPath());
    }

    /**
     * <p>Metoda sprawdzająca poprawność wyciągania ścieżki absolutnej z klasy {@link FilesClass}</p>
     * @author Sebastian Siarczyński
     */
    @Test
    public void checkAbsPath() {
        File file = new File(path);
        assertEquals(file.getAbsolutePath(), filesClass.getAbsPath());
    }
    @Test
    public void checkFullPath() {
        assertNotNull(filesClass.getFullPath());
    }
    /**
     * <p>Metoda sprwadzająca poprawność zapisywania do pliku</p>
     * @throws NoSuchAlgorithmException
     * @author Sebastian Siarczyński
     */
    @Test
    public void checkSaveToFile() throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        String pass = "1234";
        byte[] encodedPass = instance.digest(pass.getBytes(StandardCharsets.UTF_8));

        assertTrue(filesClass.saveToFile("Facebook", encodedPass, "test@gmail.com"));
    }
}
