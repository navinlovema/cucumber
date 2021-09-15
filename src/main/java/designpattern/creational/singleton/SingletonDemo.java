package designpattern.creational.singleton;

public class SingletonDemo {
    private static SingletonDemo instance = new SingletonDemo();
    private SingletonDemo(){}
    public static SingletonDemo getInstance(){
        return instance;
    }
}

class Caller {
    public static void main(String[] args) {
       //SingletonDemo firstObject = new SingletonDemo(); // it will not run because SingletonDemo has no public constructore
       SingletonDemo firstObject = SingletonDemo.getInstance();
        System.out.println(firstObject);
        SingletonDemo secondObject = SingletonDemo.getInstance();
        System.out.println(secondObject);
        if(firstObject == secondObject) {
            System.out.println("address has same");
        }
    }
}
