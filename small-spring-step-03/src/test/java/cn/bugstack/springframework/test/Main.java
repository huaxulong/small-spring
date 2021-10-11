package cn.bugstack.springframework.test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-11 10:37 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class Main {

    public static void main(String[] args) {
        UserBean userBean = new UserBean();

        userBean.name = "abc";

        System.out.println(userBean.name);
    }

}
