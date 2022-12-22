package com.didi.unifylogin.country;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.listener.ListenerManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.sourceforge.pinyin4j.PinyinHelper;

public class CountrySortManager {

    /* renamed from: a */
    private static final String f44751a = "zh-CN";

    /* renamed from: a */
    private static String m31763a(String str, String str2) {
        String[] hanyuPinyinStringArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!"zh-CN".equals(str2) || (hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(str.charAt(0))) == null || hanyuPinyinStringArray.length <= 0) {
            return str.substring(0, 1);
        }
        return hanyuPinyinStringArray[0].substring(0, 1);
    }

    /* renamed from: b */
    private static List<CountryListResponse.CountryRule> m31764b(String str, String str2) {
        List<CountryListResponse.CountryRule> countries = CountryManager.getIns().getCountries();
        ArrayList arrayList = new ArrayList();
        if (countries == null) {
            return countries;
        }
        for (CountryListResponse.CountryRule next : countries) {
            if (TextUtils.isEmpty(next.letter)) {
                next.letter = m31763a(next.name, str2);
            }
            if (!TextUtils.isEmpty(next.name)) {
                if (TextUtils.isEmpty(str)) {
                    arrayList.add(next);
                } else if (next.name.toUpperCase().contains(str.toUpperCase().trim())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static List<CountrySectionData> getCountrySectionData(String str) {
        String language = ListenerManager.getGlobalizationListener() != null ? ListenerManager.getGlobalizationListener().getLanguage() : null;
        ArrayList arrayList = new ArrayList();
        List<CountryListResponse.CountryRule> b = m31764b(str, language);
        if (b != null && b.size() > 0) {
            Collections.sort(b, new Comparator<CountryListResponse.CountryRule>() {
                public int compare(CountryListResponse.CountryRule countryRule, CountryListResponse.CountryRule countryRule2) {
                    if (TextUtil.isEmpty(countryRule.letter) || TextUtil.isEmpty(countryRule2.letter)) {
                        return 0;
                    }
                    return countryRule.letter.compareTo(countryRule2.letter);
                }
            });
            CountrySectionData countrySectionData = new CountrySectionData();
            for (CountryListResponse.CountryRule next : b) {
                if (!TextUtils.isEmpty(next.letter)) {
                    if (!next.letter.equals(countrySectionData.letter)) {
                        countrySectionData = new CountrySectionData();
                        countrySectionData.letter = next.letter;
                        arrayList.add(countrySectionData);
                    }
                    countrySectionData.countryRules.add(next);
                }
            }
        }
        return arrayList;
    }
}
