package AlgotithmTips;

import java.util.HashSet;
import java.util.Iterator;

//HashMap을 주로 활용했었는데 파이썬에서 사용하던 Set을 쓰는게 더 맞는경우가 있었음
//그래서 찾아보니 Java에서는 HashSet을 쓰면 내가 원하던 Set 자료형을 쓸수 있었다

public class HashSetPractice {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>(); //HashSet생성

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(3);
        hashSet.add(3);

        //[1,2,3] 이나옴. 중복허용 x, 순서가 보장된건 아님
        System.out.println(hashSet);

        //모든 원소 출력 (HashSet은 순서가 보장되지 않기에 index가 없음)
        Iterator it = hashSet.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }


        //Set에 값이 있는지 체크
       System.out.println(hashSet.contains(2));
       System.out.println(hashSet.contains(4));

    }

}
