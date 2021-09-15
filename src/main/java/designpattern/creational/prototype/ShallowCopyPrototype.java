package designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ShallowCopyPrototype implements Cloneable{
    private final String sql;
    private final List<String> params;
    private final String record;

    public ShallowCopyPrototype(String sql, List<String> params, String record) {
        this.sql = sql;
        this.record = record;
        this.params = params;
    }

    public ShallowCopyPrototype clone() {
        try{
            return (ShallowCopyPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSql() {
        return sql;
    }

    public List<String> getParams() {
        return params;
    }

    public String getRecord() {
        return record;
    }
}

class ShallowCopyPrototypeCaller {
    public static void main(String[] args) {
        String sql = "select * from Student where name = ?";
        List<String> params = new ArrayList<>();
        params.add("navinkumar");
        String record = "";

        ShallowCopyPrototype firstStatement = new ShallowCopyPrototype(sql, params, record);
        System.out.println(firstStatement);
        ShallowCopyPrototype secondCopy =  firstStatement.clone();
        System.out.println(secondCopy);

    }
}