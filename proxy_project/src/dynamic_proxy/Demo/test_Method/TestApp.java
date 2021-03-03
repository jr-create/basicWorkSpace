package dynamic_proxy.Demo.test_Method;

import dynamic_proxy.Demo.test_Method.service.HelloService;
import dynamic_proxy.Demo.test_Method.service.impl.HelloServiceImpl;
import dynamic_proxy.Demo.test_Method.service.impl.HelloServiceImpl2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        HelloService service = new HelloServiceImpl();
//        service.sayHello("����");

        //ʹ�÷������ִ��sayHello����������Method�����еķ�����
        HelloService target = new HelloServiceImpl();
        HelloService target2 = new HelloServiceImpl2();
        //��ȡsayHello���ƶ�Ӧ��Method�����
        Method method = HelloService.class.getMethod("sayHello", String.class);
        //ͨ��Method����ִ��sayHello�����ĵ���
        /**
         * invoke()��Method���еķ�������ʾִ�з����ĵ���
         * ����
         *  1��Object����ʾ����ģ� Ҫִ���������ķ���
         *  2��Object... args���ɱ䣩����ʾ����ִ��ʱ����ֵ
         *  ����ֵ��
         *      Object����ִ�к�ķ���ֵ
         */
        Object obj1 = method.invoke(target,"����");//ִ��target�����sayHello����������������
        Object obj2 = method.invoke(target2,"����");
    }
}
