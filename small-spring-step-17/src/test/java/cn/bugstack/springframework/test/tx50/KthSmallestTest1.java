package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: KthSmallestTest1
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-08 3:33 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class KthSmallestTest1 {

    private List<TreeNode> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        getIndex(root);
        if (list != null && list.size() != 0 && list.size() >= k){
            return list.get(k-1).val;
        }
        return 0;
    }

    private void getIndex(TreeNode node) {
        if (node.left != null){
            getIndex(node.left);
        }
        if (node != null){
             list.add(node);
        }
        if (node.right != null){
            getIndex(node.right);
        }
    }


    @Test
    public void test() {
//        TreeNode node = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));

        System.out.println(kthSmallest(node, 4));
    }


}
