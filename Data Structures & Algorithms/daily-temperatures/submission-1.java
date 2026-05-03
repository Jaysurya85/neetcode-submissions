class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!stack.empty() && temperatures[i]>=stack.peek()[0])stack.pop();
            if(stack.empty()){
                result[i]=0;
            }
            else{
                result[i] = stack.peek()[1]-i;
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return result;
    }
}
