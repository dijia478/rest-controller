package cn.dijia478.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 本demo提供展示以下功能特性
 *
 * 通过 Validated注解 完成参数校验的规范
 * 通过 全局异常处理 + 自定义异常 + 响应码枚举 完成了异常处理的规范
 * 通过 全局响应体处理 完成了响应数据体的规范
 * 通过 swagger3.0 完成了API文档的规范
 *
 * @author dijia478
 * @date 2020-8-6 11:27:14
 */
@SpringBootApplication
@EnableOpenApi
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
