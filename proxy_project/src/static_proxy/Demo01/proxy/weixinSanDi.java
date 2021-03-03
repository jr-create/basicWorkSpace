package static_proxy.Demo01.proxy;

import static_proxy.Demo01.factory.UsbSanFactory;
import static_proxy.Demo01.service.UsbSell;

/**
 * 商家，代理U盘的销售
 *
 */
public class weixinSanDi implements UsbSell {
    //声明商家代理的厂家
    private UsbSell factory = new UsbSanFactory();
    @Override
    //实现销售U盘的功能
    public float sell(int amount) {
        //向厂家发送订单
        float price = factory.sell(amount);//厂家的价格
        //商家价格
        price = price+10;//增强功能，代理类在完成目标类方法调用后，增强了功能
        //增加后的价格
        return price;
    }

}
