// [1,2] [7,2] [4,5]
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        boolean[] valid = new boolean[n];
        boolean[] present = new boolean[target.length];
        for(int i=0;i<n;i++){
            if(triplets[i][0]<=target[0] && triplets[i][1]<=target[1]  && triplets[i][2]<=target[2]){
                valid[i] = true;
                if(triplets[i][0]==target[0])present[0]=true;
                if(triplets[i][1]==target[1])present[1]=true;
                if(triplets[i][2]==target[2])present[2]=true;
            }
        }
        for(int i=0;i<target.length;i++){
            System.out.println(present[i]);
            if(!present[i])return false;
        }
        return true;
        
    }
}
