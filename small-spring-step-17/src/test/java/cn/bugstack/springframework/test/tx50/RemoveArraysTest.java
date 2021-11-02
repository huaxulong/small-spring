package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-01 8:14 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class RemoveArraysTest {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[j] != nums[i]){
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    @Test
    public void test() {
        int[] nums = {};

    }

}
