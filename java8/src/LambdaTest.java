import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8��   �����Ĵ���ĺ����ӿ�
 * consumer<T>:���ѽӿ�
 *      void accept(T t)
 * Supplier<T>:�����ͽӿ�
 *      T get();
 * Function<T>�������ͽӿ�
 *      R apply(T t);
 * Predicate<T>�������ͽӿ�
 *      boolean test(T t);
 */

public class LambdaTest {

    //    Predicate<T>�������ͽӿ�
    //    ����:�����ַ������������������ַ������뼯����ȥ
    @Test
    public void test3() {
        List<String> list = Arrays.asList("Hello", "WjR", "Lambda", "wol", "sdf");
        List<String> list1 = filterStr(list, s -> s.length() > 3);
        list1.forEach(s -> System.out.println(s));


    }

    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> listStr = new ArrayList<>();
        for (String str :
                list) {
            if (predicate.test(str)) {
                listStr.add(str);
            }
        }
        return listStr;

    }

    //    Function<T>�������ͽӿ�
    //    �������ڴ����ַ���
    @Test
    public void test2() {
        String s1 = strHandler("  \t123 123\t\b  ", s -> s.trim());
        System.out.println(s1);

        String s2 = strHandler("  \t123 123\t\b  ", s -> s.substring(2, 5));
        System.out.println("s2" + s2);
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //    Supplier<T>:�����ͽӿ�
    @Test
    public void test1() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        System.out.println("----==============");
        numList.forEach(x -> System.out.println(x));

    }

    //    ���󣺲���ָ�������������������뼯����
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }


    //    consumer<T>:���ѽӿ�
    @Test
    public void test() {
        happy(10000, (m) -> System.out.println("�������Ҫ����" + m + "Ԫ"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

}
