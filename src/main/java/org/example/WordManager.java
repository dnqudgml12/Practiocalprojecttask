package org.example;

import java.util.Scanner;

public class WordManager {
    //addword가 wordCrud에있으니까
    WordCRUD wordCRUD; //선언하고

    //wordcrud를 이용해서 구현해서 crud 기능을 구현하는 관리 느낌

    //wordmanager에서 main 역할을 할 수 있는 start함수

    //입력받아야 하므로 Scanner를 지정
    Scanner s= new Scanner(System.in);

    /*
    다음과 같은 화면 나오도록 하기
    ***영단어 마스터***
    1. 모든 단어보기
    2. 수준별 단어보기
    3. 단어 검색
    4. 단어 추가
    5. 단어 수정
    6. 단어 삭제
    7. 파일 저장
    0. 나가기
    *****************
    => 원하는 메뉴는? 4

     */

    WordManager(){ //생성자 만들때 word crud를 멤버 변수로 만든다
        wordCRUD = new WordCRUD(s);
    }
    public int selectMenu(){
System.out.print(    "***영단어 마스터***\n"+
        "*****************\n"+
        "1. 모든 단어보기\n"+
        "2. 수준별 단어보기\n"+
        "3. 단어 검색\n"+
        "4. 단어 추가\n"+
        "5. 단어 수정\n"+
        "6. 단어 삭제\n"+
        "7. 파일 저장\n"+
        "0. 나가기\n"+
               "*****************\n"+
    "=> 원하는 메뉴는?");
//selectMenu type을 int로 바꾸면 필요없 int menu = s.nextInt();// scanner에 정수를 입력 받음
return s.nextInt();

    }
    public void start() {
        //start함수가 main에서 호출되는 함수이므로 여기다가 selectMenu를 넣어줌
        //  System.out.println("WordManager!!!")
        // 0을 누를때 까지는 반복해야 하니까
        while (true) {
            int menu = selectMenu();
            if (menu==0) {
                System.out.println("프로그램 종료! 다음에 만나요~");
                break;}
            
            if (menu==4){
                //create
               wordCRUD.addWord();
            } else if (menu==1) {
                //list
                wordCRUD.listAll();
                
            }

            //System.out.println(menu); // 사용자가 입력한 값 즉 리턴 값을 출력
        }
    }
}
