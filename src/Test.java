public class Test {
    public static void main(String[] args) {

        Long test = 2l;

        for(int i = 1; i < 32; i++) {
            System.out.println(test);
            System.out.println("i = " + i);
            test *= 2;

        }

        System.out.println(test);
    }
}
