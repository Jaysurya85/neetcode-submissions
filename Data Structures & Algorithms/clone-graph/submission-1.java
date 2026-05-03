/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> copyMap = new HashMap<>();
        // HashMap<Node, Node> parentMap = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current==null)continue;
            visited.add(current);
            copyMap.put(current,new Node(current.val));
            for(Node children: current.neighbors){
                if(visited.contains(children))continue;
                queue.add(children);
                // parentMap.put(children,current);
            }
        }
        for(Map.Entry<Node, Node> mp: copyMap.entrySet()){
            Node key = mp.getKey();
            Node val = mp.getValue();
            for(Node children: key.neighbors){
                val.neighbors.add(copyMap.get(children));
            }
        }
        return copyMap.get(node);
    }
}