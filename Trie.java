public class Trie {
    class Node {
        public boolean isEnd;
        public Node[] children;

        public Node(){
            children = new Node[26];
            isEnd = false;
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cursor = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            Node child = cursor.children[(int)(c-97)];
            if (child == null) {
                cursor.children[(int)(c-97)] = new Node();
            }
            cursor = cursor.children[(int)(c-97)];
        }
        cursor.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cursor = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            Node child = cursor.children[(int)(c-97)];
            if (child == null)
                return false;
            cursor = child;
        }
        return cursor.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cursor = root;
        int length = prefix.length();
        for (int i = 0; i < length; i++) {
            char c = prefix.charAt(i);
            Node child = cursor.children[(int)(c-97)];
            if (child == null)
                return false;
            cursor = child;
        }
        return true;
    }
}
