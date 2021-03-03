package Dynamic_add.Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 必须实现InvocationHandler接口，完成代理类要做的功能
 * 1、调用目标方法
 * 2、功能增强
 */
public class MySellHandler implements InvocationHandler {

    private Object target = null;
    //动态代理：目标对象是活动的，不是固定的，需要传入进来。
    //传入什么，让什么代理。
    public MySellHandler(Object target) {
//        目标对象赋值
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        //调用目标方法
        res = method.invoke(target, args);//执行目标方法

        //需要乘以2的结果
        if (res != null) {//相当于补充的功能（记录数据库...等等）
            Integer num = (Integer) res;
            res = num*2;
        }
        return res;
    }
}
