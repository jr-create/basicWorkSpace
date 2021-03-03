package static_proxy.Demo01.proxy;

import static_proxy.Demo01.factory.UsbSanFactory;
import static_proxy.Demo01.service.UsbSell;

/**
 * �̼ң�����U�̵�����
 *
 */
public class TaobaoSanDi implements UsbSell {
    //�������ϴ����ĳ���
    private UsbSell factory = new UsbSanFactory();
    @Override
    //ʵ������U�̵Ĺ���
    public float sell(int amount) {
        //�򳧼ҷ��Ͷ���
        float price = factory.sell(amount);//���ҵļ۸�
        //�̼Ҽ۸�
        price = price+20;//��ǿ���ܣ������������Ŀ���෽�����ú���ǿ�˹���
//        ��Ŀ�귽�����ú��������������ܣ�������ǿ����
        System.out.println("�Ա��̼ң����㷵��һ���Ż�ȯ�����ߺ��");
        //���Ӻ�ļ۸�
        return price;
    }
}