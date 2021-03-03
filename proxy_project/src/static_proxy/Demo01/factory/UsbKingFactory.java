package static_proxy.Demo01.factory;

import static_proxy.Demo01.service.UsbSell;

//目标类：金士顿厂家,不接受单独购买
public class UsbKingFactory implements UsbSell {

    @Override

    public float sell(int amount) {
        System.out.println("目标类中的方法调用，UsbKingFactory.sell()");
        //一个128G的U盘是85元

        return 85.0f;
    }
}
