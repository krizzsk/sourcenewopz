package com.didiglobal.ddmirror.uichecker.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/model/Rule;", "", "vi", "", "vp", "vl", "rule", "Lcom/didiglobal/ddmirror/uichecker/model/UiRule;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didiglobal/ddmirror/uichecker/model/UiRule;)V", "getRule", "()Lcom/didiglobal/ddmirror/uichecker/model/UiRule;", "setRule", "(Lcom/didiglobal/ddmirror/uichecker/model/UiRule;)V", "getVi", "()Ljava/lang/String;", "setVi", "(Ljava/lang/String;)V", "getVl", "setVl", "getVp", "setVp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiConfig.kt */
public final class Rule {
    private UiRule rule;

    /* renamed from: vi */
    private String f49854vi;

    /* renamed from: vl */
    private String f49855vl;

    /* renamed from: vp */
    private String f49856vp;

    public static /* synthetic */ Rule copy$default(Rule rule2, String str, String str2, String str3, UiRule uiRule, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rule2.f49854vi;
        }
        if ((i & 2) != 0) {
            str2 = rule2.f49856vp;
        }
        if ((i & 4) != 0) {
            str3 = rule2.f49855vl;
        }
        if ((i & 8) != 0) {
            uiRule = rule2.rule;
        }
        return rule2.copy(str, str2, str3, uiRule);
    }

    public final String component1() {
        return this.f49854vi;
    }

    public final String component2() {
        return this.f49856vp;
    }

    public final String component3() {
        return this.f49855vl;
    }

    public final UiRule component4() {
        return this.rule;
    }

    public final Rule copy(String str, String str2, String str3, UiRule uiRule) {
        return new Rule(str, str2, str3, uiRule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rule)) {
            return false;
        }
        Rule rule2 = (Rule) obj;
        return Intrinsics.areEqual((Object) this.f49854vi, (Object) rule2.f49854vi) && Intrinsics.areEqual((Object) this.f49856vp, (Object) rule2.f49856vp) && Intrinsics.areEqual((Object) this.f49855vl, (Object) rule2.f49855vl) && Intrinsics.areEqual((Object) this.rule, (Object) rule2.rule);
    }

    public int hashCode() {
        String str = this.f49854vi;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f49856vp;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f49855vl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        UiRule uiRule = this.rule;
        if (uiRule != null) {
            i = uiRule.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Rule(vi=" + this.f49854vi + ", vp=" + this.f49856vp + ", vl=" + this.f49855vl + ", rule=" + this.rule + ")";
    }

    public Rule(String str, String str2, String str3, UiRule uiRule) {
        this.f49854vi = str;
        this.f49856vp = str2;
        this.f49855vl = str3;
        this.rule = uiRule;
    }

    public final String getVi() {
        return this.f49854vi;
    }

    public final void setVi(String str) {
        this.f49854vi = str;
    }

    public final String getVp() {
        return this.f49856vp;
    }

    public final void setVp(String str) {
        this.f49856vp = str;
    }

    public final String getVl() {
        return this.f49855vl;
    }

    public final void setVl(String str) {
        this.f49855vl = str;
    }

    public final UiRule getRule() {
        return this.rule;
    }

    public final void setRule(UiRule uiRule) {
        this.rule = uiRule;
    }
}
