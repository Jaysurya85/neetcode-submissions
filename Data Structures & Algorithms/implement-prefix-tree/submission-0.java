class PrefixTree {
    Trie head;
    public PrefixTree() {
         this.head = new Trie(' ');
    }

    public void insert(String word) {
        Trie current= head;
        boolean found = false;

        for(int i=0;i<word.length();i++){
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
        }
        current.isWord=true;

    }

    public boolean search(String word) {
        Trie current= head;
        boolean found = false;
        for(int i=0;i<word.length();i++){
            for(Trie child: current.children){
                if(child.val==word.charAt(i)){
                    current = child;
                    found = true;
                    break;
                }
            }
            if(!found)return false;
        }
        return current.isWord;

    }

    public boolean startsWith(String word) {
        Trie current= head;
        boolean found = false;

        for(int i=0;i<word.length();i++){
            for(Trie child: current.children){
                if(child.val==word.charAt(i)){
                    current = child;
                    found = true;
                    break;
                }
            }
            if(!found)return false;
        }
        return true;
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
