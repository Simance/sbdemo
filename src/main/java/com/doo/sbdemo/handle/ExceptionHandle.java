package com.doo.sbdemo.handle;

import com.doo.sbdemo.domain.Girl;
import com.doo.sbdemo.domain.Result;
import com.doo.sbdemo.exception.GirlException;
import com.doo.sbdemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获处理
 * @author doo at 2018/03/05
 */
@ControllerAdvice
public class ExceptionHandle {
    private final  static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }
        logger.error("【系统异常】{}",e);
        return ResultUtil.error(100,e.getMessage());
    }
}
