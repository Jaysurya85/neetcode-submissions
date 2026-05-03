// 1 2 3 4 
// 2 2 4 1
// -1 0 -1 3
// -2 3 -4 4

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int n = gas.length;
        int currentGas = 0;
        int totalGas=  0;
        int totalCost =0;
        for(int i=0;i<n;i++){
            currentGas += gas[i] - cost[i];
            totalGas += gas[i];
            totalCost += cost[i];
            if(currentGas<0){
                currentGas=0;
                start = (i+1)%n;
            }
        }
        if(totalGas<totalCost)return -1;
        return start;
    }
}
