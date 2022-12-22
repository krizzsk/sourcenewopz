package com.global.didi.elvish.distance;

import android.content.Context;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.base.BaseConf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/global/didi/elvish/distance/DistanceConf;", "Lcom/global/didi/elvish/base/BaseConf;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imperialCountryConf", "", "", "getFormatterRule", "locale", "distanceStyle", "Lcom/global/didi/elvish/DistanceStyle;", "isHighlight", "", "isImperial", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: DistanceConf.kt */
public final class DistanceConf extends BaseConf {

    /* renamed from: a */
    private List<String> f52579a = CollectionsKt.emptyList();

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DistanceStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DistanceStyle.M.ordinal()] = 1;
            $EnumSwitchMapping$0[DistanceStyle.KM.ordinal()] = 2;
            $EnumSwitchMapping$0[DistanceStyle.Mi.ordinal()] = 3;
            $EnumSwitchMapping$0[DistanceStyle.YARD.ordinal()] = 4;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DistanceConf(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public final String getFormatterRule(String str, DistanceStyle distanceStyle, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        Intrinsics.checkParameterIsNotNull(distanceStyle, "distanceStyle");
        Map<String, Object> localCustomRuleConf = Elvish.Companion.getLocalCustomRuleConf();
        boolean z2 = false;
        if (localCustomRuleConf == null || localCustomRuleConf.isEmpty()) {
            return "";
        }
        Object obj = Elvish.Companion.getLocalCustomRuleConf().get("distance");
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
                z2 = true;
            }
            if (z2) {
                Object obj4 = map.get("default");
                if (obj4 == null) {
                    obj4 = new HashMap();
                }
                if (obj4 != null) {
                    emptyMap = (Map) obj4;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
            }
            int i = WhenMappings.$EnumSwitchMapping$0[distanceStyle.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return "";
                        }
                        if (z) {
                            return String.valueOf(emptyMap.get("hyard"));
                        }
                        return String.valueOf(emptyMap.get("yard"));
                    } else if (z) {
                        return String.valueOf(emptyMap.get("hmile"));
                    } else {
                        return String.valueOf(emptyMap.get("mile"));
                    }
                } else if (z) {
                    return String.valueOf(emptyMap.get("hkilometer"));
                } else {
                    return String.valueOf(emptyMap.get("kilometer"));
                }
            } else if (z) {
                return String.valueOf(emptyMap.get("hmeter"));
            } else {
                return String.valueOf(emptyMap.get("meter"));
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
    }

    public final boolean isImperial(String str) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        if (this.f52579a.isEmpty()) {
            Object obj = Elvish.Companion.getLocalCustomRuleConf().get("imperial");
            if (obj != null) {
                Map map = (Map) obj;
                if (!(map == null || map.isEmpty())) {
                    Object obj2 = map.get("countries");
                    if (obj2 != null) {
                        this.f52579a = (List) obj2;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            }
        }
        for (String endsWith$default : this.f52579a) {
            if (StringsKt.endsWith$default(str, endsWith$default, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
