package org.egorovav.springboottest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageFactoryImpl implements MessageFactory {

    private final ReloadableResourceBundleMessageSource messageSource;
    private final Locale locale;

    public MessageFactoryImpl() {
        this.messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        this.locale = LocaleContextHolder.getLocale();
    }

    @Override
    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, locale);
    }
}
