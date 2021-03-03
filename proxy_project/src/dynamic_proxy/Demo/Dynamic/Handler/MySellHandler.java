package dynamic_proxy.Demo.Dynamic.Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

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

        //向厂家发送订单
//        float price = factory.sell(amount);//厂家的价格
        res = method.invoke(target, args);//执行目标方法

        //商家价格
//        price = price + 20;//增强功能，代理类在完成目标类方法调用后，增强了功能
        if (res != null) {
            Float price = (Float) res;

            price = price + 20*(int) args[0] ;//(int) args[0]个数
            res = price;
        }

//        在目标方法调用后，你做的其他功能，都是增强功能
        System.out.println("淘宝商家，给你返回一个优惠券，或者红包");
        //增加后的价格
        return res;
    }
}
