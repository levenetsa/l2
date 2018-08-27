package com.lev;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BorDictionary implements Dictionary {

    private class Node {
        Node[] children = new Node[26];
        List<String> results = new ArrayList<>();
        final char sign;

        Node(char sign) {
            this.sign = sign;
        }
    }

    private Node root = new Node('s');

    public BorDictionary() {
        System.out.println("Tree created. Enter word to search.");
    }

    @Override
    public void createTree(String fileName) throws IOException {
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                addToTree(line);
            }
        }
    }

    private void addToTree(String line) {
        for (int i = 0; i < line.length(); i++) {
            Node node = root;
            int index;
            for (int j = i; j < line.length(); j++) {
                index = (int) line.charAt(j) - 97;
                if (node.children[index] == null) {
                    node.children[index] = new Node(line.charAt(j));
                }
                node.children[index].results.add(line);
                node = node.children[index];
            }
        }
    }

    @Override
    public boolean containsBadSigns(String command) {
        for (char sign : command.toCharArray()) {
            if ((int) sign - 97 <= -1 || (int) sign - 97 >= 27) {
                System.out.println("Bad sign : '" + sign + "'");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> search(String line) {
        Node node = root;
        for (int i = 0; i < line.length(); i++) {
            node = node.children[(int) line.charAt(i) - 97];
        }
        return node == null ? Collections.emptyList() : node.results;
    }
}


