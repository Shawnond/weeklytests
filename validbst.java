import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.val = value;
    }
}

public class validbst {
    public static String isValid(int[] nodes){
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] < root) {
                return "NO";
            }
            while (!stack.isEmpty() && nodes[i] > stack.peek()) {
                root = stack.pop();
            }
            stack.push(nodes[i]);
        }
        return "YES";
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 3, 2},
            {2, 1, 3},
            {3, 2, 1, 5, 4, 6},
            {1, 3, 4, 2},
            {3, 4, 5, 1, 2}
        };

        for (int[] testCase : testCases) {
            System.out.println(isValid(testCase));
        }
    }
}
