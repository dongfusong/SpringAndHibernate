package model;

/**
 * Created by Thoughtworks on 15/8/28.
 */
public class DemeBean {
    static private DemeBean instance;
    static {
        instance = new DemeBean("dongfusong");
    }

    public static DemeBean getInstance() {
        return instance;
    }

    private String name;

    public DemeBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemeBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
