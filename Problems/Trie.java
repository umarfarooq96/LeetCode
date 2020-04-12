import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Trie {

    TrieNode[] headNodes;

    /*
    Trie = tree that branches on characters
    */

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.headNodes = new TrieNode[26];
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
        TrieNode curNode  = headNodes[word.charAt(0) - 'a'];
        int      curIndex = 0;

        if (curNode == null) {
            curNode = new TrieNode(word.charAt(curIndex));
            headNodes[word.charAt(curIndex) - 'a'] = curNode;
        }

        curIndex++;

        while (curIndex != word.length()) {
            if (curNode.childNodeOf(word.charAt(curIndex)) != null) {
                curNode = curNode.childNodeOf(word.charAt(curIndex));
            } else {
                TrieNode newNode = new TrieNode(word.charAt(curIndex));
                curNode.childNodes[word.charAt(curIndex) - 'a'] = newNode;
                curNode = newNode;
            }
            curIndex++;
        }

        curNode.terminating = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode curNode  = headNodes[word.charAt(0) - 'a'];
        int      curIndex = 1;

        while (curNode != null && curIndex != word.length()) {
            System.out.println(curNode);
            curNode = curNode.childNodeOf(word.charAt(curIndex));
            curIndex++;
        }

        return curNode.terminating;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curNode  = headNodes[prefix.charAt(0) - 'a'];
        int      curIndex = 1;

        while (curNode != null && curIndex < prefix.length()) {
            curNode = curNode.childNodeOf(prefix.charAt(curIndex));
            curIndex++;
        }

        Queue<TrieNode> nodes = new ArrayDeque<>();
        nodes.add(curNode);
        while (!nodes.isEmpty()) {
            TrieNode cur = nodes.poll();
            if (cur.terminating) {
                return true;
            }
            nodes.addAll(cur.existingChildren());
        }

        return false;
    }

    class TrieNode {

        boolean    terminating = false;
        Character  character;
        TrieNode[] childNodes  = new TrieNode[26];

        public TrieNode(char c) {
            this.character = c;
        }

        TrieNode childNodeOf(char character) {
            return childNodes[character - 'a'];
        }

        List<TrieNode> existingChildren() {
            List<TrieNode> ans = new ArrayList<>();
            for (int i = 0; i < childNodes.length; i++) {
                if (childNodes[i] != null) {
                    ans.add(childNodes[i]);
                }
            }
            return ans;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie(); obj.insert(word); boolean param_2 =
 * obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */