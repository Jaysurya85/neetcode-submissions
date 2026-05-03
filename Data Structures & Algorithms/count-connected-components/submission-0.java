class Solution {

    public void makeAllVisited(HashMap<Integer,List<Integer>> map, int current, boolean[] visited){
        if(visited[current])return;

        visited[current]=true;
        for(Integer child: map.get(current)){
            makeAllVisited(map,child,visited);
        }

    }

    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int ans =0;

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0;i<n;i++){
            if(visited[i])continue;
            ans++;
            makeAllVisited(map,i,visited);
        }
        return ans;
    }
}
