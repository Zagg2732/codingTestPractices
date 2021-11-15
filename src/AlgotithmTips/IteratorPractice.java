package AlgotithmTips;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//https://vaert.tistory.com/108
public class IteratorPractice {
    public static void main(String[] args) {

        /*

        public interface Iterator {

        boolean hasNext();

        Object next();

        void remove();

        }

        */

        List<Integer> testList = new ArrayList<>();

        testList.add(5);
        testList.add(3);
        testList.add(11);
        testList.add(7);
        testList.add(9);

        //배열 안의 요소를 Iterator로 씀
        Iterator<Integer> i = testList.listIterator();

        //Iterator를 모두 순회
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        /*
        하지만 ArrayList의 경우 size()를 이용하여 for문의 크기를 지정해 순회할 수 있다.
        그럴경우 Iterator 객체로 변환해 사용하는것보다 빠를 수 밖에 없다.
         */

    }
}
