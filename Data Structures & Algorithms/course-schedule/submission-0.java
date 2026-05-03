class Solution {

    public boolean finish(int current, HashMap<Integer,List<Integer>> map, boolean[] done, boolean[] visited){
        if(done[current])return true;
        if(visited[current])return false;

        if(!map.containsKey(current)){
            done[current]=true;
            return true;
        }
        visited[current] =true;

        for(Integer course: map.get(current)){
            boolean possible = finish(course,map,done,visited);
            if(!possible)return false;
        }
        done[current]=true;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        for(int i=0;i<numCourses;i++){
            possible &= finish(i,map,done,visited);
        }
        return possible;

    }
}
