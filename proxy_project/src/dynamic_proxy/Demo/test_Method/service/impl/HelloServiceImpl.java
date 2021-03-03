package dynamic_proxy.Demo.test_Method.service.impl;

import dynamic_proxy.Demo.test_Method.service.HelloService;

public class HelloServiceImpl implements HelloService {


    @Override
    public void sayHello(String name) {
        System.out.println("HelloServiceImpl");
        System.out.println("ÄãºÃ£º"+name);
    }
}
