package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\u000b\u0010\tR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/ExperimentControl;", "", "isNewPage", "", "isLunbo", "isShareContact", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Integer;", "setLunbo", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setNewPage", "setShareContact", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/didi/component/framework/pages/invitation/model/ExperimentControl;", "equals", "", "other", "hashCode", "toString", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class ExperimentControl {
    private Integer isLunbo;
    private Integer isNewPage;
    private Integer isShareContact;

    public static /* synthetic */ ExperimentControl copy$default(ExperimentControl experimentControl, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = experimentControl.isNewPage;
        }
        if ((i & 2) != 0) {
            num2 = experimentControl.isLunbo;
        }
        if ((i & 4) != 0) {
            num3 = experimentControl.isShareContact;
        }
        return experimentControl.copy(num, num2, num3);
    }

    public final Integer component1() {
        return this.isNewPage;
    }

    public final Integer component2() {
        return this.isLunbo;
    }

    public final Integer component3() {
        return this.isShareContact;
    }

    public final ExperimentControl copy(Integer num, Integer num2, Integer num3) {
        return new ExperimentControl(num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExperimentControl)) {
            return false;
        }
        ExperimentControl experimentControl = (ExperimentControl) obj;
        return Intrinsics.areEqual((Object) this.isNewPage, (Object) experimentControl.isNewPage) && Intrinsics.areEqual((Object) this.isLunbo, (Object) experimentControl.isLunbo) && Intrinsics.areEqual((Object) this.isShareContact, (Object) experimentControl.isShareContact);
    }

    public int hashCode() {
        Integer num = this.isNewPage;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.isLunbo;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.isShareContact;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ExperimentControl(isNewPage=" + this.isNewPage + ", isLunbo=" + this.isLunbo + ", isShareContact=" + this.isShareContact + VersionRange.RIGHT_OPEN;
    }

    public ExperimentControl(Integer num, Integer num2, Integer num3) {
        this.isNewPage = num;
        this.isLunbo = num2;
        this.isShareContact = num3;
    }

    public final Integer isNewPage() {
        return this.isNewPage;
    }

    public final void setNewPage(Integer num) {
        this.isNewPage = num;
    }

    public final Integer isLunbo() {
        return this.isLunbo;
    }

    public final void setLunbo(Integer num) {
        this.isLunbo = num;
    }

    public final Integer isShareContact() {
        return this.isShareContact;
    }

    public final void setShareContact(Integer num) {
        this.isShareContact = num;
    }
}
