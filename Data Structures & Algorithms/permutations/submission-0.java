class Solution {
    public void makePermute(List<Integer> remaining, List<Integer> temp, List<List<Integer>> ans){
        if(remaining.size()==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<remaining.size();i++){
            int toRemove = remaining.get(0);
            temp.add(toRemove);
            remaining.remove((Object) toRemove);
            makePermute(remaining,temp,ans);
            temp.remove((Object) toRemove);
            remaining.add(toRemove);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> remaining = new ArrayList<>();
        for(int i=0;i<nums.length;i++)remaining.add(nums[i]);
        List<List<Integer>> ans = new ArrayList<>();

        makePermute(remaining, new ArrayList<>(), ans);
        return ans;
        
    }
}
