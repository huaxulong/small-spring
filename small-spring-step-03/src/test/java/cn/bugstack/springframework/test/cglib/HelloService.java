package cn.bugstack.springframework.test.cglib;

/**
 * @description: HelloService
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-11 3:00 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class HelloService {

    public HelloService() {
        System.out.println("HelloService构造");
    }

    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>"+name);
        return null;
    }

    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }

}
