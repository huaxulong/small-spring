package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: lowestCommonAncestor
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 5:40 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class NoLowestCommonAncestorTest {

    /**
     * 上一个题是二叉搜索树 ， 这个题则不是一个有序的treeNode 结构
     * 利用回溯找到 搜索路径
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    @Test
    public void test() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        TreeNode node = lowestCommonAncestor(node3, node5, node1);

        System.out.println(node);


        //lowestCommonAncestor(node3, node5, node1);

    }

}
