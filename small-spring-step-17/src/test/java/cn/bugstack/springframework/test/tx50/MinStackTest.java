package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: MinStackTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-05 10:52 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MinStackTest {

    // 数组栈, [当前值, 当前最小值]
    private Stack<int[]> stack = new Stack<>();

    public MinStackTest() {
    }

    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(new int[]{val, val});
        }else {
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    @Test
    public void test(){
        MinStackTest minStack = new MinStackTest();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }



}
