package com.PasswordProject;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>FilesClass</h2>
 * <p>Klasa odpowiedzialna za operacje związane z zapisem danych do pliku</p>
 * @author Sebastian Siarczyński
 */
public class FilesClass {
    private final String userPath;
    private String absPath;
    public FilesClass(@NotNull String userPath) {
        this.userPath = userPath;
        setAbsPath();
    }

    /**
     * <p>Metoda, która sprawdza czy zadana ścieżka podana przez użytkownika nie jest plikiem</p>
     * @return Czy ścieżka jest plikiem
     * @author Sebastian Siarczyński
     */
    public boolean checkIfFile() {
        File file = new File(userPath);
        return file.isFile();
    }

    /**
     * <p>Metoda, która wyciąga absolutną ścieżkę z zadanej ścieżki od użytkownika</p>
     * @author Sebastian Siarczyński
     */
    private void setAbsPath() {
        File file = new File(userPath);
        this.absPath = file.getAbsolutePath();
    }

    /**
     * <p>Getter do zmiennej {@link FilesClass#absPath}</p>
     * @return {@link FilesClass#absPath}
     * @author Sebastian Siarczyński
     */
    public String getAbsPath() {
        return absPath;
    }

    /**
     *  <p>Metoda, która jest odpowiedzialna za zapisywanie/dopisywanie danych do pliku</p>
     * @param source źródło, do którego hasło zapisujemy
     * @param hashedPass hasło, które zostało już zaszyfrowane SHA-256
     * @return Czy udało się zapisać dane do pliku i czy plik został utworzony
     */
    public boolean saveToFile(@NotNull String source, @NotNull byte[] hashedPass, @Nullable String userEmail) {
        Map<String, String> userData = new HashMap<>();
        userData.put("password", Arrays.toString(hashedPass));
        userData.put("email", userEmail != null ? userEmail : "");

        Map<String, Map<String, String>> userDataToFile = new HashMap<>();
        userDataToFile.put(source, userData);
        return false;
    }
}
