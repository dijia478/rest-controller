package cn.dijia478.demo.advice;

import cn.dijia478.demo.bean.common.BaseResponse;
import cn.dijia478.demo.bean.common.ResultEnum;
import cn.dijia478.demo.bean.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常统一处理类
 *
 * @author dijia478
 * @date 2020-8-5 18:27:32
 */
@RestControllerAdvice(basePackages = {"cn.dijia478.demo.controller"})
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("", e);
        return new BaseResponse<>(ResultEnum.VALIDATE_ERR, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(UserException.class)
    public BaseResponse<String> userException(UserException e) {
        log.info("", e);
        return new BaseResponse<>(e.getResultEnum());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<String> otherException(Exception e) {
        log.info("", e);
        return new BaseResponse<>(ResultEnum.UNKNOWN_ERR, e.toString() + ":" + e.getMessage());
    }

}
