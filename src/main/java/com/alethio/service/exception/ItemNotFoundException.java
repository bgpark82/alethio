package com.alethio.service.exception;

public class ItemNotFoundException extends BusinessException{

    private static final String MESSAGE = "존재하지 않는 아이템입니다.";

    public ItemNotFoundException() {
        super(MESSAGE);
    }
}
