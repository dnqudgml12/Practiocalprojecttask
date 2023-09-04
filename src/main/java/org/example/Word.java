package org.example;

public class Word {


    // 데이터 클래스로서 데이터를 관리하는 class
    private int id; //번호, 멤버 변수를 직접 접근하지 않기 위해서 private으로 한다
    private int level; //레벨,private으로 하면 같은 class내에서만 접근 가능하고 외부 class에서는 접근 불가능
    private String word; // 영어단어
    private String meaning; // 영어의 뜻
    //private으로 하면 같은 class내에서만 접근 가능하므로 외부에서 변경 가능하도록 getter와 setter를 추가하도록 한다.

    //생성(generate에서 getter and setter누르고 private 다 클릭하고 생성 누르면
    //getter,setter만들어짐

    //데이터 클래스를 만들떄 (wordclass) 필요에 따라 생성자를 만들게 되는데
    // 보통 생성자를 만들때 기본 형은 자동으로 만들어 지지 않으므로 비어있는 기본형 만들기

    Word(){}
    Word(int id, int level, String word, String meaning){    //멤버 변수와 같은 파라미터를 받는 생성자를 만드므로 파라미터를 멤버변수와 같이 만들기
        this.id = id; //받아온 데이터를 멤버 변수에 세팅 가능하도록 ;
        this.level=level;
        this.word=word;
        this.meaning=meaning;
    }
    //보고 생성자 추가하기

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }


    /*
    데이터 순서 레벨 영어단어 뜻
    1* electric 전기의,전기를 생산하는
    2* pole 기둥,장대
    * */
    @Override
    public String toString() {
        String slevel=""; //숫자로 되있으므로 slevel이라는 문자로 만듬;
        for (int i=0; i<level; i++) slevel+="*";
        String str = String.format("%-3s", slevel) //최대 3칸,slevel은 왼쪽 정렬이므로 -3
                    +String.format("%15s",word)+ // 영문자 word 오른쪽 정렬 15칸
                     meaning;

        return str;
      //word라는 객체안에 데이터가 채워지고 toString()이라는 함수를 부르게 되면 원하느 format문자열 호출가능
    }

    public String toFileString(){

        return this.level+"|"+this.word+"|"+this.meaning;


    }

}



