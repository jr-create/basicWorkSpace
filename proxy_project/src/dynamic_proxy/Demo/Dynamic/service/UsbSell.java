package dynamic_proxy.Demo.Dynamic.service;

/**
 * ��ʾ���ܵĳ��ң��̼Ҷ�Ҫ��ɵĹ���
 */
public interface UsbSell {
    //���巽�� ����amount��ʾһ�ι��������
    //����ֵ�ļ۸�
    float sell(int amount);
    String print(String string);//������ֻ��Ҫ��factory�м��룬Ӱ��С
}
