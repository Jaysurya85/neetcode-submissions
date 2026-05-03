class Solution {
    public double myPow(double x, int n) {
        if(x==0)return 0;
        if(n==0)return 1;
        double mul = x;
        if(n<0){
            mul = 1/x;
        }
        if(n==1)return mul;
        if(n%2==0)return myPow(x,n/2)*myPow(x,n/2);
        else return mul*myPow(x,n/2)*myPow(x,n/2);
    }
}
