package dynamic_proxy.Demo.Dynamic.Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ����ʵ��InvocationHandler�ӿڣ���ɴ�����Ҫ���Ĺ���
 * 1������Ŀ�귽��
 * 2��������ǿ
 */
public class MySellHandler implements InvocationHandler {

    private Object target = null;
    //��̬����Ŀ������ǻ�ģ����ǹ̶��ģ���Ҫ���������
    //����ʲô����ʲô����
    public MySellHandler(Object target) {
//        Ŀ�����ֵ
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;

        //�򳧼ҷ��Ͷ���
//        float price = factory.sell(amount);//���ҵļ۸�
        res = method.invoke(target, args);//ִ��Ŀ�귽��

        //�̼Ҽ۸�
//        price = price + 20;//��ǿ���ܣ������������Ŀ���෽�����ú���ǿ�˹���
        if (res != null) {
            Float price = (Float) res;

            price = price + 20*(int) args[0] ;//(int) args[0]����
            res = price;
        }

//        ��Ŀ�귽�����ú��������������ܣ�������ǿ����
        System.out.println("�Ա��̼ң����㷵��һ���Ż�ȯ�����ߺ��");
        //���Ӻ�ļ۸�
        return res;
    }
}
