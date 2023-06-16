import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        HashMap<Integer, Trie> trie = new HashMap<>();
        HashMap<Integer, Trie> reverse_trie = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            int n = words[i].length();
            
            trie.computeIfAbsent(n, f-> new Trie()).insert(words[i]);
            reverse_trie.computeIfAbsent(n, f-> new Trie()).insert(reverse(words[i]));
        }
        
        for(int i=0; i<queries.length; i++){
            String query = queries[i];
            
            if(query.charAt(0) == '?'){
                Trie t = reverse_trie.get(query.length());
                if(t != null) answer[i] = t.match(reverse(query));
            }
            else {
                Trie t = trie.get(query.length());
                if(t != null) answer[i] = t.match(query);
            }              
        }
        
        return answer;
    }
    
    String reverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
}

class TrieNode{
    HashMap<Character, TrieNode> childNodes = new HashMap<>();
    int useCnt;
    
    HashMap<Character, TrieNode> getChild(){
        return this.childNodes;
    }    
    
    int getUseCount(){
        return useCnt;
    }
}

class Trie{
    TrieNode root;
    
    Trie(){
        root = new TrieNode();
    }
    
    void insert(String str){
        TrieNode curNode = root;     
        curNode.useCnt ++;
        
        for(char c : str.toCharArray()){
            curNode = curNode.getChild().computeIfAbsent(c, f-> new TrieNode());
            curNode.useCnt ++; 
        }
    }
       
    int match(String str){
        TrieNode curNode = root;

		//전체가 ?인 경우
        if(str.charAt(0) == '?'){
            return curNode.getUseCount();
        }
            
        for(char c : str.toCharArray()){       
            if(c == '?'){
                return curNode.getUseCount();
            }
            
            curNode = curNode.getChild().get(c);
            
            if(curNode == null){
                return 0;
            }
        }
        
        return 0;
    }
}