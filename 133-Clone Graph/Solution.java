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
        Node copy = new Node(node.val);
        visited.put(node.val, copy);
        Queue<Node> neighbors = new LinkedList<Node>();
        for (Node neighbor : node.neighbors) { neighbors.add(neighbor); } //initialize with node 1's neighbors so that the while loop will actually run

        Node current = neighbors.poll();
        while (current != null /*while not empty*/) {
            if (visited.containsKey(current.val))
                copy.neighbors.add(visited.get(current.val));
            else {
                Node temp = new Node(current.val); //not really temporary, but idk what to call it
                copy.neighbors.add(temp);
                visited.put(temp.val, temp);
                for (Node n : current.neighbors) if (!visited.containsKey(n.val)) neighbors.add(n);
            }

            current = neighbors.poll();
            if (current != null)
                copy = visited.containsKey(current.val) ? visited.get(current.val) : new Node(current.val);
        }

        return visited.get(1);
    }
    
}