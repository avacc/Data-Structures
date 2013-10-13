package com.trie;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 10/12/13
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    private final String value;
    private HashMap<Character, Node> children = new HashMap<Character, Node>();
    private boolean isValidWord;

    public Node(String argValue) {
        value = argValue;
    }

    public boolean addChild(char c, Node argChild) {
        children.put(c, argChild);
        return true;
    }

    public boolean containsChildValue(char c) {
        return children.containsKey(c);
    }

    public String getValue() {
        return value.toString();
    }

    public Node getChild(char c) {
        return children.get(c);
    }

    public boolean isWord() {
        return isValidWord;
    }

    public void setIsWord(boolean argIsWord) {
        isValidWord = argIsWord;

    }

    public String toString() {
        return value;
    }
}
