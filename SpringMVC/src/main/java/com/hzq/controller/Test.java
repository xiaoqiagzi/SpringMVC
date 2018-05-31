package com.hzq.controller;

import java.io.UnsupportedEncodingException;

/**
 * des进行加密 解密
 */
public class Test{

    public static void main(String[] args) throws UnsupportedEncodingException {


            String key="大家辛苦了";
            String password="abcd";
            byte [] bt=key.getBytes();
            byte [] ps=password.getBytes();
             for(int i=0;i<bt.length;i++){
                 /*bt[i]= (byte) (bt[i]^ps[i]);*/
                     bt[i]^=ps[i%ps.length];
             }
            System.out.println(new String(bt));
            for(int i=0;i<bt.length;i++){
                 /*bt[i]= (byte) (bt[i]^ps[i]);*/
            bt[i]^=ps[i%ps.length];
            }
            System.out.println(new String(bt,"utf-8"));


    }

}
