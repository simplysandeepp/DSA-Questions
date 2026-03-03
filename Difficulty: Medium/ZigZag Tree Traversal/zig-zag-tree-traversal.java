class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] level = new Integer[size];

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                int index = leftToRight ? i : size - 1 - i;
                level[index] = current.data;

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            for (int val : level) {
                result.add(val);
            }

            leftToRight = !leftToRight;
        }

        return result;
    }
}