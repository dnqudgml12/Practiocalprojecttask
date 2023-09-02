package org.example;

public class Main {
    //wordmanager를 이용해서 실제구동함으로서 wordmanager를 통해서 단어 관리하는 기능구현
    public static void main(String[] args) {
        //Main에서 wordmanager에 start함수를 호출
        //System.out.println("Hello world! 안녕");
          new WordManager().start();
    }
}