package com.hzq.service;

import org.omg.CORBA.UserException;

public class UserNameException extends UserException {
    //用户名异常类

        public UserNameException(String msg) {
            super(msg);
        }
}
