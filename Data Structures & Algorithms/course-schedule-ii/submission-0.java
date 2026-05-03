class Solution {
     public boolean finish(int current, HashMap<Integer,List<Integer>> map, boolean[] done, boolean[] visited, List<Integer> ans){
        if(done[current])return true;
        if(visited[current])return false;

        if(!map.containsKey(current)){
            ans.add(current);
            done[current]=true;
            return true;
        }
        visited[current] =true;

        for(Integer course: map.get(current)){
            boolean possible = finish(course,map,done,visited, ans);
            if(!possible)return false;
        }
        ans.add(current);
        done[current]=true;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            map.putIfAbsent(first, new ArrayList<>());
            map.get(first).add(second);
        }

        boolean[] done = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean possible = true;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            possible &= finish(i,map,done,visited, ans);
        }
        if(possible){
            int[] result = new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                result[i] = ans.get(i);
            }
            return result;
        }
        return new int[0];
    }
}
