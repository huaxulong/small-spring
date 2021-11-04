package cn.bugstack.springframework.test.tx50;

/**
 * @description: TreeNode
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-03 3:56 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
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
