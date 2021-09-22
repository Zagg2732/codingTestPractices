import keypad.Keypad;

public class KeypadMain {
    public static void main(String[] args) {
        Keypad keypad = new Keypad();

        int[] test1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        System.out.println(keypad.solution(test1 , "right"));
    }
}
