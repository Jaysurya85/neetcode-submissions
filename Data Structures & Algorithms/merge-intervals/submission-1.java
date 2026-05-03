class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> {
            if(a[0]==b[0])return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<n;i++){
            if(end<intervals[i][0]){
                ans.add(new int[]{start,end});
                start = intervals[i][0];
            }
            end = Math.max(intervals[i][1],end);
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
