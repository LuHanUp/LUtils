import com.luhan.utils.DataUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DataUtils测试类
 *
 * @author luHan
 * @create 2023/1/5 18:11
 * @since 1.0.0
 */
public class DataUtilsTest {

    @Test
    public void testIntersectionList() {
        System.out.println("lists为null的结果:" + DataUtil.intersection(null));
        System.out.println("lists为空集合的结果:" + DataUtil.intersection(new ArrayList<>()));
        System.out.println("lists其中有空集合的结果:" + DataUtil.intersection(Collections.singletonList(1), new ArrayList<>()));
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(6);
        list2.add(4);
        list2.add(2);
        list2.add(8);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(8);
        list3.add(4);
        list3.add(3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(9);
        list4.add(0);
        list4.add(4);
        list4.add(2);
        System.out.println("lists取交集:" + DataUtil.intersection(list1, list2, list3, list4));
    }
}
