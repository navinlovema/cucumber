package designpattern;

public class ShallowCopy {

    private final int[] data;

    public ShallowCopy(int[] values){
        this.data = values; // here it is shallow copied...
    }

    public int[] getData(){
        return this.data;
    }
}
class ShallowCopyCaller {
    public static void main(String[] args) {

        int[] values = new int[]{1,2,3};

        ShallowCopy shallowCopy = new ShallowCopy(values);

        if(shallowCopy.getData() == values){
            System.out.println(values);
            System.out.println(shallowCopy.getData());
            System.out.println("equals...");
        }
    }


}

