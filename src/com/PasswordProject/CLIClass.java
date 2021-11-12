package com.PasswordProject;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * <h2>CLIClass</h2>
 * <p>Klasa odpowiedzialna za obsługę całego procesu CLI dla aplikacji w tej klasie odbywają się procesy interpretowania komend</p>
 * @author Sebastian Siarczyński
 */
public class CLIClass implements Callable<Boolean> {

    /**
     *  <p>Parametr, który określa do jakiego źródła chcesz zapisać hasło</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "źródło", description = "Do czego potrzebujesz zapisać hasło")
    String sourceName;

    /**
     *  <p>Opcja, która określa czy chcesz zapisać swoje dane do pliku, pliki są zapisywane w rozszerzeniu JSON, plik jest ukryty i nie podaje mu się nazwy jest ona domyślna</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Option(names = {"-f", "--file"}, description = "Flaga, która mówi o tym czy chcesz używać pliku do zapisu haseł", paramLabel = "Flaga pliku")
    boolean file;

    /**
     *  <p>Parametr, do którego podaje się scieżkę pliku</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Ścieżka do pliku")
    String filePath;

    /**
     *  <p>Opcja, która określa czy chcesz dane zapisywać do bazy danych, baza danych jest z góry zdeterminowana więc użytkownik nie może używać swoich baz danych</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Option(names = {"-db", "--database"}, description = "Flaga, która mówi o tym czy chcesz używać bazy danych do zapisu haseł", paramLabel = "Flaga bazy danych")
    boolean db;

    /**
     *  <p>Parametr, do którego wprwadza się nazwę lokalną użytkownika, który może łączyć się z bazą danych</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Nazwa użytkownika do bazy danych", arity = "0")
    String dbUser;

    /**
     * <p>Parametr, do którego można wprowadzić swój adres email powiązany z hasłem, które chcemy zapisać</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Twoj adres email", description = "Adres email, który jest używany do logowania", arity = "0")
    String userEmail;

    /**
     *  <p>Parametr z hasłem do bazy danych dla użytkownika, który ma się łączyć z bazą</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Hasło bazy danych", description = "Hasło do bazy danych dla użytkownika, który został podany", arity = "0")
    String dbPass;

    /**
     *  <p>Parametr z hasłem, które chcemy zapisać</p>
     * @author Sebastian Siarczyński
     */
    @CommandLine.Parameters(paramLabel = "Hasło", description = "Hasło, które chcesz zapisać", interactive = true)
    String passToSave;

    /**
     *  <p>Metoda, w której będzie odbywać się procedura obsługi poleceń wpisanych przez użytkownika</p>
     * @return Czy udało się wszystko zapisać
     * @throws Exception Gdy, w którymś z kroków programu wystąpi błąd
     * @author Sebastian Siarczyński
     */
    @Override
    public Boolean call() throws Exception {
        return null;
    }
}
