package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: maxDepthTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-03 3:57 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MaxDepthTest {

    public int maxDepth(TreeNode root) {
        // 运用递归关系， 相当于 跟节点 -> 左子节点 -> 右子节点
        // 相当于 二叉树的前序遍历
        if (root != null){
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return 0;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(maxDepth(root));
    }

}
