package designpattern.creational.builder;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("This is navin kumar, his age is = ");
        builder.append(27);
        builder.append(". He is from Shahpur Village which is placed in Hazaribagh Jharkhand, 825319");
        System.out.println(builder);
    }
}
