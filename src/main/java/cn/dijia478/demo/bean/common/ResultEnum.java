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

    /** 未知异常 */
    UNKNOWN_ERR(501, "未知异常"),

    /** 参数校验失败 */
    VALIDATE_ERR(502, "参数校验失败"),

    /** json转换异常 */
    JSON_ERR(503, "json转换异常"),

    /** 数据不存在 */
    NOT_EXIST(504, "数据不存在");

    private final Integer code;

    private final String message;
}
