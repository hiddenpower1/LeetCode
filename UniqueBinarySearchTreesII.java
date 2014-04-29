import java.util.ArrayList;

import shared.TreeNode;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {

		return generate(1, n);

	}

	private ArrayList<TreeNode> generate(int start, int end) {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();

		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = generate(start, i - 1);
			ArrayList<TreeNode> right = generate(i + 1, end);

			for (int m = 0; m < left.size(); m++) {
				for (int n = 0; n < right.size(); n++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(m);
					root.right = right.get(n);
					result.add(root);
				}
			}

		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
