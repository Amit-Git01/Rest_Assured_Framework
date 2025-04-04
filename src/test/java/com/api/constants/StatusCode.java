package com.api.constants;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum StatusCode {
	OK(200),
	CREATED(201),
	BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

}