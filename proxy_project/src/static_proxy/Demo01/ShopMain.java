package static_proxy.Demo01;

import static_proxy.Demo01.factory.UsbKingFactory;
import static_proxy.Demo01.proxy.Taobao;
import static_proxy.Demo01.proxy.weixin;
import static_proxy.Demo01.service.UsbSell;

public class ShopMain {
    public static void main(String[] args) {
        //创建代理的商家Taobao对象
        UsbSell Taobao = new Taobao();
        UsbSell weishang = new weixin();
        UsbSell factory = new UsbKingFactory();
//        float price = Taobao.sell(1);
//        System.out.println("通过taobao的商家购买的单价"+price);
        float price = weishang.sell(1);
        System.out.println("通过weishang购买的单价"+price);
    }
}
