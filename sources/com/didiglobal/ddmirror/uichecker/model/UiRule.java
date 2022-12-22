package com.didiglobal.ddmirror.uichecker.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JD\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/model/UiRule;", "", "text", "", "ruleRelationType", "", "texts", "", "haw_canHit", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "getHaw_canHit", "()Ljava/lang/String;", "setHaw_canHit", "(Ljava/lang/String;)V", "getRuleRelationType", "()Ljava/lang/Integer;", "setRuleRelationType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getText", "setText", "getTexts", "()Ljava/util/List;", "setTexts", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/didiglobal/ddmirror/uichecker/model/UiRule;", "equals", "", "other", "hashCode", "toString", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiConfig.kt */
public final class UiRule {
    private String haw_canHit;
    private Integer ruleRelationType;
    private String text;
    private List<String> texts;

    public static /* synthetic */ UiRule copy$default(UiRule uiRule, String str, Integer num, List<String> list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uiRule.text;
        }
        if ((i & 2) != 0) {
            num = uiRule.ruleRelationType;
        }
        if ((i & 4) != 0) {
            list = uiRule.texts;
        }
        if ((i & 8) != 0) {
            str2 = uiRule.haw_canHit;
        }
        return uiRule.copy(str, num, list, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component2() {
        return this.ruleRelationType;
    }

    public final List<String> component3() {
        return this.texts;
    }

    public final String component4() {
        return this.haw_canHit;
    }

    public final UiRule copy(String str, Integer num, List<String> list, String str2) {
        return new UiRule(str, num, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiRule)) {
            return false;
        }
        UiRule uiRule = (UiRule) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) uiRule.text) && Intrinsics.areEqual((Object) this.ruleRelationType, (Object) uiRule.ruleRelationType) && Intrinsics.areEqual((Object) this.texts, (Object) uiRule.texts) && Intrinsics.areEqual((Object) this.haw_canHit, (Object) uiRule.haw_canHit);
    }

    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.ruleRelationType;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        List<String> list = this.texts;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.haw_canHit;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "UiRule(text=" + this.text + ", ruleRelationType=" + this.ruleRelationType + ", texts=" + this.texts + ", haw_canHit=" + this.haw_canHit + ")";
    }

    public UiRule(String str, Integer num, List<String> list, String str2) {
        this.text = str;
        this.ruleRelationType = num;
        this.texts = list;
        this.haw_canHit = str2;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final Integer getRuleRelationType() {
        return this.ruleRelationType;
    }

    public final void setRuleRelationType(Integer num) {
        this.ruleRelationType = num;
    }

    public final List<String> getTexts() {
        return this.texts;
    }

    public final void setTexts(List<String> list) {
        this.texts = list;
    }

    public final String getHaw_canHit() {
        return this.haw_canHit;
    }

    public final void setHaw_canHit(String str) {
        this.haw_canHit = str;
    }
}
