package com.didiglobal.ddmirror.uichecker.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/model/Expression;", "", "ruleId", "", "event", "eventType", "w", "rules", "", "Lcom/didiglobal/ddmirror/uichecker/model/Rule;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "getEventType", "setEventType", "getRuleId", "setRuleId", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "getW", "setW", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiConfig.kt */
public final class Expression {
    private String event;
    private String eventType;
    private String ruleId;
    private List<Rule> rules;

    /* renamed from: w */
    private String f49853w;

    public static /* synthetic */ Expression copy$default(Expression expression, String str, String str2, String str3, String str4, List<Rule> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expression.ruleId;
        }
        if ((i & 2) != 0) {
            str2 = expression.event;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = expression.eventType;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = expression.f49853w;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = expression.rules;
        }
        return expression.copy(str, str5, str6, str7, list);
    }

    public final String component1() {
        return this.ruleId;
    }

    public final String component2() {
        return this.event;
    }

    public final String component3() {
        return this.eventType;
    }

    public final String component4() {
        return this.f49853w;
    }

    public final List<Rule> component5() {
        return this.rules;
    }

    public final Expression copy(String str, String str2, String str3, String str4, List<Rule> list) {
        Intrinsics.checkParameterIsNotNull(str2, "event");
        Intrinsics.checkParameterIsNotNull(str3, "eventType");
        return new Expression(str, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Expression)) {
            return false;
        }
        Expression expression = (Expression) obj;
        return Intrinsics.areEqual((Object) this.ruleId, (Object) expression.ruleId) && Intrinsics.areEqual((Object) this.event, (Object) expression.event) && Intrinsics.areEqual((Object) this.eventType, (Object) expression.eventType) && Intrinsics.areEqual((Object) this.f49853w, (Object) expression.f49853w) && Intrinsics.areEqual((Object) this.rules, (Object) expression.rules);
    }

    public int hashCode() {
        String str = this.ruleId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.event;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.eventType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f49853w;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<Rule> list = this.rules;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "Expression(ruleId=" + this.ruleId + ", event=" + this.event + ", eventType=" + this.eventType + ", w=" + this.f49853w + ", rules=" + this.rules + ")";
    }

    public Expression(String str, String str2, String str3, String str4, List<Rule> list) {
        Intrinsics.checkParameterIsNotNull(str2, "event");
        Intrinsics.checkParameterIsNotNull(str3, "eventType");
        this.ruleId = str;
        this.event = str2;
        this.eventType = str3;
        this.f49853w = str4;
        this.rules = list;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final void setRuleId(String str) {
        this.ruleId = str;
    }

    public final String getEvent() {
        return this.event;
    }

    public final void setEvent(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.event = str;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final void setEventType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.eventType = str;
    }

    public final String getW() {
        return this.f49853w;
    }

    public final void setW(String str) {
        this.f49853w = str;
    }

    public final List<Rule> getRules() {
        return this.rules;
    }

    public final void setRules(List<Rule> list) {
        this.rules = list;
    }
}
