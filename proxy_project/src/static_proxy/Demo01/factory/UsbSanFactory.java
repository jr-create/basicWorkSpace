package static_proxy.Demo01.factory;

import static_proxy.Demo01.service.UsbSell;

//Ŀ���ࣺ���ϳ���,�����ܵ�������
public class UsbSanFactory implements UsbSell {

    @Override

    public float sell(int amount) {
        System.out.println("Ŀ�����еķ������ã�UsbSanFactory.sell()");
        //һ��128G��U����83Ԫ

        return 83.0f;
    }
}
