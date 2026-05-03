class Solution {

    public boolean isNumeric(String s){
        try{
            int val = Integer.parseInt(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;

        for(int i=0;i<n;i++){
            String token = tokens[i];
            if(isNumeric(token)){
                stack.push(Integer.parseInt(token));
            }
            else{
                int first = stack.pop();
                int second = stack.pop();
                if(token.equals("+")){
                    stack.push(first+second);
                }
                if(token.equals("-")){
                    stack.push(second-first);
                }
                if(token.equals("*")){
                    stack.push(first*second);
                }
                if(token.equals("/")){
                    stack.push(second/first);
                }
            }
        }
        return stack.pop();
    }
}
