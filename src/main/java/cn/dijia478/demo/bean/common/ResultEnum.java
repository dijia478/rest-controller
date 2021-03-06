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
    SUCCESS(200, "成功"),

    /** 失败 */
    FAILURE(600, "错误"),

    /** 未知异常 */
    UNKNOWN_ERR(601, "未知异常"),

    /** 参数校验失败 */
    VALIDATE_ERR(602, "参数校验失败"),

    /** json处理异常 */
    JSON_ERR(603, "json处理异常"),

    /** 数据不存在 */
    NOT_EXIST(604, "数据不存在"),

    /** 请求错误 */
    REQUEST_ERR(605, "请求错误");

    private final Integer code;

    private final String message;

}
