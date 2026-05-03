class Solution {
    public boolean checkValidString(String s) {
        int open =0;
        int close =0;
        int blank =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }
            if(s.charAt(i)==')'){
                close++;
            }
            if(s.charAt(i)=='*'){
                blank++;
            }
            while(close>open){
                if(blank==0)return false;
                blank--;
                open++;
            }
        }    
        open = 0;
        close =0;
        blank = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                open++;
            }
            if(s.charAt(i)==')'){
                close++;
            }
            if(s.charAt(i)=='*'){
                blank++;
            }
            while(open>close){
                if(blank==0)return false;
                blank--;
                close++;
            }
        }    
        return true;
    }
}
