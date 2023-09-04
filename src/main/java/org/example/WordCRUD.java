package org.example;

import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {

    //단어를 여러개를 우리가 관리해야하ㅡ로 동적인 class가 필요
    ArrayList<Word> list; //word라는 type
    Scanner s;
    final String fname="Dictionary.txt";

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
        for (int i=0; i< list.size();i++){
            //반복 구문, 수치는 i만큼 반복
            //print를 해야 공백이 하나 생기게 가능 println은 옆애 바로 붙음
            System.out.print((i+1)+"  ");
            System.out.println(list.get(i).toString());
            // 하나씩 리스트안에서 출력
             }
            System.out.println("--------------------------------------");
    }

    public ArrayList<Integer> listAll(String keyword){
        //Array리스트는 화면에 출력하는 원본을 담고 있다

        //keyword에 있는 해당 단어만 선택 후 번호 선택해서 수정
        ArrayList<Integer> idlist= new ArrayList<>();
        int j =0;

        System.out.println("--------------------------------------");
        for (int i=0; i< list.size();i++){

            String word = list.get(i).getWord();  // 영어단어 가져오고
            if (!word.contains(keyword)) continue; //keyword에 해당하는 단어 포함한다면 true,아니면false
            //반복 구문, 수치는 i만큼 반복
            //print를 해야 공백이 하나 생기게 가능 println은 옆애 바로 붙음
            //해당 키워드 포함시에 단어 출력
            System.out.print((j+1)+"  "); //j로 해야 하나씩 늘어남
            System.out.println(list.get(i).toString());
            // 하나씩 리스트안에서 출력
            //출력할때마다 idlist에 추가
            idlist.add(i);
            j++; //출력시 j증가
        }
        System.out.println("--------------------------------------");
        return  idlist;
    }
    public void listAll(int level)
    {
        int j =0;

        System.out.println("--------------------------------------");
        for (int i=0; i< list.size();i++){

            int ilevel = list.get(i).getLevel();  // 영어단어 가져오고
            if (ilevel !=level) continue; //keyword에 해당하는 단어 포함한다면 true,아니면false
            //반복 구문, 수치는 i만큼 반복
            //print를 해야 공백이 하나 생기게 가능 println은 옆애 바로 붙음
            //해당 키워드 포함시에 단어 출력
            System.out.print((j+1)+"  "); //j로 해야 하나씩 늘어남
            System.out.println(list.get(i).toString());
            // 하나씩 리스트안에서 출력

            j++; //출력시 j증가
        }
        System.out.println("--------------------------------------");
        //return  idlist;
    }
    public void updateItem() {
        //수정단어 검색 입력 받아 해당 리스트 출력
        System.out.print("=> 수정 할 단어 검색 : ");
        String keyword= s.next();//공백 없앨려고 next
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정 할 번호 선택 : ");
        int id =s.nextInt();
        //번호 선택하면 뜻 입력
        //엔터도 입력해야 nextLine
        s.nextLine();
        System.out.print("=> 뜻 입력:");
        String meaning= s.nextLine(); //엔터가 뜻으로 들어가버려서 s.nextLine한번더 출력
        Word word= list.get(idlist.get(id-1));//0부터 하니 시작
        word.setMeaning(meaning);
        System.out.println("단어가 수정이 되었습니다.");

    }

    public void deleteItem() {
        //수정단어 검색 입력 받아 해당 리스트 출력
        System.out.print("=> 삭제 할 단어 검색 : ");
        String keyword= s.next();//공백 없앨려고 next
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제 할 번호 선택 : ");
        int id =s.nextInt();
        //번호 선택하면 뜻 입력
        //엔터도 입력해야 nextLine
        s.nextLine();
        System.out.print("=> 정말로 삭제하실래요? (Y/n) ");
        String answer= s.next(); //엔터가 뜻으로 들어가버려서 s.nextLine한번더 출력
        if(answer.equalsIgnoreCase("Y")) //소문자든 대문자든 동일하게 처리
       {
           list.remove((int)idlist.get(id-1)); //remove는 index의 값을삭제
           //remove는 객체나 정수로 몇번째 인덱스를 넣을 지 선택
           //idlist는 integer라는 객체가 되있으므로 정수로 바꾸기
           //(int)
           System.out.print("단어가 삭제 되었습니다. ");
       } else{
            System.out.print("취소 되었습니다. ");
        }





}

    public void loadFile() {
        try { BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;

            int count = 0;

           while(true) {
               line = br.readLine();
               if(line==null) break;
               String data[] = line.split("\\|");
               int level = Integer.parseInt(data[0]);
               String word = data[1];
               String meaning =data[2];
               list.add(new Word(0, level, word,meaning));
               count++;

           }
           br.close();
           System.out.println("==>" + count+"개 로딩 완료 !!!");
              }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("test.txt"));
            for(Word one: list){
                pr.write(one.toFileString()+"\n");

            }
            pr.close();
            System.out.println("==> 데이터 저장 완료 !!!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void searchLevel() {
        System.out.print("==> 원하는 레벨은? (1~3) ");
        int level = s.nextInt();
        listAll(level);
    }

    public void searchWord() {
        System.out.print("==> 원하는 단어는? ");
        String keyword= s.next();
        listAll(keyword);
    }
}
