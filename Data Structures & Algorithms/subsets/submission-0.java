class Solution {

    public void makeSubsets(int[] nums, int current, List<Integer> temp, List<List<Integer>> ans){
        if(current==nums.length)return;

        for(int i=current;i<nums.length;i++){
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));

            makeSubsets(nums,i+1,temp,ans);

            temp.remove((Object) nums[i]);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        makeSubsets(nums,0,new ArrayList<>(),ans);
        ans.add(new ArrayList<>());
        return ans;
    }
}
