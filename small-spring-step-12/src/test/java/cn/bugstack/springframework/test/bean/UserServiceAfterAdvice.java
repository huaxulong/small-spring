package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.aop.MethodAfterAdvice;

import java.lang.reflect.Method;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-14 5:16 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class UserServiceAfterAdvice implements MethodAfterAdvice {

    @Override
    public void after(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置拦截方法：" + method.getName());
    }
}
