package com.didi.entrega.customer.foundation.util.locale;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.foundation.sdk.mlocale.DateStyle;
import com.didi.foundation.sdk.mlocale.TimeStyle;
import com.didi.foundation.sdk.service.LocalizationService;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryManager;
import java.util.Iterator;
import java.util.List;

public final class LocalizationUtils {

    /* renamed from: a */
    private static final String f20163a = "LocalizationUtils";

    private LocalizationUtils() {
    }

    public static boolean isPhoneValida(String str, String str2) {
        int i;
        List<CountryListResponse.CountryRule> countries = CountryManager.getIns().getCountries();
        if (!TextUtils.isEmpty(str) && !CollectionsUtil.isEmpty(countries) && !TextUtils.isEmpty(str2)) {
            String str3 = null;
            Iterator<CountryListResponse.CountryRule> it = countries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = 0;
                    break;
                }
                CountryListResponse.CountryRule next = it.next();
                if (str2.equals(next.calling_code)) {
                    str3 = next.format;
                    i = next.max_len;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str3) && i != 0) {
                int length = str3.replaceAll(" ", "").length();
                try {
                    Long.parseLong(str);
                    if ("+55".equals(str2)) {
                        if (str.length() < 10 || str.length() > 11) {
                            return false;
                        }
                        return true;
                    } else if (str.startsWith("000")) {
                        if (str.length() >= length) {
                            return true;
                        }
                        return false;
                    } else if (str.length() < length || str.length() > i) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private static String m14850a() {
        return ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
    }

    public static final class DateUtils {
        private DateUtils() {
        }

        public static String getCustomDate(long j, DateStyle dateStyle, TimeStyle timeStyle) {
            return LocalizationService.getInstance().formatDateTime(j, dateStyle, timeStyle, true);
        }

        public static String getFullDate(long j) {
            return LocalizationService.getInstance().formatDateTime(j, DateStyle.DATE_DD_MM_YYYY, TimeStyle.NONE, true);
        }

        public static String getPartDate(long j) {
            return LocalizationService.getInstance().formatDateTime(j, DateStyle.DATE_DD_MTH, TimeStyle.NONE, true);
        }

        public static String getPartTime(long j) {
            return LocalizationService.getInstance().formatDateTime(j, DateStyle.NONE, TimeStyle.TIME_HH_MM, true);
        }

        public static String getFullDateTime(long j) {
            return LocalizationService.getInstance().formatDateTime(j, DateStyle.DATE_DD_MM_YYYY, TimeStyle.TIME_HH_MM, true);
        }

        public static String getPartDateTime(long j) {
            return LocalizationService.getInstance().formatDateTime(j, DateStyle.DATE_DD_MTH, TimeStyle.TIME_HH_MM, true);
        }
    }

    public static final class CurrencyUtils {
        private CurrencyUtils() {
        }

        public static String getCurrencyDisplay(String str, long j, String str2, String str3) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return getCurrency(j, str2);
        }

        @Deprecated
        public static String getCurrency(long j, String str) {
            return LocalizationService.getInstance().formatCurrency((int) j, str, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag(), (Boolean) false);
        }

        @Deprecated
        public static String getSimplifiedCurrencyWithSymbol(long j, String str) {
            return LocalizationService.getInstance().formatCurrency((int) j, str, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag(), (Boolean) false);
        }

        public static String getSimplifiedCurrencyWithSymbolDisplay(String str, long j, String str2, String str3) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return getSimplifiedCurrencyWithSymbol(j, str2);
        }

        public static String getCurrencySymbol(String str) {
            List splitCurrency = LocalizationService.getInstance().splitCurrency(str, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
            return (splitCurrency == null || splitCurrency.size() < 2) ? "" : (String) splitCurrency.get(1);
        }

        @Deprecated
        public static SpannableString getSpannableCurrency(long j, String str, int i, int i2) {
            String currency = getCurrency(j, str);
            String currencySymbol = getCurrencySymbol(str);
            int indexOf = currency.indexOf(currencySymbol);
            int length = currencySymbol.length() + indexOf;
            SpannableString spannableString = new SpannableString(currency);
            spannableString.setSpan(new AbsoluteSizeSpan(i2, true), indexOf, length, 33);
            if (indexOf == 0) {
                spannableString.setSpan(new AbsoluteSizeSpan(i), length, currency.length(), 33);
            } else {
                spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, indexOf, 33);
            }
            return spannableString;
        }

        public static boolean isJPYLocalLang(String str) {
            return TextUtils.equals(str, "JPY") && "ja-JP".startsWith(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        }

        public static boolean isJPYOtherLang(String str) {
            return TextUtils.equals(str, "JPY") && !"ja-JP".startsWith(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        }
    }

    public static final class DurationUtils {
        private DurationUtils() {
        }
    }
}
