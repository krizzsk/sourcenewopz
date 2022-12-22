package com.didi.soda.home.topgun.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/HomeFeedbackModel;", "", "btnList", "", "Lcom/didi/soda/home/topgun/model/HomeFeedbackButtonModel;", "(Ljava/util/List;)V", "getBtnList", "()Ljava/util/List;", "setBtnList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedbackModel.kt */
public final class HomeFeedbackModel {

    /* renamed from: a */
    private List<HomeFeedbackButtonModel> f43015a;

    public HomeFeedbackModel() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HomeFeedbackModel copy$default(HomeFeedbackModel homeFeedbackModel, List<HomeFeedbackButtonModel> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = homeFeedbackModel.f43015a;
        }
        return homeFeedbackModel.copy(list);
    }

    public final List<HomeFeedbackButtonModel> component1() {
        return this.f43015a;
    }

    public final HomeFeedbackModel copy(List<HomeFeedbackButtonModel> list) {
        return new HomeFeedbackModel(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HomeFeedbackModel) && Intrinsics.areEqual((Object) this.f43015a, (Object) ((HomeFeedbackModel) obj).f43015a);
    }

    public int hashCode() {
        List<HomeFeedbackButtonModel> list = this.f43015a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "HomeFeedbackModel(btnList=" + this.f43015a + VersionRange.RIGHT_OPEN;
    }

    public HomeFeedbackModel(List<HomeFeedbackButtonModel> list) {
        this.f43015a = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeFeedbackModel(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<HomeFeedbackButtonModel> getBtnList() {
        return this.f43015a;
    }

    public final void setBtnList(List<HomeFeedbackButtonModel> list) {
        this.f43015a = list;
    }
}
