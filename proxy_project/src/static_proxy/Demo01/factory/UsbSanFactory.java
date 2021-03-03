package static_proxy.Demo01.factory;

import static_proxy.Demo01.service.UsbSell;

//目标类：闪迪厂家,不接受单独购买
public class UsbSanFactory implements UsbSell {

    @Override

    public float sell(int amount) {
        System.out.println("目标类中的方法调用，UsbSanFactory.sell()");
        //一个128G的U盘是83元

        return 83.0f;
    }
}
