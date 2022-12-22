package com.didi.soda.home.topgun.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/HomeFeedbackButtonModel;", "", "issueNo", "", "text", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getIssueNo", "()Ljava/lang/Integer;", "setIssueNo", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/didi/soda/home/topgun/model/HomeFeedbackButtonModel;", "equals", "", "other", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedbackModel.kt */
public final class HomeFeedbackButtonModel {

    /* renamed from: a */
    private Integer f43013a;

    /* renamed from: b */
    private String f43014b;

    public HomeFeedbackButtonModel() {
        this((Integer) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HomeFeedbackButtonModel copy$default(HomeFeedbackButtonModel homeFeedbackButtonModel, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = homeFeedbackButtonModel.f43013a;
        }
        if ((i & 2) != 0) {
            str = homeFeedbackButtonModel.f43014b;
        }
        return homeFeedbackButtonModel.copy(num, str);
    }

    public final Integer component1() {
        return this.f43013a;
    }

    public final String component2() {
        return this.f43014b;
    }

    public final HomeFeedbackButtonModel copy(Integer num, String str) {
        return new HomeFeedbackButtonModel(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeFeedbackButtonModel)) {
            return false;
        }
        HomeFeedbackButtonModel homeFeedbackButtonModel = (HomeFeedbackButtonModel) obj;
        return Intrinsics.areEqual((Object) this.f43013a, (Object) homeFeedbackButtonModel.f43013a) && Intrinsics.areEqual((Object) this.f43014b, (Object) homeFeedbackButtonModel.f43014b);
    }

    public int hashCode() {
        Integer num = this.f43013a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f43014b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "HomeFeedbackButtonModel(issueNo=" + this.f43013a + ", text=" + this.f43014b + VersionRange.RIGHT_OPEN;
    }

    public HomeFeedbackButtonModel(Integer num, String str) {
        this.f43013a = num;
        this.f43014b = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeFeedbackButtonModel(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? null : str);
    }

    public final Integer getIssueNo() {
        return this.f43013a;
    }

    public final String getText() {
        return this.f43014b;
    }

    public final void setIssueNo(Integer num) {
        this.f43013a = num;
    }

    public final void setText(String str) {
        this.f43014b = str;
    }
}
