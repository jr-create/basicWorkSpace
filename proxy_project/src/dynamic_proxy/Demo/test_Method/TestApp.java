package dynamic_proxy.Demo.test_Method;

import dynamic_proxy.Demo.test_Method.service.HelloService;
import dynamic_proxy.Demo.test_Method.service.impl.HelloServiceImpl;
import dynamic_proxy.Demo.test_Method.service.impl.HelloServiceImpl2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        HelloService service = new HelloServiceImpl();
//        service.sayHello("张三");

        //使用反射机制执行sayHello方法。核心Method（类中的方法）
        HelloService target = new HelloServiceImpl();
        HelloService target2 = new HelloServiceImpl2();
        //获取sayHello名称对应的Method类对象
        Method method = HelloService.class.getMethod("sayHello", String.class);
        //通过Method可以执行sayHello方法的调用
        /**
         * invoke()是Method类中的方法，表示执行方法的调用
         * 参数
         *  1、Object，表示对象的， 要执行这个对象的方法
         *  2、Object... args（可变），表示方法执行时参数值
         *  返回值：
         *      Object方法执行后的返回值
         */
        Object obj1 = method.invoke(target,"李四");//执行target对象的sayHello方法，参数是李四
        Object obj2 = method.invoke(target2,"王五");
    }
}
