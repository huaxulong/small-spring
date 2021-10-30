package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-30 12:55 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class Convert2AvlTreeTest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }
        // 以升序数组的中间元素作为 根节点 root
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    @Test
    public void test() {
        int nums[] = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);

        System.out.println(treeNode);

    }

    /**
     * BST 中序遍历是升序的，因此本题等同于中序遍历的序列回复二叉搜索树
     */

}
