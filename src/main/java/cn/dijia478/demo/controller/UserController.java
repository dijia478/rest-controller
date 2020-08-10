package cn.dijia478.demo.controller;

import cn.dijia478.demo.bean.User;
import cn.dijia478.demo.bean.common.ResultEnum;
import cn.dijia478.demo.bean.exception.UserException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关接口
 *
 * @author dijia478
 * @date 2020-8-5 16:02:54
 */
@RestController
@Api(tags="用户管理")
@Slf4j
public class UserController {

    @ApiOperation("创建用户")
    @PostMapping("/user")
    public void insertUser(@RequestBody @Validated User user) {
        log.info("创建用户:{}", user);
    }

    @ApiOperation("查询用户")
    @GetMapping("/user/{id}")
    public User getUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
        log.info("查询用户");
        if (id != 1L) {
            throw new UserException(ResultEnum.NOT_EXIST);
        }
        User user = new User();
        user.setId(1L);
        user.setName("张三丰");
        user.setAge(120);
        user.setEmail("wudangshan@163.com");
        return user;
    }

    @ApiOperation("修改用户")
    @PutMapping("/user")
    public void updateUserById(@RequestBody @Validated User user) {
        log.info("修改用户:{}", user);
        throw new UserException(ResultEnum.FAILURE);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
        log.info("删除用户");
        return "删除用户成功";
    }

}
