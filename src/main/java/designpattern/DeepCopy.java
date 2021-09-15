package designpattern;

public class DeepCopy {

    private final int[] data;

    public DeepCopy(int[] values) {
        data = new int[values.length];
        System.arraycopy(values, 0, data, 0, values.length);
    }

    public int[] getData() {
        return this.data;
    }
}

class DeepCopyCaller {
    public static void main(String[] args) {

        int[] values = new int[]{1,2,3};

        DeepCopy deepCopy = new DeepCopy(values);
        System.out.println(values);
        System.out.println(deepCopy.getData());
        if(values != deepCopy.getData()){
            System.out.println("not equals...");
        }
    }
}
