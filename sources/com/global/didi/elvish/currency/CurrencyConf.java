package com.global.didi.elvish.currency;

import android.content.Context;
import android.text.TextUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.base.BaseConf;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J0\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/global/didi/elvish/currency/CurrencyConf;", "Lcom/global/didi/elvish/base/BaseConf;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currencyCountryConf", "", "", "getCurrencyCode", "country", "getCurrencyRegexString", "getFormatterRule", "locale", "isHighlight", "", "type", "Lcom/global/didi/elvish/currency/ElvishRuleType;", "currencyAcronym", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: CurrencyConf.kt */
public final class CurrencyConf extends BaseConf {

    /* renamed from: a */
    private Map<String, String> f52561a = new LinkedHashMap();

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ElvishRuleType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ElvishRuleType.ElvishRuleTypeCurrency.ordinal()] = 1;
            int[] iArr2 = new int[ElvishRuleType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ElvishRuleType.ElvishRuleTypeCurrency.ordinal()] = 1;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CurrencyConf(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f52561a = new CurrencyStore().loadLocalCurrencyCountryConf(context);
    }

    public final String getFormatterRule(String str, String str2, boolean z, ElvishRuleType elvishRuleType) {
        String str3;
        Intrinsics.checkParameterIsNotNull(str, "locale");
        Intrinsics.checkParameterIsNotNull(str2, "country");
        Intrinsics.checkParameterIsNotNull(elvishRuleType, "type");
        Map<String, Object> localCustomRuleConf = Elvish.Companion.getLocalCustomRuleConf();
        boolean z2 = false;
        if ((localCustomRuleConf == null || localCustomRuleConf.isEmpty()) || WhenMappings.$EnumSwitchMapping$0[elvishRuleType.ordinal()] != 1) {
            return "";
        }
        Object obj = Elvish.Companion.getLocalCustomRuleConf().get("currency");
        if (obj != null) {
            Map map = (Map) obj;
            String str4 = this.f52561a.get(str2);
            if (str4 == null) {
                return "";
            }
            Object obj2 = map.get(str4);
            if (obj2 == null) {
                obj2 = new HashMap();
            }
            if (obj2 != null) {
                Map map2 = (Map) obj2;
                Map emptyMap = MapsKt.emptyMap();
                String replace$default = StringsKt.replace$default(str, "_", "-", false, 4, (Object) null);
                if (map2.containsKey(replace$default)) {
                    Object obj3 = map2.get(replace$default);
                    if (obj3 == null) {
                        obj3 = new HashMap();
                    }
                    if (obj3 != null) {
                        emptyMap = (Map) obj3;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    }
                } else if (map2.containsKey(str)) {
                    Object obj4 = map2.get(str);
                    if (obj4 == null) {
                        obj4 = new HashMap();
                    }
                    if (obj4 != null) {
                        emptyMap = (Map) obj4;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    }
                } else if (map2.containsKey("default")) {
                    Object obj5 = map2.get("default");
                    if (obj5 == null) {
                        obj5 = new HashMap();
                    }
                    if (obj5 != null) {
                        emptyMap = (Map) obj5;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    }
                }
                if (emptyMap == null || emptyMap.isEmpty()) {
                    z2 = true;
                }
                if (z2) {
                    return "";
                }
                if (z) {
                    str3 = (String) emptyMap.get("hpattern");
                    if (str3 == null) {
                        return "";
                    }
                } else {
                    str3 = (String) emptyMap.get("pattern");
                    if (str3 == null) {
                        return "";
                    }
                }
                return str3;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    public final String getFormatterRule(String str, String str2, boolean z, ElvishRuleType elvishRuleType, String str3) {
        String str4;
        Intrinsics.checkParameterIsNotNull(str, "locale");
        Intrinsics.checkParameterIsNotNull(str2, "country");
        Intrinsics.checkParameterIsNotNull(elvishRuleType, "type");
        Map<String, Object> localCustomRuleConf = Elvish.Companion.getLocalCustomRuleConf();
        boolean z2 = false;
        if ((localCustomRuleConf == null || localCustomRuleConf.isEmpty()) || WhenMappings.$EnumSwitchMapping$1[elvishRuleType.ordinal()] != 1) {
            return "";
        }
        Object obj = Elvish.Companion.getLocalCustomRuleConf().get("currency");
        if (obj != null) {
            Map map = (Map) obj;
            if (TextUtils.isEmpty(str3) && (str3 = this.f52561a.get(str2)) == null) {
                return "";
            }
            Object obj2 = map.get(str3);
            if (obj2 == null) {
                obj2 = new HashMap();
            }
            if (obj2 != null) {
                Map map2 = (Map) obj2;
                Map emptyMap = MapsKt.emptyMap();
                String replace$default = StringsKt.replace$default(str, "_", "-", false, 4, (Object) null);
                if (map2.containsKey(replace$default)) {
                    Object obj3 = map2.get(replace$default);
                    if (obj3 == null) {
                        obj3 = new HashMap();
                    }
                    if (obj3 != null) {
                        emptyMap = (Map) obj3;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    }
                } else if (map2.containsKey(str)) {
                    Object obj4 = map2.get(str);
                    if (obj4 == null) {
                        obj4 = new HashMap();
                    }
                    if (obj4 != null) {
                        emptyMap = (Map) obj4;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    }
                } else if (map2.containsKey("default")) {
                    Object obj5 = map2.get("default");
                    if (obj5 == null) {
                        obj5 = new HashMap();
                    }
                    if (obj5 != null) {
                        emptyMap = (Map) obj5;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    }
                }
                if (emptyMap == null || emptyMap.isEmpty()) {
                    z2 = true;
                }
                if (z2) {
                    return "";
                }
                if (z) {
                    str4 = (String) emptyMap.get("hpattern");
                    if (str4 == null) {
                        return "";
                    }
                } else {
                    str4 = (String) emptyMap.get("pattern");
                    if (str4 == null) {
                        return "";
                    }
                }
                return str4;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    public final String getCurrencyRegexString() {
        String decode;
        Object obj = Elvish.Companion.getLocalCustomRuleConf().get(BlocksConst.BLOCK_FONT_REGULAR);
        if (obj == null) {
            obj = new HashMap();
        }
        if (obj != null) {
            Object obj2 = ((Map) obj).get("currency_amount_display_regular");
            String str = null;
            String obj3 = obj2 != null ? obj2.toString() : null;
            CharSequence charSequence = obj3;
            if (!(charSequence == null || charSequence.length() == 0)) {
                str = obj3;
            }
            return (str == null || (decode = URLDecoder.decode(str, "utf-8")) == null) ? "[^.,{}#\\-0-9]" : decode;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    public final String getCurrencyCode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "country");
        return this.f52561a.containsKey(str) ? (String) MapsKt.getValue(this.f52561a, str) : "";
    }
}
