package cn.dijia478.demo.utils;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 获取请求头中的语言信息
 *
 * @author dijia478
 * @date 2020-12-17 15:53
 */
public class LocaleUtil {

    /** 请求头中存放语言的key，value是：zh_CN、zh_TW、en_US这种 */
    private static final String LANGUAGE = "Language";

    private LocaleUtil() {}

    public static Locale getLocal() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return LocaleContextHolder.getLocale();
        }

        HttpServletRequest request = attributes.getRequest();
        String locale = request.getHeader(LANGUAGE);
        if (locale == null) {
            return LocaleContextHolder.getLocale();
        }

        return new Locale(locale);
    }

}
