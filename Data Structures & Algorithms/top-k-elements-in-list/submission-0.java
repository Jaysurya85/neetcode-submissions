class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> freqNums = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mp: map.entrySet()){
            freqNums.add(new int[]{mp.getKey(),mp.getValue()});
        }
        Collections.sort(freqNums, (a,b) -> Integer.compare(b[1],a[1]));
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = freqNums.get(i)[0];
        }
        return ans;
    }
}
