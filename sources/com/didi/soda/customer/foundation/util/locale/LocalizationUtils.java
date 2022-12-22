package com.didi.soda.customer.foundation.util.locale;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.didi.foundation.sdk.mlocale.DateStyle;
import com.didi.foundation.sdk.mlocale.TimeStyle;
import com.didi.foundation.sdk.service.LocalizationService;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.CurrencyDisplayEntity;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import java.util.List;

public final class LocalizationUtils {

    /* renamed from: a */
    private static final String f41265a = "LocalizationUtils";

    private LocalizationUtils() {
    }

    /* renamed from: a */
    private static String m29226a() {
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
            trackCurrencyDisplayError(str3);
            return getCurrency(j, str2);
        }

        public static SpannableString getSpannableCurrency(CurrencyDisplayEntity currencyDisplayEntity, long j, String str, int i, int i2, boolean z) {
            if (currencyDisplayEntity != null && !TextUtils.isEmpty(currencyDisplayEntity.symbol)) {
                StringBuilder sb = new StringBuilder();
                if (z) {
                    sb.append(currencyDisplayEntity.sign);
                    String str2 = TextUtils.isEmpty(currencyDisplayEntity.number) ? "" : " ";
                    if (currencyDisplayEntity.position == 0) {
                        sb.append(currencyDisplayEntity.symbol);
                        sb.append(str2);
                        sb.append(currencyDisplayEntity.number);
                    } else {
                        sb.append(currencyDisplayEntity.number);
                        sb.append(str2);
                        sb.append(currencyDisplayEntity.symbol);
                    }
                } else {
                    sb.append(currencyDisplayEntity.display);
                }
                if (!TextUtils.isEmpty(sb)) {
                    SpannableString spannableString = new SpannableString(sb);
                    int length = spannableString.length();
                    spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, length, 17);
                    int indexOf = sb.indexOf(currencyDisplayEntity.symbol);
                    int length2 = currencyDisplayEntity.symbol.length();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("font:");
                    sb2.append(indexOf);
                    sb2.append("~");
                    int i3 = length2 + indexOf;
                    sb2.append(i3);
                    LogUtil.m29104i(LocalizationUtils.f41265a, sb2.toString());
                    if (indexOf >= 0 && i3 <= length) {
                        spannableString.setSpan(new AbsoluteSizeSpan(i2, true), indexOf, i3, 17);
                    }
                    return spannableString;
                }
            }
            LogUtil.m29102e(LocalizationUtils.f41265a, "currency display is empty in getSpannableCurrency");
            return getSpannableCurrency(j, str, i, i2);
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
            trackCurrencyDisplayError(str3);
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

        private static void trackCurrencyDisplayError(String str) {
            LogUtil.m29102e("CurrencyUtils", "currency display is empty in " + str);
        }
    }

    public static final class DurationUtils {
        private DurationUtils() {
        }
    }
}
