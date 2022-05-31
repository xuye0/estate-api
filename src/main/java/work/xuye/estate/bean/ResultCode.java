package work.xuye.estate.bean;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(1000, "success"),

    FAILED(1001, "failed"),

    VALIDATE_FAILED(1002, "validate_failed"),

    NOT_LOGIN(4000, "NOT_LOGIN"),

    ERROR(5000, "error");

    private final int code;

    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
