package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: lowestCommonAncestor
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 4:54 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class LowestCommonAncestorTest {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 左子树 -> 右子树 -> 根节点
         */
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);

        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != null && node.val != target.val) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    @Test
    public void test(){

        TreeNode node = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        TreeNode treeNode = lowestCommonAncestor(node, p, q);

        System.out.println(treeNode.val);
    }

}
