import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Map<Integer, WordTree> tree = new HashMap<>();
        Map<Integer, WordTree> reverseTree = new HashMap<>();

        for (String word : words) {
            tree.computeIfAbsent(word.length(), key -> new WordTree())
                    .insert(word);
            reverseTree.computeIfAbsent(word.length(), key -> new WordTree())
                    .insert(reverse(word));
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (query.startsWith("?")) {
                WordTree t = reverseTree.get(query.length());
                if (t != null) answer[i] = t.match(reverse(query));
            } else {
                WordTree t= tree.get(query.length());
                if (t != null) answer[i] = t.match(query);
            }
        }

        return answer;
    }

    String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}

class Node {
    Map<Character, Node> childNode = new HashMap<>();
    int useCnt;
}

class WordTree {
    Node rootNode;

    WordTree() {
        rootNode = new Node();
    }

    void insert(String str) {
        Node curNode = this.rootNode;
        curNode.useCnt++;

        for(int i=0; i<str.length(); i++) {
            curNode = curNode.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
            curNode.useCnt++;
        }
    }

    int match(String str) {
        Node curNode = rootNode;

        if (str.charAt(0) == '?') {
            return curNode.useCnt;
        }

        for (char c : str.toCharArray()) {
            if (c == '?') {
                return curNode.useCnt;
            }

            curNode = curNode.childNode.get(c);

            if (curNode == null) {
                return 0;
            }
        }
        return 0;
    }
}
