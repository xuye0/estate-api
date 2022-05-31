package work.xuye.estate.advice;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import work.xuye.estate.bean.ResultCode;
import work.xuye.estate.bean.ResultVO;
import work.xuye.estate.exception.CustomException;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = bindingResult.getFieldErrors().stream()
                .map(f -> f.getField().concat(": ").concat(Optional.ofNullable(f.getDefaultMessage()).orElse("")))
                .collect(Collectors.joining("; "));
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, message);
    }

    @ExceptionHandler(CustomException.class)
    public ResultVO<String> CustomExceptionHandler(CustomException e) {
        return new ResultVO<>(ResultCode.FAILED, e.getMessage());
    }

    @ExceptionHandler(NotLoginException.class)
    public ResultVO<String> NotLoginExceptionHandler(NotLoginException e) {
        return new ResultVO<>(ResultCode.NOT_LOGIN, e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResultVO<String> DuplicateKeyExceptionHandler(DuplicateKeyException e) {
        return new ResultVO<>(ResultCode.FAILED, "记录已存在 ~ ");
    }

    @ExceptionHandler(Exception.class)
    public ResultVO<String> ExceptionHandler(Exception e) {
        log.info(e.getMessage(), e);
        return new ResultVO<>(ResultCode.ERROR, e.getMessage());
    }


}
