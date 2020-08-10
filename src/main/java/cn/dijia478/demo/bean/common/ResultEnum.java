package cn.dijia478.demo.bean.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应码枚举类
 *
 * @author dijia478
 * @date 2020-8-5 18:45:25
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    /** 成功 */
    SUCCESS(200, "success"),

    /** 失败 */
    FAILURE(500, "failure"),

    /** 参数校验失败 */
    VALIDATE_ERR(501, "参数校验失败"),

    /** json转换异常 */
    JSON_ERR(502, "json转换异常"),

    /** 数据不存在 */
    NOT_EXIST(503, "数据不存在");

    private Integer code;

    private String message;

}
