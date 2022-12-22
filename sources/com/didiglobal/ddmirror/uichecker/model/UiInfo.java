package com.didiglobal.ddmirror.uichecker.model;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/model/UiInfo;", "", "uiData", "Ljava/util/HashMap;", "", "rule", "Lcom/didiglobal/ddmirror/uichecker/model/UiRule;", "(Ljava/util/HashMap;Lcom/didiglobal/ddmirror/uichecker/model/UiRule;)V", "getRule", "()Lcom/didiglobal/ddmirror/uichecker/model/UiRule;", "setRule", "(Lcom/didiglobal/ddmirror/uichecker/model/UiRule;)V", "getUiData", "()Ljava/util/HashMap;", "setUiData", "(Ljava/util/HashMap;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiInfo.kt */
public final class UiInfo {
    private UiRule rule;
    private HashMap<String, String> uiData;

    public static /* synthetic */ UiInfo copy$default(UiInfo uiInfo, HashMap<String, String> hashMap, UiRule uiRule, int i, Object obj) {
        if ((i & 1) != 0) {
            hashMap = uiInfo.uiData;
        }
        if ((i & 2) != 0) {
            uiRule = uiInfo.rule;
        }
        return uiInfo.copy(hashMap, uiRule);
    }

    public final HashMap<String, String> component1() {
        return this.uiData;
    }

    public final UiRule component2() {
        return this.rule;
    }

    public final UiInfo copy(HashMap<String, String> hashMap, UiRule uiRule) {
        return new UiInfo(hashMap, uiRule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiInfo)) {
            return false;
        }
        UiInfo uiInfo = (UiInfo) obj;
        return Intrinsics.areEqual((Object) this.uiData, (Object) uiInfo.uiData) && Intrinsics.areEqual((Object) this.rule, (Object) uiInfo.rule);
    }

    public int hashCode() {
        HashMap<String, String> hashMap = this.uiData;
        int i = 0;
        int hashCode = (hashMap != null ? hashMap.hashCode() : 0) * 31;
        UiRule uiRule = this.rule;
        if (uiRule != null) {
            i = uiRule.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "UiInfo(uiData=" + this.uiData + ", rule=" + this.rule + ")";
    }

    public UiInfo(HashMap<String, String> hashMap, UiRule uiRule) {
        this.uiData = hashMap;
        this.rule = uiRule;
    }

    public final HashMap<String, String> getUiData() {
        return this.uiData;
    }

    public final void setUiData(HashMap<String, String> hashMap) {
        this.uiData = hashMap;
    }

    public final UiRule getRule() {
        return this.rule;
    }

    public final void setRule(UiRule uiRule) {
        this.rule = uiRule;
    }
}
