package zad12;


public class Main {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isLeaf;

        public TrieNode() {
            isLeaf = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;
    static int indexes;

    static void insert(String key) {
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isLeaf = true;
    }

    static int countChildren(TrieNode node) {
        int count = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                count++;
                indexes = i;
            }
        }
        return (count);
    }

    static String walkTrie()
    {
        TrieNode pCrawl = root;
        indexes = 0;
        StringBuilder prefix = new StringBuilder();

        while (countChildren(pCrawl) == 1 &&
                !pCrawl.isLeaf)
        {
            pCrawl = pCrawl.children[indexes];
            prefix.append((char) ('a' + indexes));
        }
        return prefix.toString();
    }

    static void constructTrie(String[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            insert (arr[i]);
    }

    static String commonPrefix(String[] arr, int n)
    {
        root = new TrieNode();
        constructTrie(arr, n);
        return walkTrie();
    }

    public static void main(String[] args)
    {
        String[] arr = {"code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codependence", "codependency", "codependent",
                "codependents", "codes", "codesign", "codesigned", "codeveloped",
                "codeveloper", "codex", "codify", "codiscovered", "codrive"};
        int n = arr.length;

        String ans = commonPrefix(arr, n);

        if (ans.length() != 0)
            System.out.println("Najduzi zajednicki prefiks je "+ans);
        else
            System.out.println("Nema zajednickog prefiksa");
    }
}
