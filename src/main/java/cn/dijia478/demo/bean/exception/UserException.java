package cn.dijia478.demo.bean.exception;

import cn.dijia478.demo.bean.common.ResultEnum;
import lombok.Getter;

/**
 * 用户相关异常
 *
 * @author dijia478
 * @date 2020-8-5 18:36:23
 */
@Getter
public class UserException extends RuntimeException {

    private final ResultEnum resultEnum;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.resultEnum = resultEnum;
    }

}
