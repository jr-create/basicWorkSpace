package dynamic_proxy.Demo.Dynamic.factory;


import dynamic_proxy.Demo.Dynamic.service.UsbSell;

//Ŀ���ࣺ��ʿ�ٳ���,�����ܵ�������
public class UsbKingFactory implements UsbSell {

    @Override

    public float sell(int amount) {
        System.out.println("Ŀ�����еķ������ã�UsbKingFactory.sell()");
        //һ��128G��U����85Ԫ

        return 85.0f*amount;
    }

    @Override
    public String print(String string) {
        return null;
    }
}
