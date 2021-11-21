package com.PasswordProject;

import picocli.CommandLine;

public class main {
    public static void main(String[] args) throws RuntimeException {
        int execute = new CommandLine(new CLIClass()).execute("-p", "-f", "facebook", "/Users/sebastiansiarczynski", "test2@gmail.com");
        switch (execute) {
            case 10 -> System.out.println("Twoje dane zostały zapisane!");
            case 20, 11 -> System.out.println("Nie udało się zapisać danych!");
        }
        System.exit(execute);
    }
}
