package work.xuye.estate.bean;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResultVO<T> {

    private final int code;
    private final String message;
    private final String server_time;
    private final T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.server_time = LocalDateTime.now().toString();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
