package cn.dijia478.demo.utils;

import cn.dijia478.demo.bean.common.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 国际化转换工具
 * 本项目示例采用springboot自带的MessageSource进行国际化翻译，可以根据需要自行重写本类方法，比如从数据库中获取
 *
 * @author dijia478
 * @date 2020-12-17 14:48
 */
@Component
public class I18nUtil {

    @Autowired
    private MessageSource messageSource;

    /**
     * 将response中的message进行国际化转换
     *
     * @param response
     */
    public <T> void responseToI18n(BaseResponse<T> response) {
        String message = messageSource.getMessage(response.getCode().toString(), null, LocaleUtil.getLocal());
        if (StringUtils.hasLength(message)) {
            response.setMessage(message);
        }
    }

    /**
     * 根据code获取I18n国际化文本
     *
     * @param code
     * @return
     */
    public String getI18nMsg(String code) {
        String message = messageSource.getMessage(code, null, LocaleUtil.getLocal());
        return StringUtils.hasText(message) ? message : code;
    }

}
