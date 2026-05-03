class Solution {

    public int binarySearch(int[][] intervals, int target){
        int start = 0;
        int end = intervals.length;
        int ans = -1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(target==intervals[mid][0])return mid;
            else if(target>intervals[mid][0]){
                start=mid+1;
                ans= mid;
            }
            else end = mid;
        }
        return ans;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        int start = binarySearch(intervals,newInterval[0]);
        int end = binarySearch(intervals,newInterval[1]);
        System.out.println(start + " " + end);
        for(int i=0;i<start;i++){
            result.add(intervals[i]);
        }
        int[] temp = new int[2];

        if(start==-1){
            temp[0] = newInterval[0];
        }
        else if(intervals[start][1]<newInterval[0]){
            result.add(intervals[start]);
            temp[0] = newInterval[0];
        }
        else{
            temp[0] = Math.min(intervals[start][0],newInterval[0]);
        }

        if(end==-1){
            temp[1] = newInterval[1];
        }
        else{
            temp[1] = Math.max(intervals[end][1],newInterval[1]);
        }
        result.add(temp);

        for(int i=end+1;i<n;i++){
            result.add(intervals[i]);
        }

        int[][] ans = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }

        return ans;

    }
}
