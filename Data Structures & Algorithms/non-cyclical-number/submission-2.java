class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(!seen.contains(n)){
            if(n==1)return true;
            seen.add(n);
            int current = 0;
            while(n>0){
                int dig = n%10;
                current += dig*dig;
                n /=10;
            }
            n = current;
        }
        return false;
    }
}
