package designpattern.creational.builder;

public class TelescopingConstructor {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public TelescopingConstructor() {
    }

    public TelescopingConstructor(String bread) {
        this.bread = bread;
    }

    public TelescopingConstructor(String bread, String condiments) {
        this(bread);
        this.condiments = condiments;
    }

    public TelescopingConstructor(String bread, String condiments, String dressing) {
        this(bread, condiments);
        this.dressing = dressing;
    }

    public TelescopingConstructor(String bread, String condiments, String dressing, String meat) {
        this(bread, condiments, dressing);
        this.meat = meat;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    @Override
    public String toString() {
        return "TelescopingConstructor{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", dressing='" + dressing + '\'' +
                ", meat='" + meat + '\'' +
                '}';
    }
}

class CallerTelescopingConstructor{
    public static void main(String[] args) {
        TelescopingConstructor telescopingConstructor = new TelescopingConstructor("wheat","lettuce", "maya");
        System.out.println(telescopingConstructor.toString());
    }
}
