package com.mycompany.contactapi.exception;

public class ContactNotFoundException extends Throwable {
    public ContactNotFoundException(String s) {
        super(s);
    }
}
