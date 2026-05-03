class Solution {
    public void makeParenthesis(int n, int open, int close, List<String> ans, StringBuilder sb){
        if(open+close==2*n){
            ans.add(sb.toString());
        }
        if(open<n){
            sb.append('(');
            makeParenthesis(n,open+1,close,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            makeParenthesis(n,open,close+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        makeParenthesis(n,0,0, ans, new StringBuilder());
        return ans;
    }
}
