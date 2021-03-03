package dynamic_proxy.Demo.Dynamic;

import dynamic_proxy.Demo.Dynamic.Handler.MySellHandler;
import dynamic_proxy.Demo.Dynamic.factory.UsbKingFactory;
import dynamic_proxy.Demo.Dynamic.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyShopMain {
    public static void main(String[] args) {
        //�����������ʹ��Proxy
        //1������Ŀ�����
        UsbSell factory = new UsbKingFactory();
        //2������InvocationHandler����
        InvocationHandler handler = new MySellHandler(factory);
        //3�������������
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);
        //proxycom.sun.proxy.$Proxy0:����jdk��̬�������Ķ�������
        System.out.println("proxy"+proxy.getClass().getName());
        //4��ͨ������ִ�з���
        float price = proxy.sell(2);
        System.out.println("ͨ����̬������󣬵��÷�����"+price);

    }
}
