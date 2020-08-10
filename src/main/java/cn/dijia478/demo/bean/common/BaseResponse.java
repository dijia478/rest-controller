package cn.dijia478.demo.bean.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础返回对象
 *
 * @author dijia478
 * @date 2020-8-5 18:10:27
 */
@Data
@ApiModel("基础返回对象")
public class BaseResponse<T> {

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("响应信息")
    private String message;

    @ApiModelProperty("响应数据")
    private T data;

    public BaseResponse() {
        this(ResultEnum.SUCCESS, null);
    }

    public BaseResponse(T data) {
        this(ResultEnum.SUCCESS, data);
    }

    public BaseResponse(ResultEnum resultEnum) {
        this(resultEnum, null);
    }

    public BaseResponse(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

}
