package 프로그래머스.new_id;

//다른사람의 풀이. 정규표현식을 활용하여.. 특정 케이스에서 매우 빠른모습을 보임
//나도 정규표현식으로 한번에 다 쓰려고 했다가 실패했는데 이 사람은 정규표현식을 단계별로 나눠서 표현함

public class NewIdRegEx {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
}