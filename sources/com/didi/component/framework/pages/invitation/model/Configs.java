package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/Configs;", "", "configStatus", "", "swiperLen", "(Ljava/lang/String;Ljava/lang/String;)V", "getConfigStatus", "()Ljava/lang/String;", "setConfigStatus", "(Ljava/lang/String;)V", "getSwiperLen", "setSwiperLen", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteTheme.kt */
public final class Configs {
    private String configStatus;
    private String swiperLen;

    public static /* synthetic */ Configs copy$default(Configs configs, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configs.configStatus;
        }
        if ((i & 2) != 0) {
            str2 = configs.swiperLen;
        }
        return configs.copy(str, str2);
    }

    public final String component1() {
        return this.configStatus;
    }

    public final String component2() {
        return this.swiperLen;
    }

    public final Configs copy(String str, String str2) {
        return new Configs(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configs)) {
            return false;
        }
        Configs configs = (Configs) obj;
        return Intrinsics.areEqual((Object) this.configStatus, (Object) configs.configStatus) && Intrinsics.areEqual((Object) this.swiperLen, (Object) configs.swiperLen);
    }

    public int hashCode() {
        String str = this.configStatus;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.swiperLen;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Configs(configStatus=" + this.configStatus + ", swiperLen=" + this.swiperLen + VersionRange.RIGHT_OPEN;
    }

    public Configs(String str, String str2) {
        this.configStatus = str;
        this.swiperLen = str2;
    }

    public final String getConfigStatus() {
        return this.configStatus;
    }

    public final void setConfigStatus(String str) {
        this.configStatus = str;
    }

    public final String getSwiperLen() {
        return this.swiperLen;
    }

    public final void setSwiperLen(String str) {
        this.swiperLen = str;
    }
}
