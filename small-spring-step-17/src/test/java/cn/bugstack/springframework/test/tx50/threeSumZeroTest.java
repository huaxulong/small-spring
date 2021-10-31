package cn.bugstack.springframework.test.tx50;

import cn.hutool.core.collection.CollectionUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 4:12 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class threeSumZeroTest {

    /**
     * 使用双指针的方法，暴力解法 ，
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        // 先排序
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return list;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int one = nums[i];
            // 记录下标 start
            int start = i + 1;
            // 记录下标 end
            int end = nums.length - 1;

            while (end > start){
                int sum = one + nums[start] + nums[end];
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                }else {
                    list.add(Arrays.asList(one, nums[start], nums[end]));

                    while (end > start && nums[end] == nums[end - 1]) end--;
                    while (end > start && nums[start] == nums[start + 1]) start++;
                    start++;
                    end--;
                }

            }
        }

        return list;
    }

    @Test
    public void test() {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> list = threeSum(nums);

        printList(list);
    }

    public void printList(List<List<Integer>> list) {
        if (!CollectionUtil.isEmpty(list)) {
            list.stream().forEach(intList -> {
                intList.stream().forEach(acl -> {
                    System.out.print(acl + "\t");
                });
                System.out.println();
            });
        }
    }

    @Test
    public void test1() {
        System.out.println(new String("-2abdsdfdhsddfgsf").hashCode());
        System.out.println(("2abdsdfdhsddfgsf").hashCode());
        System.out.println(("0abdsdfdhsddfgsf").hashCode());


    }

}
