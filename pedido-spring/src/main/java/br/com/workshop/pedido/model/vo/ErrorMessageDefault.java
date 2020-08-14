package br.com.workshop.pedido.model.vo;

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

    public int getCode() {
        return code;
    }
}
