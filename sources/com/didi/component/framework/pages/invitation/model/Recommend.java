package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/Recommend;", "", "sharePage", "Lcom/didi/component/framework/pages/invitation/model/SharePage;", "(Lcom/didi/component/framework/pages/invitation/model/SharePage;)V", "getSharePage", "()Lcom/didi/component/framework/pages/invitation/model/SharePage;", "setSharePage", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteTheme.kt */
public final class Recommend {
    private SharePage sharePage;

    public static /* synthetic */ Recommend copy$default(Recommend recommend, SharePage sharePage2, int i, Object obj) {
        if ((i & 1) != 0) {
            sharePage2 = recommend.sharePage;
        }
        return recommend.copy(sharePage2);
    }

    public final SharePage component1() {
        return this.sharePage;
    }

    public final Recommend copy(SharePage sharePage2) {
        return new Recommend(sharePage2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Recommend) && Intrinsics.areEqual((Object) this.sharePage, (Object) ((Recommend) obj).sharePage);
    }

    public int hashCode() {
        SharePage sharePage2 = this.sharePage;
        if (sharePage2 == null) {
            return 0;
        }
        return sharePage2.hashCode();
    }

    public String toString() {
        return "Recommend(sharePage=" + this.sharePage + VersionRange.RIGHT_OPEN;
    }

    public Recommend(SharePage sharePage2) {
        this.sharePage = sharePage2;
    }

    public final SharePage getSharePage() {
        return this.sharePage;
    }

    public final void setSharePage(SharePage sharePage2) {
        this.sharePage = sharePage2;
    }
}
