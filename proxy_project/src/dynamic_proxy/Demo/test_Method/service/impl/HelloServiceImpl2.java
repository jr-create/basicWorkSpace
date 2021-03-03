package dynamic_proxy.Demo.test_Method.service.impl;

import dynamic_proxy.Demo.test_Method.service.HelloService;

public class HelloServiceImpl2 implements HelloService {


    @Override
    public void sayHello(String name) {
        System.out.println("HelloServiceImpl2");
        System.out.println("ÄãºÃ£º"+name);

    }
}
