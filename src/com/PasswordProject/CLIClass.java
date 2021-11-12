package com.PasswordProject;

import picocli.CommandLine;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * <h2>CLIClass</h2>
 * <p>Klasa odpowiedzialna za obsługę całego procesu CLI dla aplikacji w tej klasie odbywają się procesy interpretowania komend</p>
 * @author Sebastian Siarczyński
 */
@CommandLine.Command(name = "passmng", description = "Zapisywanie haseł do pliku lub lokalnej bazy danych", version = "0.0.1", exitCodeOnSuccess = 10, exitCodeOnInvalidInput = 11, exitCodeOnExecutionException = 20)
public class CLIClass implements Callable<Integer> {

    /**
     * <h2>SaveOptions</h2>
     * <p>Klasa odpowiedzialna za grupowanie typów zapisu</p>
     * @author Sebastian Siarczyński
     */
    private static class SaveOptions {
        public SaveOptions(){}
        /**
         *  <p>Opcja, która określa czy chcesz zapisać swoje dane do pliku, pliki są zapisywane w rozszerzeniu JSON, plik jest ukryty i nie podaje mu się nazwy jest ona domyślna</p>
         * @author Sebastian Siarczyński
         */
        @CommandLine.Option(names = {"-f", "-file"}, description = "Flaga, która mówi o tym czy chcesz używać pliku do zapisu haseł", paramLabel = "Flaga pliku", required = false)
        boolean file;

        /**
         *  <p>Opcja, która określa czy chcesz dane zapisywać do bazy danych, baza danych jest z góry zdeterminowana więc użytkownik nie może używać swoich baz danych</p>
         * @author Sebastian Siarczyński
         */
        @CommandLine.Option(names = {"-db", "-database"}, description = "Flaga, która mówi o tym czy chcesz używać bazy danych do zapisu haseł", paramLabel = "Flaga bazy danych", required = false)
        boolean db;
    }

    @CommandLine.ArgGroup(multiplicity = "1")
    SaveOptions saveOptions = new SaveOptions();

    /**
     *  <p>Parametr, który określa do jakiego źródła chcesz zapisać hasło</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "źródło", description = "Do czego potrzebujesz zapisać hasło", index = "0")
    String sourceName;

    /**
     *  <p>Parametr, do którego podaje się scieżkę pliku</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Ścieżka do pliku", description = "Ścieżka do pliku.\nBez nazwy pliku!!!!", index = "1")
    String filePath;

    /**
     *  <p>Parametr, do którego wprwadza się nazwę lokalną użytkownika, który może łączyć się z bazą danych</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Nazwa użytkownika do bazy danych", arity = "0", index = "2")
    String dbUser;

    /**
     * <p>Parametr, do którego można wprowadzić swój adres email powiązany z hasłem, które chcemy zapisać</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Twoj adres email", description = "Adres email, który jest używany do logowania", arity = "0", index = "3")
    String userEmail;

    /**
     *  <p>Opcja z hasłem do bazy danych dla użytkownika, który ma się łączyć z bazą</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Option(names = {"-dbpass"}, paramLabel = "Hasło bazy danych", description = "Hasło do bazy danych dla użytkownika, który został podany", interactive = true)
    String dbPass;

    /**
     *  <p>Opcja z hasłem, które chcemy zapisać</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Option(names = {"-p", "-password"}, required = true, paramLabel = "Hasło", description = "Hasło, które chcesz zapisać", interactive = true)
    String passToSave;

    /**
     *  <p>Metoda, w której będzie odbywać się procedura obsługi poleceń wpisanych przez użytkownika</p>
     * @return Czy udało się wszystko zapisać
     * @throws Exception Gdy, w którymś z kroków programu wystąpi błąd
     * @author Sebastian Siarczyński
     */
    @Override
    public Integer call() throws Exception {
        MessageDigest passHash = MessageDigest.getInstance("SHA-256");
        if (saveOptions.db) {
            System.out.println("DATA BASE");
            return 10;
        }
        if (saveOptions.file) {
            FilesClass filesClass = new FilesClass(filePath);
            if (filesClass.checkIfFile()) throw new Exception("Podana ścieżka jest plikiem!");
            return 10;
        }
        throw new Exception("Brak obowiązkowych argumentów");
    }
}
