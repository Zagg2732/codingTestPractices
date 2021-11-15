package 코드잇;

public class 팔린드롬 {
    //팔린드롬은 거꾸로해도 긔엽긔처럼 앞뒤가 똑같은거임
    //그럼 팔린드롬인지 아닌지 확인하는 isPalin 을 만들어보자

    public static void main(String[] args) {

        팔린드롬 pal = new 팔린드롬();

        System.out.println("pal.isPalin(\"racecar\") = " + pal.isPalin("racecar"));
        System.out.println("pal.isPalin(\"stars\") = " + pal.isPalin("stars"));
        System.out.println("pal.isPalin(\"토마토\") = " + pal.isPalin("토마토"));
        System.out.println("pal.isPalin(\"kayak\") = " + pal.isPalin("kayak"));
        System.out.println("pal.isPalin(\"hello\") = " + pal.isPalin("hello"));
    }

    public boolean isPalin(String str) {

        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }

        return true;
    }
}
