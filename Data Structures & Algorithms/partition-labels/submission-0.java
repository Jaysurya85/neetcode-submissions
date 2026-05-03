class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int[] lastScene = new int[26];
        Arrays.fill(lastScene,-1);

        for(int i=n-1;i>=0;i--){
            if(lastScene[s.charAt(i)-'a']==-1)lastScene[s.charAt(i)-'a']=i;
        }

        int start = 0;

        while(start<n){
            if(lastScene[s.charAt(start)-'a']==-1){
                ans.add(1);
                start++;
                continue;
            }
            int current = start;
            int end = lastScene[s.charAt(start)-'a']; 
            while(current<end){
                end = Math.max(end,lastScene[s.charAt(current)-'a']);
                current++;
            }
            ans.add(end-start+1);
            start = end+1;
        }
        return ans;


    }
}
