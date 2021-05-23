package com.alethio.service.exception;

public class NoItemLeftException extends BusinessException{

    private static final String MESSAGE = "재고가 없습니다.";

    public NoItemLeftException() {
        super(MESSAGE);
    }
}
