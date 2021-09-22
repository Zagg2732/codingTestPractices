package skill_check;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/12973
public class Dup {

    public int solution(String s) {

        Stack<Character> stack = new Stack<>();


        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;

    }

    public static void main(String[] args) {
        Dup dup = new Dup();

        System.out.println(dup.solution("baabaa"));
        System.out.println(dup.solution("cdcd"));
    }
}
