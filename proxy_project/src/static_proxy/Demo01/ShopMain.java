package static_proxy.Demo01;

import static_proxy.Demo01.factory.UsbKingFactory;
import static_proxy.Demo01.proxy.Taobao;
import static_proxy.Demo01.proxy.weixin;
import static_proxy.Demo01.service.UsbSell;

public class ShopMain {
    public static void main(String[] args) {
        //����������̼�Taobao����
        UsbSell Taobao = new Taobao();
        UsbSell weishang = new weixin();
        UsbSell factory = new UsbKingFactory();
//        float price = Taobao.sell(1);
//        System.out.println("ͨ��taobao���̼ҹ���ĵ���"+price);
        float price = weishang.sell(1);
        System.out.println("ͨ��weishang����ĵ���"+price);
    }
}
