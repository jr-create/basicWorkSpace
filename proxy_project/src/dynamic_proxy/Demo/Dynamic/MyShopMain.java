package dynamic_proxy.Demo.Dynamic;

import dynamic_proxy.Demo.Dynamic.Handler.MySellHandler;
import dynamic_proxy.Demo.Dynamic.factory.UsbKingFactory;
import dynamic_proxy.Demo.Dynamic.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyShopMain {
    public static void main(String[] args) {
        //创建代理对象，使用Proxy
        //1、创建目标对象
        UsbSell factory = new UsbKingFactory();
        //2、创建InvocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);
        //3、创建代理对象
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);
        //proxycom.sun.proxy.$Proxy0:这是jdk动态代理创建的对象类型
        System.out.println("proxy"+proxy.getClass().getName());
        //4、通过代理执行方法
        float price = proxy.sell(2);
        System.out.println("通过动态代理对象，调用方法："+price);

    }
}
