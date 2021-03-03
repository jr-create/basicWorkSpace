package Dynamic_add.Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
        //����Ŀ�귽��
        res = method.invoke(target, args);//ִ��Ŀ�귽��

        //��Ҫ����2�Ľ��
        if (res != null) {//�൱�ڲ���Ĺ��ܣ���¼���ݿ�...�ȵȣ�
            Integer num = (Integer) res;
            res = num*2;
        }
        return res;
    }
}
