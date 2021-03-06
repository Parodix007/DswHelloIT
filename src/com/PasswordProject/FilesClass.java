package com.PasswordProject;

import groovy.json.JsonBuilder;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// TODO: Jak odczytywać dane z pliku bez ładowania całego

/**
 * <h2>FilesClass</h2>
 * <p>Klasa odpowiedzialna za operacje związane z zapisem danych do pliku</p>
 * @author Sebastian Siarczyński
 */
public class FilesClass {
    private final String userPath;
    private String absPath;
    private final File fullPath;
    public FilesClass(@NotNull String userPath) {
        this.userPath = userPath;
        setAbsPath();
        fullPath = new File(absPath + "/.passmng");
    }

    /**
     * <p>Metoda, która sprawdza czy zadana ścieżka podana przez użytkownika jest prawidłowa/p>
     * @return Czy ścieżka jest plikiem
     * @author Sebastian Siarczyński
     */
    public boolean checkIfProperPath() {
        File file = new File(userPath);
        return !file.isFile() && file.isDirectory() && file.exists();
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
    @NotNull
    public String getAbsPath() {
        return absPath;
    }

    /**
     * <p>Getter do zmiennej {@link FilesClass#fullPath}</p>
     * @return {@link FilesClass#fullPath}
     * @author Sebastian Siarczyński
     */
    @NotNull
    public File getFullPath() {
        return fullPath;
    }

    /**
     * <p>Metoda odpowiedzialna za zapisywanie hasła użytkownika do pliku</p>
     * @param source źródło, do którego potrzebujemy zapisać hasło
     * @param hashedPass zaszyfrowane hasło, które zapisujemy do pliku
     * @param userEmail ewentualny adres email powiązany z hasłem, które zapisujemy
     * @return Czy udało się zapisać hasło i plik
     * @author Sebastian Siarczyński
     */
    public boolean saveToFile(@NotNull String source, @NotNull byte[] hashedPass, @Nullable String userEmail) {
        Map<String, String> userData = new HashMap<>();
        userData.put("password", Arrays.toString(hashedPass));
        userData.put("email", userEmail != null ? userEmail : "");

        Map<String, Map<String, String>> userDataToFile = new HashMap<>();
        userDataToFile.put(source, userData);
        JsonBuilder jsonBuilder = new JsonBuilder(userDataToFile);
        try {
            Files.writeString(Path.of(fullPath.toString()), jsonBuilder.toString());
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
