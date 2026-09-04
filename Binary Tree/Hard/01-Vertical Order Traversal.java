 import java.util.*;
class Solution {
    static class Tuple {
        TreeNode node;
        int x; // Vertical distance
        int y; // Level

        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // TreeMap to store the nodes at each vertical distance
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();

        // Queue for BFS traversal (stores node along with its x and y coordinates)
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); // (node, x, y)

        // Perform BFS
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            // Add the node's value to the map at the correct x and y
            nodesMap.putIfAbsent(x, new TreeMap<>());
            nodesMap.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodesMap.get(x).get(y).offer(node.val);

            // Add the left child with updated coordinates to the queue
            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            // Add the right child with updated coordinates to the queue
            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Prepare the result by sorting keys and compiling nodes
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : nodesMap.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            result.add(column);
        }

        return result;
    }
}

// Time Complexity:O(N * log2N * log2N * log2N) : This complexity arises from performing postorder traversal using BFS, where each node's insertion and retrieval operations in nested maps take logarithmic time. Overall, it reflects the combined cost of processing each node and managing the node mappings.

// Space Complexity: O(N + N/2) : The space usage is dominated by the map storing nodes by their vertical and level information, occupying O(N) space. Additionally, the queue for BFS can occupy up to O(N/2) space in a balanced tree's worst-case scenario, contributing to the total space complexity.
