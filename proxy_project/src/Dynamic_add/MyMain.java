package Dynamic_add;

import Dynamic_add.Handler.MySellHandler;
import Dynamic_add.gongNeng.GongNeng;
import Dynamic_add.service.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyMain {
    public static void main(String[] args) {
        HelloService gn = new GongNeng();
        InvocationHandler handler = new MySellHandler(gn);

        HelloService proxy = (HelloService) Proxy.newProxyInstance(gn.getClass().getClassLoader(),
                gn.getClass().getInterfaces(),
                handler);

        int num = proxy.print("�г�");
        System.out.println(" ���������Ľ����"+num);

    }
}
