class Solution {
    public boolean traverse(int current, HashMap<Integer,List<Integer>> map, int parent, boolean[] visited){
        if(visited[current])return false;
        visited[current] = true;
        boolean possible = true;
        for(Integer child: map.get(current)){
            if(child==parent)continue;
            possible &=traverse(child,map,current,visited);
        }
        return possible;
    }

    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        boolean possible = traverse(0, map, -1,visited);
        for(int i=0;i<n;i++){
           if(!visited[i]) return false;
        }
        return true&possible;
    }
}
