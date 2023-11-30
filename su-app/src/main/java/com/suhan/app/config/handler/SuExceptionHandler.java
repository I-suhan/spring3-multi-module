package com.suhan.app.config.handler;

import com.suhan.common.dto.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class SuExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Result<?> handleBizException(HttpServletRequest request, HttpServletResponse response, BizException e){
        /*log(request, e);*/
        String code = e.getErrorCode().getCode();
        HttpStatus httpStatus = HttpStatus.valueOf(e.getStatusCode());
        response.setStatus(httpStatus.value());
        return new Result<>(Integer.valueOf(code), e.getMessage());
    }
}
