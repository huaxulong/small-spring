package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-02 4:08 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class IsValidBracketsTest {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isValidChar(chars[i])){
                if (isInChar(chars[i])){
                    // 是 左符号
                    stack.push(chars[i]);
                }else {
                    // 是右符号
                    if (stack.size() < 1){
                        return false;
                    }else {
                        // 匹配
                        char ch = stack.pop();
                        if (!isMatcher(ch, chars[i])){
                            return false;
                        }
                    }
                }
            }
        }
        if (stack.size() == 0){
            return true;
        }
        return false;
    }

    private boolean isInChar(char character) {
        if (character == '{' || character == '('|| character == '['){
            return true;
        }else {
            return false;
        }
    }

    private boolean isValidChar(char character) {
        if (character == '{' || character == '}' || character == '(' || character == ')' || character == '[' || character == ']'){
            return true;
        }else {
            return false;
        }
    }

    private boolean isMatcher(char source , char target) {
        if ((source == '{' && target == '}') || (source == '(' && target == ')') || (source == '[' && target == ']')){
            return true;
        }
        return false;
    }


    @Test
    public void test1() {
        String str = "([)]";
        System.out.println(isValid(str));
    }

    @Test
    public void test() {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');

        System.out.println(stack.peek());

        System.out.println(stack);

    }

}
