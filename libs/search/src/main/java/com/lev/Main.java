package com.lev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please pass file name to import data from. Each word in file should be on new line.");
        }
        System.out.println("This is modified bor Type 'exit' to terminate program");
        try {
            BorDictionary dictionary = new BorDictionary();
            dictionary.createTree(args[0]);
            initListener(dictionary);
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file " + new File(args[0]).getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initListener(BorDictionary dictionary) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("exit")) {
                System.exit(0);
            }
            if (!dictionary.containsBadSigns(command)) {
                printResult(dictionary.search(command));
            }
        }
    }

    private static void printResult(List<String> search) {
        System.out.println(Arrays.toString(search.toArray()));
    }}
