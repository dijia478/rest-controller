package cn.dijia478.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 用户实体
 *
 * @author dijia478
 * @date 2020-8-5 16:03:57
 */
@Data
@ApiModel("用户信息")
public class User {

    @NotNull(message = "用户id不能为null")
    @ApiModelProperty("用户id")
    private Long id;

    @NotBlank(message = "用户名称不能为空")
    @ApiModelProperty("用户名称")
    private String name;

    @Min(value = 0, message = "用户年龄不能小于0")
    @Max(value = 150, message = "用户年龄不能大于150")
    @NotNull(message = "用户年龄不能为null")
    @ApiModelProperty("用户年龄")
    private Integer age;

    @Email(message = "用户邮箱不符合邮箱格式")
    @ApiModelProperty("用户邮箱")
    private String email;

}
