package com.PasswrodProjectTests;

import com.PasswordProject.CLIClass;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

public class CLITest {

    /**
     *  <p>Test mający na celu sprawdzenie poprawności działania programu przy zadanych parametrach i opcjach, sprawdzane jest to na podstawie dokumentacji https://picocli.info/#_exception_exit_codes</p>
     * @author Sebastian Siarczyński
     */
    @Test
    public void validParameters() {
        assertEquals(20, new CommandLine(new CLIClass()).execute("passmng", "-p=dupa", "-f=false", "facebook", "~/"));
        assertEquals(10, new CommandLine(new CLIClass()).execute("passmng", "-p=dupa", "-f", "facebook", "~/"));
        assertEquals(10, new CommandLine(new CLIClass()).execute("passmng", "-p=dupa", "-db", "facebook", "~/"));
    }
}
