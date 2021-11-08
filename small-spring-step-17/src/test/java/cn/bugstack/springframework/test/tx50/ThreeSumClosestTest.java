package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: threeSumClosest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-05 3:31 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class ThreeSumClosestTest {


    /**
     * 利用 排序 + 双指针的 算法， 此题类似于乘最多水的容器
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // 先固定一个数
        int result = 0;
        // 最小的差值
        int difference = Integer.MAX_VALUE;

        int x = 0 , y = 0 , z = 0;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end){
                int temp = Math.abs(target - a - nums[start] - nums[end]);
                if (temp < difference){
                    x = a;
                    y = nums[start];
                    z = nums[end];
                    difference = temp;
                }
                if (nums[start] + nums[end] > target - a){
                    end --;
                }else {
                    start ++;
                }
            }
        }

        return x + y + z;
    }

    @Test
    public void test() {
        int[] nums = {-1,2,1,-4};
        int target = 1;

        System.out.println(threeSumClosest(nums, target));

    }

}
