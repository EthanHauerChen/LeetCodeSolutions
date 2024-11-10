//https://leetcode.com/problems/clone-graph/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Integer> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Integer>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Integer>();
    }
    public Node(int _val, ArrayList<Integer> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        /*DFS
        Map<Integer, Node> visited = new HashMap<>();
        return cloneGraphDFS(node, visited);
        */

        /*BFS with queue */
        Map<Integer, Node> visited = new HashMap<>();
        return cloneGraphBFS(node, visited);
    }

    /*DFS recursive
    public Node cloneGraphDFS(Node node, Map<Integer, Node> visited) {
        if (node == null) return node;
        Node copy = new Node(node.val);
        visited.put(node.val, copy);
        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.val)) copy.neighbors.add(cloneGraphDFS(neighbor, visited));
            else copy.neighbors.add(visited.get(neighbor.val));
        }

        return copy;
    }
    */
    
    /* BFS with queue*/
    public Node cloneGraphBFS(Node node, Map<Integer, Node> visited) {
        if (node == null) return node;
        Queue<Node> neighbors = new LinkedList<Node>();
        neighbors.add(node);

        while(neighbors.size() != 0) {
            Node current = neighbors.poll();
            Node copy = visited.containsKey(current.val) ? visited.get(current.val) : new Node(current.val);
            visited.put(copy.val, copy);
            //find all neighbors and add copies of those neighbors to the copy Node's neighbor list
            //and add unvisited neighbors to the queue
            for (Node n : current.neighbors) {
                if (visited.containsKey(n.val)) {
                    copy.neighbors.add(visited.get(n.val));
                }
                else {
                    //create copy of neighbor node and add it to copy's neighbor list
                    Node neighbor = new Node(n.val);
                    copy.neighbors.add(neighbor); 
                    //add copy of neighbor node to visited map
                    visited.put(neighbor.val, neighbor);
                    //add neighbor node to queue
                    neighbors.add(n);
                }
            }

            
        }

        return visited.get(1);
    }
    
}