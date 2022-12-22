package com.didi.soda.customer.foundation.locale;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class CustomerLocaleUtil {
    public static final String TAG_EN_US = "en-US";
    public static final String TAG_ES_419 = "es-419";
    public static final String TAG_ES_MX = "es-MX";
    public static final String TAG_JA_JP = "ja-JP";
    public static final String TAG_PT_BR = "pt-BR";

    /* renamed from: a */
    private static List<Locale> f40922a = new ArrayList();

    /* renamed from: b */
    private static List<String> f40923b = new ArrayList();

    /* renamed from: c */
    private static Map<String, Boolean> f40924c = new HashMap();

    private CustomerLocaleUtil() {
    }

    public static List<Locale> getSupportLocaleList() {
        try {
            return ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getSupportList();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static List<String> getsSupportLocaleStringList() {
        if (CollectionsUtil.isEmpty(f40923b)) {
            for (Locale next : getSupportLocaleList()) {
                List<String> list = f40923b;
                list.add(next.getLanguage() + "-" + next.getCountry());
            }
            f40923b.add("en-US");
            f40924c.clear();
            for (String split : f40923b) {
                String[] split2 = split.split("-");
                if (split2 != null && split2.length > 0) {
                    Map<String, Boolean> map = f40924c;
                    map.put(split2[0], Boolean.valueOf(map.containsKey(split2[0])));
                }
            }
        }
        return f40923b;
    }

    public static boolean isInSameLanguageFamily(Locale locale) {
        return locale != null && !TextUtils.isEmpty(locale.getLanguage()) && Boolean.TRUE.equals(f40924c.get(locale.getLanguage()));
    }
}
