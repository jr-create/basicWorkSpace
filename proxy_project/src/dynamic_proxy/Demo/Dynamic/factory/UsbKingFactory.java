package dynamic_proxy.Demo.Dynamic.factory;


import dynamic_proxy.Demo.Dynamic.service.UsbSell;

//目标类：金士顿厂家,不接受单独购买
public class UsbKingFactory implements UsbSell {

    @Override

    public float sell(int amount) {
        System.out.println("目标类中的方法调用，UsbKingFactory.sell()");
        //一个128G的U盘是85元

        return 85.0f*amount;
    }

    @Override
    public String print(String string) {
        return null;
    }
}
