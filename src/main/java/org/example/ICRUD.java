package org.example;

public interface ICRUD {
    //4개 함수 추가
    public Object add(); //데이터를 추가하는 add, 추가 시에 해당 추가 객체를 return 할려고 Object
    public int update(Object obj); // 데이터 수정, 어떤 값을 해야 할지
    public int delete(Object obj);// 데이터 삭제
    public void selectOne(int id);// 데이터 한개 조회

    //return type이나 parameter 작성하는 사람들이 원하는 template에 맞춰서 구성

}
