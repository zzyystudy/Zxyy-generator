package com.Zxyy.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
public class CheckSum implements Callable<Integer> {




    @Option(names = {"-p", "--password"},
            description = "输入用户密码",arity = "0..1",prompt = "请输入密码: ",
            interactive = true,echo = true)
    private String password;   //这个是通过选项进行指定赋值的

    @Option(names = {"-u","--user"},
            description = "输入用户名",arity = "0..1",prompt = "请输入用户名: ",
            interactive = true)
    private String userName;

    @Option(names = {"-a","--active"})
    private boolean isActive;


    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println("userName: "+userName);
        System.out.println("password: "+password);
        System.out.println("isActive: "+isActive);
        return 0;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new CheckSum()).execute(args);
        System.exit(exitCode);
    }
}
