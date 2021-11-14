package com.PasswrodProjectTests;

import com.PasswordProject.EncryptClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;

/**
 *  <h2>EncryptTest</h2>
 *  <p>Klasa testująca działanie szyfrowania zadanego stringa</p>
 * @author Sebastian Siarczyński
 */
public class EncryptTest {

    /**
     * <p>Test sprawdzający czy zwracana wartość nie jest nullem</p>
     * @throws NoSuchAlgorithmException
     * @author Sebastian Siarczyński
     */
    @Test
    public void checkEncrypt() throws NoSuchAlgorithmException {
        assertNotNull(EncryptClass.hashStringToSHA256("1234"));
    }
}
