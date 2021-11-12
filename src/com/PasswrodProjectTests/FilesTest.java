package com.PasswrodProjectTests;

import com.PasswordProject.FilesClass;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FilesTest {
    private FilesClass filesClass;
    private String path = "/Users/sebastiansiarczynski/";
    @BeforeEach
    public void initFilesClass() {
        filesClass = new FilesClass(path);
    }
    @Test
    public void checkIfFile() {
        assertFalse(filesClass.checkIfFile());
    }
    @Test
    public void checkAbsPath() {
        File file = new File(path);
        assertEquals(file.getAbsolutePath(), filesClass.getAbsPath());
    }
}
