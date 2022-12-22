package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/InviteTheme;", "", "configs", "Lcom/didi/component/framework/pages/invitation/model/Configs;", "recommend", "Lcom/didi/component/framework/pages/invitation/model/Recommend;", "(Lcom/didi/component/framework/pages/invitation/model/Configs;Lcom/didi/component/framework/pages/invitation/model/Recommend;)V", "getConfigs", "()Lcom/didi/component/framework/pages/invitation/model/Configs;", "setConfigs", "(Lcom/didi/component/framework/pages/invitation/model/Configs;)V", "getRecommend", "()Lcom/didi/component/framework/pages/invitation/model/Recommend;", "setRecommend", "(Lcom/didi/component/framework/pages/invitation/model/Recommend;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteTheme.kt */
public final class InviteTheme {
    private Configs configs;
    private Recommend recommend;

    public static /* synthetic */ InviteTheme copy$default(InviteTheme inviteTheme, Configs configs2, Recommend recommend2, int i, Object obj) {
        if ((i & 1) != 0) {
            configs2 = inviteTheme.configs;
        }
        if ((i & 2) != 0) {
            recommend2 = inviteTheme.recommend;
        }
        return inviteTheme.copy(configs2, recommend2);
    }

    public final Configs component1() {
        return this.configs;
    }

    public final Recommend component2() {
        return this.recommend;
    }

    public final InviteTheme copy(Configs configs2, Recommend recommend2) {
        return new InviteTheme(configs2, recommend2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InviteTheme)) {
            return false;
        }
        InviteTheme inviteTheme = (InviteTheme) obj;
        return Intrinsics.areEqual((Object) this.configs, (Object) inviteTheme.configs) && Intrinsics.areEqual((Object) this.recommend, (Object) inviteTheme.recommend);
    }

    public int hashCode() {
        Configs configs2 = this.configs;
        int i = 0;
        int hashCode = (configs2 == null ? 0 : configs2.hashCode()) * 31;
        Recommend recommend2 = this.recommend;
        if (recommend2 != null) {
            i = recommend2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "InviteTheme(configs=" + this.configs + ", recommend=" + this.recommend + VersionRange.RIGHT_OPEN;
    }

    public InviteTheme(Configs configs2, Recommend recommend2) {
        this.configs = configs2;
        this.recommend = recommend2;
    }

    public final Configs getConfigs() {
        return this.configs;
    }

    public final void setConfigs(Configs configs2) {
        this.configs = configs2;
    }

    public final Recommend getRecommend() {
        return this.recommend;
    }

    public final void setRecommend(Recommend recommend2) {
        this.recommend = recommend2;
    }
}
