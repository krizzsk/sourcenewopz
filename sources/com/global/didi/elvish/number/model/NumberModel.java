package com.global.didi.elvish.number.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u001e\u0010\u001b\u001a\u00020\u001c2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, mo175978d2 = {"Lcom/global/didi/elvish/number/model/NumberModel;", "", "decimal", "", "group", "precision", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getDecimal", "()Ljava/lang/String;", "setDecimal", "(Ljava/lang/String;)V", "getGroup", "setGroup", "getPrecision", "()Ljava/util/Map;", "setPrecision", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "parse", "", "map", "", "toString", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: NumberModel.kt */
public final class NumberModel {

    /* renamed from: a */
    private String f52582a;

    /* renamed from: b */
    private String f52583b;

    /* renamed from: c */
    private Map<String, Integer> f52584c;

    public NumberModel() {
        this((String) null, (String) null, (Map) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NumberModel copy$default(NumberModel numberModel, String str, String str2, Map<String, Integer> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = numberModel.f52582a;
        }
        if ((i & 2) != 0) {
            str2 = numberModel.f52583b;
        }
        if ((i & 4) != 0) {
            map = numberModel.f52584c;
        }
        return numberModel.copy(str, str2, map);
    }

    public final String component1() {
        return this.f52582a;
    }

    public final String component2() {
        return this.f52583b;
    }

    public final Map<String, Integer> component3() {
        return this.f52584c;
    }

    public final NumberModel copy(String str, String str2, Map<String, Integer> map) {
        Intrinsics.checkParameterIsNotNull(str, "decimal");
        Intrinsics.checkParameterIsNotNull(str2, "group");
        Intrinsics.checkParameterIsNotNull(map, "precision");
        return new NumberModel(str, str2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumberModel)) {
            return false;
        }
        NumberModel numberModel = (NumberModel) obj;
        return Intrinsics.areEqual((Object) this.f52582a, (Object) numberModel.f52582a) && Intrinsics.areEqual((Object) this.f52583b, (Object) numberModel.f52583b) && Intrinsics.areEqual((Object) this.f52584c, (Object) numberModel.f52584c);
    }

    public int hashCode() {
        String str = this.f52582a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f52583b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, Integer> map = this.f52584c;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "NumberModel(decimal=" + this.f52582a + ", group=" + this.f52583b + ", precision=" + this.f52584c + ")";
    }

    public NumberModel(String str, String str2, Map<String, Integer> map) {
        Intrinsics.checkParameterIsNotNull(str, "decimal");
        Intrinsics.checkParameterIsNotNull(str2, "group");
        Intrinsics.checkParameterIsNotNull(map, "precision");
        this.f52582a = str;
        this.f52583b = str2;
        this.f52584c = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NumberModel(String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new LinkedHashMap() : map);
    }

    public final String getDecimal() {
        return this.f52582a;
    }

    public final String getGroup() {
        return this.f52583b;
    }

    public final Map<String, Integer> getPrecision() {
        return this.f52584c;
    }

    public final void setDecimal(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f52582a = str;
    }

    public final void setGroup(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f52583b = str;
    }

    public final void setPrecision(Map<String, Integer> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.f52584c = map;
    }

    public final void parse(Map<String, ? extends Object> map) {
        if (map != null) {
            if (map.get("decimal") != null) {
                this.f52582a = String.valueOf(map.get("decimal"));
            }
            if (map.get("group") != null) {
                this.f52583b = String.valueOf(map.get("group"));
            }
            Object obj = map.get("precision");
            if (!TypeIntrinsics.isMutableMap(obj)) {
                obj = null;
            }
            Map map2 = (Map) obj;
            if (map2 != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    this.f52584c.put(entry.getKey(), Integer.valueOf(((Number) entry.getValue()).intValue()));
                }
            }
        }
    }
}
