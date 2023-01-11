package entity;

/**
 * @author Luhan
 * @ClassName: TestDatePagingEntity
 * @Description: (这个是用于测试List分页使用到的实体类)
 * @date 2017年3月18日 下午7:51:22
 */
public class TestDatePagingEntity {

    private String name;
    private String sex;
    private int age;

    public TestDatePagingEntity() {
    }

    public TestDatePagingEntity(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestDatePagingEntity{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
