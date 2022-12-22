package com.didi.component.framework.pages.invitation.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/SharePage;", "", "referSubtitle", "", "referTitle", "swiper", "", "Lcom/didi/component/framework/pages/invitation/model/Swiper;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getReferSubtitle", "()Ljava/lang/String;", "setReferSubtitle", "(Ljava/lang/String;)V", "getReferTitle", "setReferTitle", "getSwiper", "()Ljava/util/List;", "setSwiper", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteTheme.kt */
public final class SharePage {
    private String referSubtitle;
    private String referTitle;
    private List<Swiper> swiper;

    public static /* synthetic */ SharePage copy$default(SharePage sharePage, String str, String str2, List<Swiper> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharePage.referSubtitle;
        }
        if ((i & 2) != 0) {
            str2 = sharePage.referTitle;
        }
        if ((i & 4) != 0) {
            list = sharePage.swiper;
        }
        return sharePage.copy(str, str2, list);
    }

    public final String component1() {
        return this.referSubtitle;
    }

    public final String component2() {
        return this.referTitle;
    }

    public final List<Swiper> component3() {
        return this.swiper;
    }

    public final SharePage copy(String str, String str2, List<Swiper> list) {
        return new SharePage(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SharePage)) {
            return false;
        }
        SharePage sharePage = (SharePage) obj;
        return Intrinsics.areEqual((Object) this.referSubtitle, (Object) sharePage.referSubtitle) && Intrinsics.areEqual((Object) this.referTitle, (Object) sharePage.referTitle) && Intrinsics.areEqual((Object) this.swiper, (Object) sharePage.swiper);
    }

    public int hashCode() {
        String str = this.referSubtitle;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.referTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Swiper> list = this.swiper;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SharePage(referSubtitle=" + this.referSubtitle + ", referTitle=" + this.referTitle + ", swiper=" + this.swiper + VersionRange.RIGHT_OPEN;
    }

    public SharePage(String str, String str2, List<Swiper> list) {
        this.referSubtitle = str;
        this.referTitle = str2;
        this.swiper = list;
    }

    public final String getReferSubtitle() {
        return this.referSubtitle;
    }

    public final void setReferSubtitle(String str) {
        this.referSubtitle = str;
    }

    public final String getReferTitle() {
        return this.referTitle;
    }

    public final void setReferTitle(String str) {
        this.referTitle = str;
    }

    public final List<Swiper> getSwiper() {
        return this.swiper;
    }

    public final void setSwiper(List<Swiper> list) {
        this.swiper = list;
    }
}
