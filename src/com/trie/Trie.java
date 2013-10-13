package com.trie;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 10/12/13
 * Time: 5:20 PM
 */

public class Trie {
    private Node root = new Node("");

    public Trie() {}

    public Trie(List<String> initialWords) {
        for (String word : initialWords)
            addWord(word);
    }

    public void addWord(String word) {
        char argChars[] = word.toCharArray();
        Node currentNode = root;

        for (char c : argChars) {
            if (!currentNode.containsChildValue(c))
                currentNode.addChild(c, new Node(currentNode.getValue() + c));
            currentNode = currentNode.getChild(c);
        }

        currentNode.setIsWord(true);
    }

    public boolean containsPrefix(String prefix) {
        return contains(prefix, false);
    }

    public boolean containsWord(String word) {
        return contains(word, true);
    }

    public Node getWord(String word) {
        Node node = getNode(word);
        return node != null && node.isWord() ? node : null;
    }

    public Node getPrefix(String prefix) {
        return getNode(prefix);
    }

    private boolean contains(String str, boolean isWord) {
        Node node = getNode(str);
        return (node != null && node.isWord() && isWord) ||
                (!isWord && node != null);
    }

    private Node getNode(String node) {
        Node currentNode = root;
        char argChars[] = node.toCharArray();
        for (char c : argChars) {
            currentNode = currentNode.getChild(c);

            if (currentNode == null)
                return null;
        }
        return currentNode;
    }
}
