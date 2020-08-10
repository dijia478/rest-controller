package cn.dijia478.demo.advice;

import cn.dijia478.demo.bean.common.BaseResponse;
import cn.dijia478.demo.bean.common.ResultEnum;
import cn.dijia478.demo.bean.exception.UserException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局响应体统一处理类
 *
 * @author dijia478
 * @date 2020-8-6 10:32:13
 */
@RestControllerAdvice(basePackages = {"cn.dijia478.demo.controller"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 此方法用来判断，哪些接口的返回值需要被包装，哪些不需要
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果返回的对象是baseResponse，则不需要本类处理
        return !methodParameter.getGenericParameterType().equals(BaseResponse.class);
    }

    /**
     * 此方法用来包装接口的返回值，全部统一返回{@link BaseResponse}
     *
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String类型不能直接返回，所以要进行些特别的处理
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            try {
                // 将baseResponse转换为json字符串响应给前端
                return new ObjectMapper().writeValueAsString(new BaseResponse<>(o));
            } catch (JsonProcessingException e) {
                throw new UserException(ResultEnum.JSON_ERR);
            }
        }
        // 将原本的数据包装在ResultVO里
        return new BaseResponse<>(o);
    }

}
