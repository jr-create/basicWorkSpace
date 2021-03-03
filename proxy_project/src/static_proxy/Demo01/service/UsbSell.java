package static_proxy.Demo01.service;

/**
 * 表示功能的厂家，商家都要完成的功能
 */
public interface UsbSell {
    //定义方法 参数amount表示一次购买的数量
    //返回值的价格
    float sell(int amount);
}
