package com.didi.sdk.map.language;

public class LocaleCodeHolder {

    /* renamed from: a */
    private LocaleCodeListener f36757a;

    public static LocaleCodeHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getCurrentLang() {
        LocaleCodeListener localeCodeListener = this.f36757a;
        return localeCodeListener != null ? localeCodeListener.getLocaleCode() : "";
    }

    public void setCurrentLang(LocaleCodeListener localeCodeListener) {
        this.f36757a = localeCodeListener;
    }

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final LocaleCodeHolder INSTANCE = new LocaleCodeHolder();

        private SingletonHolder() {
        }
    }
}
