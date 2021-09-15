package designpattern.creational.builder;

public class LunchOrderBuilder {
    public static class Builder{
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public Builder () {}

        public Builder bread(String bread){
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments){
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing){
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat){
            this.meat = meat;
            return this;
        }

        public LunchOrderBuilder build() {
            return new LunchOrderBuilder(this);
        }
    }

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    private LunchOrderBuilder(Builder builder){
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    @Override
    public String toString() {
        return "LunchOrderBuilder{" +
                "bread='" + bread + '\'' +
                ", condiments='" + condiments + '\'' +
                ", dressing='" + dressing + '\'' +
                ", meat='" + meat + '\'' +
                '}';
    }
}

class CallerLunchOrderBuilder {
    public static void main(String[] args) {
        LunchOrderBuilder.Builder builder = new LunchOrderBuilder.Builder();
        builder.bread("Wheat").dressing("maya").meat("turkey").condiments("lettuce");
        LunchOrderBuilder data = builder.build();
        System.out.println(data.toString());
    }
}
