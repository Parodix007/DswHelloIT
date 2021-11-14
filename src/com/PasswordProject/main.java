package com.PasswordProject;

import picocli.CommandLine;

public class main {
    public static void main(String[] args) throws RuntimeException {
        int execute = new CommandLine(new CLIClass()).execute("passmng", "-p", "-f", "facebook", "~/");
        System.out.println(execute);
    }
}
