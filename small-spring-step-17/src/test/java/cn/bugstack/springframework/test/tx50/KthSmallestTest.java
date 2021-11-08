package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-08 1:54 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class KthSmallestTest {

    /**
     * 因为是二叉搜索树， 所以此方法，要先遍历 左 -> 中 -> 右  就会按照
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        getIndex(root);

        return target;
    }

    private int count = 0;

    private int index = 0;

    private int target = 0;

    private void getIndex(TreeNode root) {
        if (root.left != null) {
            getIndex(root.left);
        }
        if (root != null){
            index ++;
            if (index == count){
                target = root.val;
            }
        }
        if (root.right != null){
            getIndex(root.right);
        }
    }

    @Test
    public void test() {
//        TreeNode node = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));

        System.out.println(kthSmallest(node, 7));
    }

}
