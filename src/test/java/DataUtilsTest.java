import com.luhan.utils.DataUtil;
import entity.TestDatePagingEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void testSortByList() {
        List<TestDatePagingEntity> sourceList = new ArrayList<>();
        sourceList.add(new TestDatePagingEntity("name1", "男", 12));
        sourceList.add(new TestDatePagingEntity("name3", "男", 30));
        sourceList.add(new TestDatePagingEntity("name2", "男", 43));
        sourceList.add(new TestDatePagingEntity("name4", "男", 56));
        sourceList.add(new TestDatePagingEntity("name5", "男", 18));
        sourceList.add(new TestDatePagingEntity("name6", "男", 22));

        List<Integer> sortList = Arrays.asList(22, 18, 56);

        System.out.println("排序前数据:" + sourceList);
        System.out.println("排序规则数据：" + sortList);

        DataUtil.sortByList(sourceList, sortList, TestDatePagingEntity::getAge);

        System.out.println("排序后数据:" + sourceList);
    }
}
