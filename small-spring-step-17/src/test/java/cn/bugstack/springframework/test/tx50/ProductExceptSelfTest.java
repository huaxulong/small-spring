package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 3:57 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class ProductExceptSelfTest {

    /**
     * 因为不能使用除法， 所以采用 元素 = 前缀之积 * 后缀之积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        // 获取前缀之积
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i-1] * answer[i-1];
        }

        // 获取后缀之积
        int k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * k;
            k = k * nums[i];
        }
        return answer;
    }

    @Test
    public void test() {
        //int[] nums = {1, 2, 3, 4};
        int[] nums = {2, 4, 1, 3, 5};
        int[] ints = productExceptSelf(nums);

        for (int anInt : ints) {
            System.out.println(anInt + "\t");
        }
    }


}
