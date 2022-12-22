package com.global.didi.elvish.base;

import android.content.Context;
import com.global.didi.elvish.Elvish;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/global/didi/elvish/base/BaseConf;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDecimalSymbol", "", "locale", "getGroupSymbol", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: BaseConf.kt */
public class BaseConf {
    public BaseConf(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public final String getDecimalSymbol(String str) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        Object obj = Elvish.Companion.getLocalCustomRuleConf().get("number");
        if (obj == null) {
            obj = new HashMap();
        }
        if (obj != null) {
            Map map = (Map) obj;
            Map emptyMap = MapsKt.emptyMap();
            String replace$default = StringsKt.replace$default(str, "_", "-", false, 4, (Object) null);
            if (map.containsKey(replace$default)) {
                Object obj2 = map.get(replace$default);
                if (obj2 == null) {
                    obj2 = new HashMap();
                }
                if (obj2 != null) {
                    emptyMap = (Map) obj2;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
            } else if (map.containsKey(str)) {
                Object obj3 = map.get(str);
                if (obj3 == null) {
                    obj3 = new HashMap();
                }
                if (obj3 != null) {
                    emptyMap = (Map) obj3;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
            }
            if (emptyMap == null || emptyMap.isEmpty()) {
                return "";
            }
            return String.valueOf(emptyMap.get("decimal"));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    public final String getGroupSymbol(String str) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        Object obj = Elvish.Companion.getLocalCustomRuleConf().get("number");
        if (obj == null) {
            obj = new HashMap();
        }
        if (obj != null) {
            Map map = (Map) obj;
            Map emptyMap = MapsKt.emptyMap();
            String replace$default = StringsKt.replace$default(str, "_", "-", false, 4, (Object) null);
            if (map.containsKey(replace$default)) {
                Object obj2 = map.get(replace$default);
                if (obj2 != null) {
                    emptyMap = (Map) obj2;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
            } else if (map.containsKey(str)) {
                Object obj3 = map.get(str);
                if (obj3 != null) {
                    emptyMap = (Map) obj3;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
            }
            if (emptyMap == null || emptyMap.isEmpty()) {
                return "";
            }
            return String.valueOf(emptyMap.get("group"));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }
}
