package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-12 5:49 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class UserPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService)bean;
            userService.setLocation("Shanghai China");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
