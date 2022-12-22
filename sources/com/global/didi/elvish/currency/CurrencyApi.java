package com.global.didi.elvish.currency;

import android.content.Context;
import com.global.didi.elvish.LocationInfo;
import com.global.didi.elvish.util.LogUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J,\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ,\u0010\u0011\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0012\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J0\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0010\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0004\n\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/global/didi/elvish/currency/CurrencyApi;", "", "context", "Landroid/content/Context;", "locationInfo", "Lcom/global/didi/elvish/LocationInfo;", "(Landroid/content/Context;Lcom/global/didi/elvish/LocationInfo;)V", "conf", "Lcom/global/didi/elvish/currency/CurrencyConf;", "conf$1", "currencyInLocale", "Ljava/text/NumberFormat;", "currencyCode", "", "language", "country", "variant", "formatCurrency", "number", "", "isHighlight", "", "currencyAcronym", "localeString", "countryCode", "getDecimalSymbol", "getGroupSymbol", "getNumberFormatter", "numberFormatInLocale", "splitCurrency", "", "Companion", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: CurrencyApi.kt */
public final class CurrencyApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile CurrencyConf f52558c;

    /* renamed from: a */
    private CurrencyConf f52559a;

    /* renamed from: b */
    private final LocationInfo f52560b;

    public CurrencyApi(Context context, LocationInfo locationInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locationInfo, "locationInfo");
        this.f52560b = locationInfo;
        this.f52559a = Companion.getConf(context);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/global/didi/elvish/currency/CurrencyApi$Companion;", "", "()V", "conf", "Lcom/global/didi/elvish/currency/CurrencyConf;", "getConf", "context", "Landroid/content/Context;", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: CurrencyApi.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final CurrencyConf getConf(Context context) {
            CurrencyConf access$getConf$cp = CurrencyApi.f52558c;
            if (access$getConf$cp == null) {
                synchronized (this) {
                    access$getConf$cp = CurrencyApi.f52558c;
                    if (access$getConf$cp == null) {
                        access$getConf$cp = new CurrencyConf(context);
                        CurrencyApi.f52558c = access$getConf$cp;
                    }
                }
            }
            return access$getConf$cp;
        }
    }

    public final String formatCurrency(Number number, boolean z) {
        if (number == null) {
            return "";
        }
        try {
            String format = m37305a(z).format(number);
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.print("formatCurrency : " + format);
            Intrinsics.checkExpressionValueIsNotNull(format, "result");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String formatCurrency(Number number, boolean z, String str, String str2) {
        if (number != null) {
            try {
                String format = m37304a(str, str2, "", z).format(number);
                LogUtils logUtils = LogUtils.INSTANCE;
                logUtils.print("formatCurrency : " + format);
                Intrinsics.checkExpressionValueIsNotNull(format, "result");
                return format;
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final String formatCurrency(String str, String str2, Number number, boolean z) {
        if (number != null) {
            try {
                String format = m37304a("", str2, str, z).format(number);
                LogUtils logUtils = LogUtils.INSTANCE;
                logUtils.print("formatCurrency : " + format);
                Intrinsics.checkExpressionValueIsNotNull(format, "result");
                return format;
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* renamed from: a */
    static /* synthetic */ NumberFormat m37301a(CurrencyApi currencyApi, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return currencyApi.m37305a(z);
    }

    /* renamed from: a */
    private final NumberFormat m37305a(boolean z) {
        NumberFormat numberFormat;
        String formatterRule = this.f52559a.getFormatterRule(this.f52560b.getLocaleString(), this.f52560b.getCountry(), z, ElvishRuleType.ElvishRuleTypeCurrency);
        boolean z2 = true;
        if (formatterRule.length() > 0) {
            NumberFormat decimalFormat = new DecimalFormat(formatterRule);
            CurrencyConf currencyConf = this.f52559a;
            DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(this.f52560b.getLocale());
            String decimalSymbol = currencyConf.getDecimalSymbol(this.f52560b.getLocaleString());
            String str = null;
            if (!(decimalSymbol.length() > 0)) {
                decimalSymbol = null;
            }
            if (decimalSymbol != null) {
                Intrinsics.checkExpressionValueIsNotNull(instance, "decimalFormatSymbol");
                if (decimalSymbol != null) {
                    char[] charArray = decimalSymbol.toCharArray();
                    Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
                    instance.setDecimalSeparator(ArraysKt.first(charArray));
                    if (decimalSymbol != null) {
                        char[] charArray2 = decimalSymbol.toCharArray();
                        Intrinsics.checkExpressionValueIsNotNull(charArray2, "(this as java.lang.String).toCharArray()");
                        instance.setMonetaryDecimalSeparator(ArraysKt.first(charArray2));
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            String groupSymbol = currencyConf.getGroupSymbol(this.f52560b.getLocaleString());
            if (groupSymbol.length() <= 0) {
                z2 = false;
            }
            if (z2) {
                str = groupSymbol;
            }
            if (str != null) {
                Intrinsics.checkExpressionValueIsNotNull(instance, "decimalFormatSymbol");
                if (str != null) {
                    char[] charArray3 = str.toCharArray();
                    Intrinsics.checkExpressionValueIsNotNull(charArray3, "(this as java.lang.String).toCharArray()");
                    instance.setGroupingSeparator(ArraysKt.first(charArray3));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            Intrinsics.checkExpressionValueIsNotNull(instance, "decimalFormatSymbol");
            instance.setZeroDigit('0');
            DecimalFormat decimalFormat2 = (DecimalFormat) decimalFormat;
            decimalFormat2.setDecimalFormatSymbols(instance);
            decimalFormat2.applyPattern(formatterRule);
            return decimalFormat;
        }
        String currencyCode = this.f52559a.getCurrencyCode(this.f52560b.getCountry());
        String str2 = (String) CollectionsKt.first(StringsKt.split$default((CharSequence) this.f52560b.getLocaleString(), new String[]{"-"}, false, 0, 6, (Object) null));
        if (currencyCode.length() != 0) {
            z2 = false;
        }
        if (z2) {
            numberFormat = m37298a(this, str2, this.f52560b.getCountry(), (String) null, 4, (Object) null);
        } else {
            numberFormat = m37299a(this, currencyCode, str2, this.f52560b.getCountry(), (String) null, 8, (Object) null);
        }
        return numberFormat;
    }

    /* renamed from: a */
    static /* synthetic */ NumberFormat m37300a(CurrencyApi currencyApi, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return currencyApi.m37304a(str, str2, str3, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.text.NumberFormat m37304a(java.lang.String r17, java.lang.String r18, java.lang.String r19, boolean r20) {
        /*
            r16 = this;
            r7 = r16
            r8 = 0
            if (r18 == 0) goto L_0x0032
            r0 = r19
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001f
            com.global.didi.elvish.LocationInfo r9 = new com.global.didi.elvish.LocationInfo
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r9
            r1 = r18
            r2 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x0033
        L_0x001f:
            if (r19 == 0) goto L_0x0032
            com.global.didi.elvish.LocationInfo r9 = new com.global.didi.elvish.LocationInfo
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r9
            r1 = r18
            r2 = r18
            r3 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x0033
        L_0x0032:
            r9 = r8
        L_0x0033:
            if (r9 != 0) goto L_0x0037
            com.global.didi.elvish.LocationInfo r9 = r7.f52560b
        L_0x0037:
            com.global.didi.elvish.currency.CurrencyConf r0 = r7.f52559a
            java.lang.String r1 = r9.getLocaleString()
            java.lang.String r2 = r9.getCountry()
            com.global.didi.elvish.currency.ElvishRuleType r4 = com.global.didi.elvish.currency.ElvishRuleType.ElvishRuleTypeCurrency
            r3 = r20
            r5 = r17
            java.lang.String r0 = r0.getFormatterRule(r1, r2, r3, r4, r5)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x0058
            r1 = 1
            goto L_0x0059
        L_0x0058:
            r1 = 0
        L_0x0059:
            if (r1 == 0) goto L_0x0100
            java.text.DecimalFormat r1 = new java.text.DecimalFormat
            r1.<init>(r0)
            java.text.NumberFormat r1 = (java.text.NumberFormat) r1
            com.global.didi.elvish.currency.CurrencyConf r4 = r7.f52559a
            java.util.Locale r5 = r9.getLocale()
            java.text.DecimalFormatSymbols r5 = java.text.DecimalFormatSymbols.getInstance(r5)
            java.lang.String r6 = r9.getLocaleString()
            java.lang.String r6 = r4.getDecimalSymbol(r6)
            r10 = r6
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x007f
            r10 = 1
            goto L_0x0080
        L_0x007f:
            r10 = 0
        L_0x0080:
            if (r10 == 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r6 = r8
        L_0x0084:
            java.lang.String r10 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r11 = "(this as java.lang.String).toCharArray()"
            java.lang.String r12 = "decimalFormatSymbol"
            if (r6 == 0) goto L_0x00bc
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r12)
            if (r6 == 0) goto L_0x00b6
            char[] r13 = r6.toCharArray()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r11)
            char r13 = kotlin.collections.ArraysKt.first((char[]) r13)
            r5.setDecimalSeparator(r13)
            if (r6 == 0) goto L_0x00b0
            char[] r6 = r6.toCharArray()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r11)
            char r6 = kotlin.collections.ArraysKt.first((char[]) r6)
            r5.setMonetaryDecimalSeparator(r6)
            goto L_0x00bc
        L_0x00b0:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r10)
            throw r0
        L_0x00b6:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r10)
            throw r0
        L_0x00bc:
            java.lang.String r6 = r9.getLocaleString()
            java.lang.String r4 = r4.getGroupSymbol(r6)
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r2 = 0
        L_0x00cf:
            if (r2 == 0) goto L_0x00d2
            r8 = r4
        L_0x00d2:
            if (r8 == 0) goto L_0x00ee
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r12)
            if (r8 == 0) goto L_0x00e8
            char[] r2 = r8.toCharArray()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r11)
            char r2 = kotlin.collections.ArraysKt.first((char[]) r2)
            r5.setGroupingSeparator(r2)
            goto L_0x00ee
        L_0x00e8:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r10)
            throw r0
        L_0x00ee:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r12)
            r2 = 48
            r5.setZeroDigit(r2)
            r2 = r1
            java.text.DecimalFormat r2 = (java.text.DecimalFormat) r2
            r2.setDecimalFormatSymbols(r5)
            r2.applyPattern(r0)
            goto L_0x0157
        L_0x0100:
            com.global.didi.elvish.currency.CurrencyConf r0 = r7.f52559a
            java.lang.String r1 = r9.getCountry()
            java.lang.String r1 = r0.getCurrencyCode(r1)
            java.lang.String r0 = r9.getLocaleString()
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.String r0 = "-"
            java.lang.String[] r11 = new java.lang.String[]{r0}
            r12 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r10, (java.lang.String[]) r11, (boolean) r12, (int) r13, (int) r14, (java.lang.Object) r15)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r2 = 0
        L_0x0131:
            if (r2 == 0) goto L_0x0144
            java.lang.String r2 = r9.getCountry()
            r3 = 0
            r5 = 4
            r6 = 0
            r0 = r16
            r1 = r4
            r4 = r5
            r5 = r6
            java.text.NumberFormat r0 = m37298a(r0, r1, r2, r3, r4, r5)
            goto L_0x0156
        L_0x0144:
            java.lang.String r3 = r9.getCountry()
            r5 = 0
            r6 = 8
            r8 = 0
            r0 = r16
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            java.text.NumberFormat r0 = m37299a((com.global.didi.elvish.currency.CurrencyApi) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (java.lang.Object) r6)
        L_0x0156:
            r1 = r0
        L_0x0157:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.global.didi.elvish.currency.CurrencyApi.m37304a(java.lang.String, java.lang.String, java.lang.String, boolean):java.text.NumberFormat");
    }

    /* renamed from: a */
    static /* synthetic */ NumberFormat m37299a(CurrencyApi currencyApi, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        return currencyApi.m37303a(str, str2, str3, str4);
    }

    /* renamed from: a */
    private final NumberFormat m37303a(String str, String str2, String str3, String str4) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale(str2, str3, str4));
        Intrinsics.checkExpressionValueIsNotNull(currencyInstance, "format");
        currencyInstance.setCurrency(Currency.getInstance(str));
        if (currencyInstance instanceof DecimalFormat) {
            DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
            DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
            Intrinsics.checkExpressionValueIsNotNull(decimalFormatSymbols, "decimalFormatSymbols");
            decimalFormatSymbols.setZeroDigit('0');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        return currencyInstance;
    }

    /* renamed from: a */
    static /* synthetic */ NumberFormat m37298a(CurrencyApi currencyApi, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        return currencyApi.m37302a(str, str2, str3);
    }

    /* renamed from: a */
    private final NumberFormat m37302a(String str, String str2, String str3) {
        NumberFormat instance = NumberFormat.getInstance(new Locale(str, str2, str3));
        if (instance instanceof DecimalFormat) {
            DecimalFormat decimalFormat = (DecimalFormat) instance;
            DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
            Intrinsics.checkExpressionValueIsNotNull(decimalFormatSymbols, "decimalFormatSymbols");
            decimalFormatSymbols.setZeroDigit('0');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        Intrinsics.checkExpressionValueIsNotNull(instance, "format");
        return instance;
    }

    public final List<String> splitCurrency(Number number) {
        String str;
        String formatCurrency = formatCurrency(number, true);
        Pattern compile = Pattern.compile("\\{.*\\}");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(regex)");
        Matcher matcher = compile.matcher(formatCurrency);
        Intrinsics.checkExpressionValueIsNotNull(matcher, "compile.matcher(ret)");
        if (matcher.find()) {
            str = matcher.group();
            Intrinsics.checkExpressionValueIsNotNull(str, "matcher.group()");
        } else {
            str = "";
        }
        String str2 = str;
        int length = str2.length() - 1;
        if (str2 != null) {
            String substring = str2.substring(1, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(formatCurrency, str2, "", false, 4, (Object) null);
            if (replace$default != null) {
                return CollectionsKt.listOf(substring, StringsKt.trim(replace$default).toString());
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String getDecimalSymbol() {
        return this.f52559a.getDecimalSymbol(this.f52560b.getLocaleString());
    }

    public final String getGroupSymbol() {
        return this.f52559a.getGroupSymbol(this.f52560b.getLocaleString());
    }
}
