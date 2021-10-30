package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-27 3:35 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class FindTrueIndex {

    public int searchInsert(int[] nums, int target) {
        // 采用二分查找的方法进行查询
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 查询开始位置
        int start = 0;
        // 查询结束位置
        int end = nums.length - 1;
        return findInsert(nums, start, end, target);
    }

    // 二分查找
    private int findInsert(int[] nums, int start, int end, int target) {
        while (start <= end){
            int index = (start + end) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (start == end){
                if (nums[start] >= target){
                    return start;
                }else {
                    return end + 1;
                }
            }
            else if (nums[index] > target) {
                if (end - start == 1){
                    return start;
                }
                end = index - 1;
            } else if (nums[index] < target) {
                if (end - start == 1){
                    if (target > nums[end]){
                        return end + 1;
                    }else if (target < nums[start]){
                        return end;
                    }
                }
                start = index + 1;
            }
        }
        return end;
    }

    @Test
    public void find() {
        int[] nums = {3,5,7,9,10};
        int target = 8;

        System.out.println(searchInsert(nums, target));
    }


}
