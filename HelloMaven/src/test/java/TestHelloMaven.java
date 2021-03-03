import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {
    @Test
    public void testAdd(){
        System.out.println("=== Maven test ===");
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.Add(10,20);
        //验证junit提供的方法
        //assertEquals(期望值，实际值) 相等正确    不等则异常
        Assert.assertEquals(30,res);


    }
    @Test
    public void testAdd2(){
        System.out.println("@@@ Maven test @@@");
        HelloMaven helloMaven = new HelloMaven();
        int res2 = helloMaven.Add(10,40);
        //验证junit提供的方法
        //assertEquals(期望值，实际值) 相等正确    不等则异常
        Assert.assertEquals(50,res2);

    }
}
