package com.mustceng.onlineshop.exception;

import org.springframework.http.HttpStatus;

public interface IResponseCode {
    Integer code();

    HttpStatus httpStatus();
}
