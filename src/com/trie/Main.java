package com.trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String words[] = {"a", "apple", "argument", "aptitude", "ball", "bat"};
        Trie trie = new Trie(Arrays.asList(words));
        try {
            while (true) {
                System.out.print("Word to look up: ");
                String word = reader.readLine().trim();
                if (word.isEmpty())
                    break;
                if (trie.containsWord(word))
                    System.out.println("\"" + word + "\"" + " found");
                else if (trie.containsPrefix(word))
                    if (confirm(word + " is a prefix. Add it as a word?"))
                        trie.addWord(word);
                else
                    if (confirm("Add " + word + "?"))
                        trie.addWord(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean confirm(String question) throws IOException {
        while (true) {
            System.out.print(question + " ");
            String ans = reader.readLine().trim();

            if (ans.equalsIgnoreCase("N") || ans.equalsIgnoreCase("NO")) {
                return false;
            }
            if (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("YES")) {
                return true;
            }
            System.out.println("Please answer 'Y' || 'YES' or 'N' || 'NO'");
        }
    }
}
