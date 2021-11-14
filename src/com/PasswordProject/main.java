package com.PasswordProject;

import picocli.CommandLine;

import java.util.Arrays;

public class main {
    public static void main(String[] args) throws RuntimeException {
//        int execute = new CommandLine(new CLIClass()).execute("-p", "-f", "facebook", "/Users/sebastiansiarczynski", "test@gmail.com");
//        System.exit(execute);
        String x = "1 * 2";
        String[] split = x.split("\\D\\s");
        String[] split1 = x.split("\\d");
        System.out.println(Arrays.toString(split));
        System.out.println(Arrays.toString(split1));
    }
}
