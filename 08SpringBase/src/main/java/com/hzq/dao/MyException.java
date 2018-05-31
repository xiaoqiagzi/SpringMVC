package com.hzq.dao;

public class MyException extends RuntimeException {
    public void after(MyException ex){
        System.out.println("进入  异常通知");
        System.out.println(ex.getMessage());
    }
    public MyException(){
        super();
    }
    public MyException(String msg){
        super(msg);
    }
    public MyException(String msg,Throwable ex){
        super(msg,ex);
    }
}
