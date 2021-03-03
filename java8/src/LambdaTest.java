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
 * java8中   内置四大核心函数接口
 * consumer<T>:消费接口
 *      void accept(T t)
 * Supplier<T>:供给型接口
 *      T get();
 * Function<T>：函数型接口
 *      R apply(T t);
 * Predicate<T>：断言型接口
 *      boolean test(T t);
 */

public class LambdaTest {

    //    Predicate<T>：断言型接口
    //    需求:处理字符串，将满足条件的字符串放入集合中去
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

    //    Function<T>：函数型接口
    //    需求：用于处理字符串
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

    //    Supplier<T>:供给型接口
    @Test
    public void test1() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        System.out.println("----==============");
        numList.forEach(x -> System.out.println(x));

    }

    //    需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }


    //    consumer<T>:消费接口
    @Test
    public void test() {
        happy(10000, (m) -> System.out.println("大包间需要消费" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

}
