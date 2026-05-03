class Solution {
    public void findSum(int[] nums, int target,int current, List<Integer> temp, List<List<Integer>> ans) {
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=current;i<nums.length;i++){
            if(i>current && nums[i]==nums[i-1])continue;
            if(nums[i]<=target){
                temp.add(nums[i]);
                findSum(nums,target-nums[i],i+1,temp,ans);
                temp.remove((Object)nums[i]);
            }
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates,target,0,new ArrayList<>(), ans);
        return ans;
    }
}
