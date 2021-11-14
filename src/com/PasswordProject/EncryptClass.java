package com.PasswordProject;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *  <h2>EncryptClass</h2>
 *  <p>Klasa odpowiedzialna za szyfrowanie i deszyfrowanie zadanych stringow</p>
 * @author Sebastian Siarczyński
 */
public class EncryptClass {

    /**
     * <p>Metoda, która szyfruje podany string w standardzie SHA-256</p>
     * @param stringToHash String, który ma być zaszyfrowany
     * @return Tablice z zaszyfrowanego stringa w odpowiednim formacie
     * @throws NoSuchAlgorithmException Jeżeli nie znajdzie podanego standrardu szyfrowania
     * @author Sebastian Siarczyński
     */
    @NotNull
    public static byte[] hashStringToSHA256(@NotNull String stringToHash) throws NoSuchAlgorithmException{
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        return instance.digest(stringToHash.getBytes(StandardCharsets.UTF_8));
    }
}
