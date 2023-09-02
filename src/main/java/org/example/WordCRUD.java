package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {

    //단어를 여러개를 우리가 관리해야하ㅡ로 동적인 class가 필요
    ArrayList<Word> list; //word라는 type
    Scanner s;

    /*
    => 난이도(1,2,3) & 새 단어 입력:1 driveway
    뜻 입력: 차고 진입로
    새 단어가 단어장에 추가되었습니다.
     */

    WordCRUD(Scanner s){

        //wordCrud라는 생성자를 만들때 객체화 하도록
        list= new ArrayList<>();
        this.s =s; //사용자의 입력파라미터 따라서 넣을 수 있도로 ㄱ한다
    }
    //WordCRUD에 커서 올리면 구현해야 할거 나온다 인터페이스인 ICRUD에 있는 것들
    // 클릭하면 ICRUD에서 설정한 애들 나옴
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력:");
        int level = s.nextInt();//숫자입력
        String word= s.nextLine();
        //입력 버퍼에 enter가 남아있어서 그 버퍼가 nextLine으로 넘어감
        //그래서 next -> nextLine으로
        System.out.print("뜻 입력:");
        String meaning = s.nextLine();//공백 포함해야 하니까


        return new Word(0,level,word,meaning); //입력 받은 Word기준으로, id가 없으니까 0
        //입력받는 구분
    }

    public void addWord(){
        //사용자에게 입력받는 부분을 리스트에 추가하는 함수
        Word one = (Word) add();
//Word라는 class에 객체 생성
        //add가 return type이 object이므로 Word로 casting(type변환)

        //나온 데이터를 추가
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다.");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
    //ICRUD를 구현하는 구현체이다, implements를 이용해서 구현

    /*
    => 원하는 메뉴는?
    --------------------------------------
    1 ***   superintendent   관리자, 감독관
    2 *           electric   전기의, 전기를 생산하는
    3 **         equipment   장비, 용품
    4 *               pole   기둥, 장대
       --------------------------------------
     */
    //화면 출력 예정이므로 return은 없고 void로 type
    public void listAll(){
        System.out.println("--------------------------------------");
        for (int j=0; j< list.size();j++){
            //반복 구문, 수치는 i만큼 반복
            //print를 해야 공백이 하나 생기게 가능 println은 옆애 바로 붙음
            System.out.print((j+1)+"  ");
            System.out.println(list.get(j).toString());
            // 하나씩 리스트안에서 출력
             }
            System.out.println("--------------------------------------");






    }

}
