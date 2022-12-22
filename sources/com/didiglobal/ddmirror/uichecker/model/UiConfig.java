package com.didiglobal.ddmirror.uichecker.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;", "", "expressions", "", "Lcom/didiglobal/ddmirror/uichecker/model/Expression;", "(Ljava/util/List;)V", "getExpressions", "()Ljava/util/List;", "setExpressions", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiConfig.kt */
public final class UiConfig {
    private List<Expression> expressions;

    public static /* synthetic */ UiConfig copy$default(UiConfig uiConfig, List<Expression> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = uiConfig.expressions;
        }
        return uiConfig.copy(list);
    }

    public final List<Expression> component1() {
        return this.expressions;
    }

    public final UiConfig copy(List<Expression> list) {
        Intrinsics.checkParameterIsNotNull(list, "expressions");
        return new UiConfig(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UiConfig) && Intrinsics.areEqual((Object) this.expressions, (Object) ((UiConfig) obj).expressions);
        }
        return true;
    }

    public int hashCode() {
        List<Expression> list = this.expressions;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "UiConfig(expressions=" + this.expressions + ")";
    }

    public UiConfig(List<Expression> list) {
        Intrinsics.checkParameterIsNotNull(list, "expressions");
        this.expressions = list;
    }

    public final List<Expression> getExpressions() {
        return this.expressions;
    }

    public final void setExpressions(List<Expression> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.expressions = list;
    }
}
