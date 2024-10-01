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
    }

    /*DFS
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

    /* BFS */
    public Node cloneGraphBFS(Node node, Map<Integer, Node> visited) {
        if (node == null) return node;
        Node copy = new Node(node.val);
        visited.put(node.val, copy);
        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.val)) copy.neighbors.add(cloneGraphDFS(neighbor, visited));
            else copy.neighbors.add(visited.get(neighbor.val));
        }

        return copy;
    }
}