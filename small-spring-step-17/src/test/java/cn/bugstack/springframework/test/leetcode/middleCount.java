package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-21 10:33 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class middleCount {

    @Test
    public void test() {
        int[] a = {};
        int[] b = {2};

        System.out.println(mergeArray(a , b));
    }

    public double mergeArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    /**
     *  合并为 j = ( m + n + 1) / 2 - ij=(m+n+1)/2−i
     *
     *
     *  j = ( m + n ) / 2 - i
     *
     *  j = ( m + n + 1) / 2 - i
     */

}
