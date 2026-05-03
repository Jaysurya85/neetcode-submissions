class WordDictionary {
    Trie head;
    public WordDictionary() {
        this.head = new Trie(' ');
    }

    public void addWord(String word) {
        Trie current= this.head;

        for(int i=0;i<word.length();i++){
            boolean found = false;
            for(Trie child: current.children){
                if(child.val==word.charAt(i)){
                    current = child;
                    found = true;
                    break;
                }
            }
            if(!found){
                Trie newChild = new Trie(word.charAt(i));
                current.children.add(newChild);
                current = newChild;
            }
            System.out.println(current.val);
        }
        current.isWord=true;
    }

    public boolean searchchar(String word, int currentInd, Trie current){
        if(currentInd==word.length())return current.isWord;
        System.out.println(current.val + " " + word.charAt(currentInd));
        boolean possible = false;
        for(Trie child: current.children){
            if(word.charAt(currentInd) == '.' || child.val == word.charAt(currentInd)){
                possible |= searchchar(word, currentInd+1, child);
            }
        }
        return possible;

    }

    public boolean search(String word) {
        System.out.println("Searching");
        return searchchar(word,0,this.head);
    }
}

class Trie{
    char val;
    List<Trie> children;
    boolean isWord;

    public Trie(char val){
        this.val = val;
        this.children = new ArrayList<>();
        this.isWord = false;
    }
}
