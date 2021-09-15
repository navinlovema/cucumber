package designpattern.creational.singleton;

public class SingletonThreadSafe {
    private static volatile SingletonThreadSafe instance = null;
    private SingletonThreadSafe(){
        if(instance != null) {
            throw new RuntimeException("please call getInstance() method to create...");
        }
    }

    public static SingletonThreadSafe getInstance() {
        if(instance == null) {
            synchronized (SingletonThreadSafe.class){
                if(instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}

class CallerSingletonThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SingletonThreadSafe object = SingletonThreadSafe.getInstance();
                System.out.println(object);
            }
        };

        Runnable anotherRunnable = new Runnable() {
            @Override
            public void run() {
                SingletonThreadSafe object = SingletonThreadSafe.getInstance();
                System.out.println(object);
            }
        };

        Thread thread = new Thread(runnable);
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        thread.start();

        Thread thread1 = new Thread(anotherRunnable);
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        thread1.start();
        thread1.join();
    }
}
