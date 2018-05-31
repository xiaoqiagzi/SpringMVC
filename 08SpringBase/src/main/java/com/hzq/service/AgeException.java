package com.hzq.service;

import org.omg.CORBA.UserException;

public class AgeException extends UserException {
    public AgeException(String msg) {
        super(msg);
    }
}
