package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 1:44 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class FindKthLargestTest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        if (k <= nums.length){
            return nums[nums.length - k];
        }else {
            return 0;
        }
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }

}
