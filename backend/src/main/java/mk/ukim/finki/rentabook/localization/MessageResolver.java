package mk.ukim.finki.rentabook.localization;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class MessageResolver {

    private final MessageSource messageSource;

    public MessageResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    public String getLocalizedMessage(String messageKey) {
        return messageSource.getMessage(messageKey, null, getLocale());
    }

//    public String getLocalizedLabel(String defaultLabel, String labelSq, String labelEn) {
//        Locale locale = getLocale();
//
//        if (locale.equals(Locales.LOCALE_SQ) && labelSq != null) {
//            return labelSq;
//        }
//
//        else if(locale.equals(Locales.LOCALE_EN) && labelEn != null){
//            return labelEn;
//        }
//
//        return defaultLabel;
//    }

}
