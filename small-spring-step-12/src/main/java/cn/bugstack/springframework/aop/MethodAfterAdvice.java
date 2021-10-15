package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-14 5:10 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public interface MethodAfterAdvice extends AfterAdvice{

    /**
     *
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    void after(Method method, Object[] args, Object target) throws Throwable;

}
