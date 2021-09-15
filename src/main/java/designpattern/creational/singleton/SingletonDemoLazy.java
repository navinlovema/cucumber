package designpattern.creational.singleton;

public class SingletonDemoLazy {
    
    private static SingletonDemoLazy instance = null;
    private SingletonDemoLazy(){
        if(instance != null){
            throw new RuntimeException("please call getInstance() method to create...");
        }
    }
    
    public static SingletonDemoLazy getInstance() {
        if(instance == null) instance = new SingletonDemoLazy(); // lazyCall
        return instance;
    }
}

class CallerLazy {
    public static void main(String[] args) {
        SingletonDemoLazy firstObject = SingletonDemoLazy.getInstance();
        System.out.println(firstObject);
        SingletonDemoLazy secondObject = SingletonDemoLazy.getInstance();
        System.out.println(secondObject);
        if(firstObject == secondObject){
            System.out.println("both object are sharing same memory...");
        }
    }
}
