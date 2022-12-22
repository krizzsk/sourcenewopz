package com.didi.component.framework.pages.invitation.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JD\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/LunBoConfig;", "", "lunboText", "", "lunboUserList", "", "Lcom/didi/component/framework/pages/invitation/model/LunBoItemInfo;", "configTime", "", "bgColor", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "getConfigTime", "()Ljava/lang/Long;", "setConfigTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLunboText", "setLunboText", "getLunboUserList", "()Ljava/util/List;", "setLunboUserList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)Lcom/didi/component/framework/pages/invitation/model/LunBoConfig;", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class LunBoConfig {
    private String bgColor;
    private Long configTime;
    private String lunboText;
    private List<LunBoItemInfo> lunboUserList;

    public static /* synthetic */ LunBoConfig copy$default(LunBoConfig lunBoConfig, String str, List<LunBoItemInfo> list, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lunBoConfig.lunboText;
        }
        if ((i & 2) != 0) {
            list = lunBoConfig.lunboUserList;
        }
        if ((i & 4) != 0) {
            l = lunBoConfig.configTime;
        }
        if ((i & 8) != 0) {
            str2 = lunBoConfig.bgColor;
        }
        return lunBoConfig.copy(str, list, l, str2);
    }

    public final String component1() {
        return this.lunboText;
    }

    public final List<LunBoItemInfo> component2() {
        return this.lunboUserList;
    }

    public final Long component3() {
        return this.configTime;
    }

    public final String component4() {
        return this.bgColor;
    }

    public final LunBoConfig copy(String str, List<LunBoItemInfo> list, Long l, String str2) {
        return new LunBoConfig(str, list, l, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LunBoConfig)) {
            return false;
        }
        LunBoConfig lunBoConfig = (LunBoConfig) obj;
        return Intrinsics.areEqual((Object) this.lunboText, (Object) lunBoConfig.lunboText) && Intrinsics.areEqual((Object) this.lunboUserList, (Object) lunBoConfig.lunboUserList) && Intrinsics.areEqual((Object) this.configTime, (Object) lunBoConfig.configTime) && Intrinsics.areEqual((Object) this.bgColor, (Object) lunBoConfig.bgColor);
    }

    public int hashCode() {
        String str = this.lunboText;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<LunBoItemInfo> list = this.lunboUserList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Long l = this.configTime;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.bgColor;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "LunBoConfig(lunboText=" + this.lunboText + ", lunboUserList=" + this.lunboUserList + ", configTime=" + this.configTime + ", bgColor=" + this.bgColor + VersionRange.RIGHT_OPEN;
    }

    public LunBoConfig(String str, List<LunBoItemInfo> list, Long l, String str2) {
        this.lunboText = str;
        this.lunboUserList = list;
        this.configTime = l;
        this.bgColor = str2;
    }

    public final String getLunboText() {
        return this.lunboText;
    }

    public final void setLunboText(String str) {
        this.lunboText = str;
    }

    public final List<LunBoItemInfo> getLunboUserList() {
        return this.lunboUserList;
    }

    public final void setLunboUserList(List<LunBoItemInfo> list) {
        this.lunboUserList = list;
    }

    public final Long getConfigTime() {
        return this.configTime;
    }

    public final void setConfigTime(Long l) {
        this.configTime = l;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(String str) {
        this.bgColor = str;
    }
}
