package br.com.workshop.model.vo;

import javax.validation.constraints.NotNull;

public class ErrorMessageDefault {

    private String message;
    private int code;

    public ErrorMessageDefault(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static ErrorMessageDefault create(final @NotNull String message, final @NotNull int code){
        return new ErrorMessageDefault(message,code);
    }
}
