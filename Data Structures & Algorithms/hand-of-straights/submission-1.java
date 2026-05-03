class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0)return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(map.get(hand[i])==0)continue;
            for(int j=0;j<groupSize;j++){
                if(!map.containsKey(hand[i]+j) || map.get(hand[i]+j)==0)return false;
                map.put(hand[i]+j,map.get(hand[i]+j)-1);
            }
        }
        return true;
    }
}
// 1 2 2 3 3 4 4 5
// 