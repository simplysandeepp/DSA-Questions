class Solution {
    public int amountOfTime(TreeNode root, int start) {
        
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = buildParentMap(root, null, map, start);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode parent = map.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
        }
        return distance;
    }

    public TreeNode buildParentMap(TreeNode node, TreeNode parent,
                                   HashMap<TreeNode, TreeNode> map, int start) {
        if (node == null) return null;

        map.put(node, parent);

        if (node.val == start) return node;

        TreeNode left = buildParentMap(node.left, node, map, start);
        if (left != null) return left;

        return buildParentMap(node.right, node, map, start);
    }
}