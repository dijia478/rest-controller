package cn.dijia478.demo.utils;

import cn.dijia478.demo.bean.common.BaseResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Locale;

/**
 * 国际化转换工具
 *
 * @author dijia478
 * @date 2020-12-17 14:48
 */
public class I18nUtil {

    private I18nUtil() {}

    /**
     * 将response中的message进行国际化转换
     * 本项目示例采用springboot自带的MessageSource进行国际化翻译，可以根据需要自行重写本方法
     *
     * @param messageSource
     * @param response

     */
    public static <T> void msgToI18n(MessageSource messageSource, BaseResponse<T> response) {
        String message = messageSource.getMessage(response.getCode().toString(), null, LocaleUtil.getLocal());
        response.setMessage(message);
    }

}
