package com.didi.rfusion.config;

import com.didi.rfusion.RFusion;
import java.util.Locale;

public class RFLocale {
    public static final String CHINESE = "zh";
    public static final String ENGLISH = "en";
    public static final String JAPANESE = "ja";
    public static final String PORTUGUESE = "pt";
    public static final String SPANISH = "es";

    public static String getLanguage() {
        Locale locale = RFusion.getLocale();
        return locale != null ? locale.getLanguage() : "";
    }
}
