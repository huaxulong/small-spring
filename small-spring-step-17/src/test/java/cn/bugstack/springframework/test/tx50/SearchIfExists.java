package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-01 5:44 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class SearchIfExists {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 首先找到旋转点
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        // 说明没有经过翻转， 获取翻转的位置是 length -1
        if (index == -1) {
            return searchIndex(nums, 0, nums.length - 1, target);
        }

        // 而后继续二分查找
        if (target >= nums[0] && target <= nums[index]) {
            return searchIndex(nums, 0, index, target);
        } else if (target >= nums[index + 1] && target <= nums[nums.length - 1]) {
            return searchIndex(nums, index + 1, nums.length - 1, target);
        }
        return -1;
    }

    private int searchIndex(int[] nums, int begin, int end, int target) {
        while (end >= begin) {
            int index = (begin + end) / 2;
            if (target == nums[index]) {
                return index;
            }
            if (target > nums[index]) {
                if (index > nums.length - 2 || target < nums[index + 1]) {
                    return -1;
                }
                begin = index + 1;
            } else {
                if (index < 1 || target > nums[index - 1]) {
                    return -1;
                }
                end = index - 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(search(nums, 2));
    }

    @Test
    public void test2() {
        int[] nums = {3, 5};
        System.out.println(searchIndex(nums, 0, nums.length - 1, 3));
    }

}
