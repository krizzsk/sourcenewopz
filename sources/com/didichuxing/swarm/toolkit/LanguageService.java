package com.didichuxing.swarm.toolkit;

import java.util.List;

public interface LanguageService {
    public static final String LANGUAGE_CHINESE_HK = "zh-HK";
    public static final String LANGUAGE_CHINESE_SIMPLIFIED = "zh-CN";
    public static final String LANGUAGE_CHINESE_TW = "zh-TW";
    public static final String LANGUAGE_ENGLISH = "en-US";
    public static final String LANGUAGE_PORTUGAL = "portugal";
    public static final String LANGUAGE_PORTUGAL_BR = "pt-BR";
    public static final String LANGUAGE_SPAIN_MX = "es-MX";

    public interface OnLanguageChangedListener {
        void onLanguageChanged(String str, String str2);
    }

    void addOnLanguageChangedListener(OnLanguageChangedListener onLanguageChangedListener);

    String getLanguage();

    List<OnLanguageChangedListener> getOnLanguageChangedListeners();

    void removeOnLanguageChangedListener(OnLanguageChangedListener onLanguageChangedListener);
}
