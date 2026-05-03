class Solution {
    public void findSum(int[] nums, int target,int current, List<Integer> temp, List<List<Integer>> ans) {
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=current;i<nums.length;i++){
            if(nums[i]<=target){
                temp.add(nums[i]);
                findSum(nums,target-nums[i],i,temp,ans);
                temp.remove((Object)nums[i]);
            }
        }
        
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findSum(nums,target,0,new ArrayList<>(), ans);
        return ans;
    }
}
