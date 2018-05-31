package com.hzq;

import org.junit.Test;


public class jisuan {




    @Test
    public  void test01() {
        int head = 50;
        int foot = 120;
        for (int x = 0; x <= head; x++) {
            int y = 50 - x;
            if (2 * x + 4 * y ==foot) {
                System.out.println("鸡"+x);
                System.out.println("鸭"+y);
            }
        }
    }
    /*
    找零8元
    有 5元  2元 1元 5角
    几种方案
     */
    @Test
    public void test03(){
        double total=80;
        double a=50;
        double b=20;
        double c=10;
        double d=5;
        for(int m=0;m<=total/d;m++){
             for(int n=0;n<=total/c;n++){
                 for(int i=0;i<=total/b;i++){
                     for (int j=0;j<=total/a;j++){
                        if(a*j+b*i+c*n+d*m==total){
                            System.out.println("5元==="+j+"2元==="+i+"1元==="+n+"0.5元==="+m);

                        }
                     }
                 }
             }
        }
    }
        @Test
    public  void  test04(){
         for (int i=0;i<80/10;i++) {
             for (int j=0;j<80/20;j++){
                 for(int m=0;m<80/50;m++){
                     if(80-50*i-20*j-10*m<0)break;
                     int n=(80-50*i-20*j-10*m)/5;
                     System.out.println("50==========>"+m+","+"20==========>"+j+","+"10==========>"+i+","+"5==========>"+n);
                 }
             }
         }

        }
    }
