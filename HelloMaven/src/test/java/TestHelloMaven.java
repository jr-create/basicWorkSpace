import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {
    @Test
    public void testAdd(){
        System.out.println("=== Maven test ===");
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.Add(10,20);
        //��֤junit�ṩ�ķ���
        //assertEquals(����ֵ��ʵ��ֵ) �����ȷ    �������쳣
        Assert.assertEquals(30,res);


    }
    @Test
    public void testAdd2(){
        System.out.println("@@@ Maven test @@@");
        HelloMaven helloMaven = new HelloMaven();
        int res2 = helloMaven.Add(10,40);
        //��֤junit�ṩ�ķ���
        //assertEquals(����ֵ��ʵ��ֵ) �����ȷ    �������쳣
        Assert.assertEquals(50,res2);

    }
}
