package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-04 1:46 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MaxAreaTest {

    public int maxArea(int[] height) {
        /*  使用 O(N2) 的时间复杂度， 空间复杂度： 0(1)
        int capacity = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j <height.length; j++) {
                int length = j - i;
                int width = Math.min(height[i], height[j]);
                capacity = Math.max(capacity, length * width);
            }
        }
        return capacity;*/
        int left = 0;
        int right = height.length - 1;
        int capacity = 0;
        while (left < right) {
            capacity = Math.max(capacity, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return capacity;
    }

    @Test
    public void test() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {1, 8};
        System.out.println(maxArea(height));
    }

}
