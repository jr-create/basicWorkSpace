package static_proxy.Demo01.factory;

import static_proxy.Demo01.service.UsbSell;

//Ŀ���ࣺ��ʿ�ٳ���,�����ܵ�������
public class UsbKingFactory implements UsbSell {

    @Override

    public float sell(int amount) {
        System.out.println("Ŀ�����еķ������ã�UsbKingFactory.sell()");
        //һ��128G��U����85Ԫ

        return 85.0f;
    }
}
