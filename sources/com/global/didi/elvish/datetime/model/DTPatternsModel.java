package com.global.didi.elvish.datetime.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0004J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0014"}, mo175978d2 = {"Lcom/global/didi/elvish/datetime/model/DTPatternsModel;", "", "patternMap", "", "", "Lcom/global/didi/elvish/datetime/model/DTPattern;", "(Ljava/util/Map;)V", "getPatternMap", "()Ljava/util/Map;", "setPatternMap", "component1", "copy", "equals", "", "other", "getPatternModel", "locale", "hashCode", "", "toString", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: DTPatternsModel.kt */
public final class DTPatternsModel {

    /* renamed from: a */
    private Map<String, DTPattern> f52575a;

    public DTPatternsModel() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DTPatternsModel copy$default(DTPatternsModel dTPatternsModel, Map<String, DTPattern> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = dTPatternsModel.f52575a;
        }
        return dTPatternsModel.copy(map);
    }

    public final Map<String, DTPattern> component1() {
        return this.f52575a;
    }

    public final DTPatternsModel copy(Map<String, DTPattern> map) {
        Intrinsics.checkParameterIsNotNull(map, "patternMap");
        return new DTPatternsModel(map);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DTPatternsModel) && Intrinsics.areEqual((Object) this.f52575a, (Object) ((DTPatternsModel) obj).f52575a);
        }
        return true;
    }

    public int hashCode() {
        Map<String, DTPattern> map = this.f52575a;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DTPatternsModel(patternMap=" + this.f52575a + ")";
    }

    public DTPatternsModel(Map<String, DTPattern> map) {
        Intrinsics.checkParameterIsNotNull(map, "patternMap");
        this.f52575a = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DTPatternsModel(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }

    public final Map<String, DTPattern> getPatternMap() {
        return this.f52575a;
    }

    public final void setPatternMap(Map<String, DTPattern> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.f52575a = map;
    }

    public final DTPattern getPatternModel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        DTPattern dTPattern = this.f52575a.get(str);
        if (dTPattern == null) {
            return this.f52575a.get("default");
        }
        return dTPattern.getAlias().length() > 0 ? this.f52575a.get(dTPattern.getAlias()) : dTPattern;
    }
}
