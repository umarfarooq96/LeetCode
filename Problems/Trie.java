class Trie {

    TrieNode root = null;

    public Trie() {
        /*
        root will be our entry point for any char
        */
        this.root = new TrieNode();
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("a")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        TrieNode previousChar = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (previousChar.children[curChar - 'a'] == null) {
                TrieNode n = new TrieNode(curChar);
                previousChar.children[curChar - 'a'] = n;
            }
            previousChar = previousChar.children[curChar - 'a'];
        }
        //previousChar is now our last character
        previousChar.terminating = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curNode.children[curChar - 'a'] == null) {
                return false;
            }
        }
        return curNode.terminating;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curNode.children[curChar - 'a'] == null) {
                return false;
            }
        }
        return true;
    }

    class TrieNode {

        public char    thisChar;
        public boolean terminating;
        TrieNode[] children = new TrieNode[26];

        TrieNode(char c) {
            this.thisChar = c;
        }

        TrieNode() {

        }
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie(); obj.insert(word); boolean param_2 =
 * obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */