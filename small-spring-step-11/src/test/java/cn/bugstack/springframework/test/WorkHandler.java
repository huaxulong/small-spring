package cn.bugstack.springframework.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-13 4:50 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class WorkHandler implements InvocationHandler {

    //代理类中的真实对象
    private Object obj;

    public WorkHandler() {
        // TODO Auto-generated constructor stub
    }
    //构造函数，给我们的真实对象赋值
    public WorkHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知");
        Object invoke = method.invoke(obj, args);
        System.out.println("后置通知");
        return invoke;
    }
}
