package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-03 4:41 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class TreeSkipTest {

    private void preorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        if (root != null){
            System.out.println(root.val);
        }
        if (root.left != null){
            preorderTraversal(root.left);
        }
        if (root.right != null){
            preorderTraversal(root.right);
        }
    }

    private void afterOrderTraversal(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left != null){
            afterOrderTraversal(root.left);
        }
        if (root.right != null){
            afterOrderTraversal(root.right);
        }
        if (root != null){
            System.out.println(root.val);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

//        preorderTraversal(root);
        afterOrderTraversal(root);

    }

}
