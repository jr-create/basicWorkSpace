package static_proxy.Demo01.proxy;

import static_proxy.Demo01.factory.UsbSanFactory;
import static_proxy.Demo01.service.UsbSell;

/**
 * �̼ң�����U�̵�����
 *
 */
public class weixinSanDi implements UsbSell {
    //�����̼Ҵ���ĳ���
    private UsbSell factory = new UsbSanFactory();
    @Override
    //ʵ������U�̵Ĺ���
    public float sell(int amount) {
        //�򳧼ҷ��Ͷ���
        float price = factory.sell(amount);//���ҵļ۸�
        //�̼Ҽ۸�
        price = price+10;//��ǿ���ܣ������������Ŀ���෽�����ú���ǿ�˹���
        //���Ӻ�ļ۸�
        return price;
    }

}
