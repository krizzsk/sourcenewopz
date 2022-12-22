package com.didiglobal.p205sa.biz.component.recommend.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/recommend/model/RecommendModel;", "Ljava/io/Serializable;", "title", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "subtitle", "icon", "", "originType", "link", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getLink", "setLink", "getOriginType", "setOriginType", "getSubtitle", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setSubtitle", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.recommend.model.RecommendModel */
/* compiled from: RecommendModel.kt */
public final class RecommendModel implements Serializable {
    private String icon;
    private String link;
    private String originType;
    private LEGORichInfo subtitle;
    private LEGORichInfo title;

    public RecommendModel() {
        this((LEGORichInfo) null, (LEGORichInfo) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecommendModel copy$default(RecommendModel recommendModel, LEGORichInfo lEGORichInfo, LEGORichInfo lEGORichInfo2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            lEGORichInfo = recommendModel.title;
        }
        if ((i & 2) != 0) {
            lEGORichInfo2 = recommendModel.subtitle;
        }
        LEGORichInfo lEGORichInfo3 = lEGORichInfo2;
        if ((i & 4) != 0) {
            str = recommendModel.icon;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = recommendModel.originType;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = recommendModel.link;
        }
        return recommendModel.copy(lEGORichInfo, lEGORichInfo3, str4, str5, str3);
    }

    public final LEGORichInfo component1() {
        return this.title;
    }

    public final LEGORichInfo component2() {
        return this.subtitle;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.originType;
    }

    public final String component5() {
        return this.link;
    }

    public final RecommendModel copy(LEGORichInfo lEGORichInfo, LEGORichInfo lEGORichInfo2, String str, String str2, String str3) {
        return new RecommendModel(lEGORichInfo, lEGORichInfo2, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendModel)) {
            return false;
        }
        RecommendModel recommendModel = (RecommendModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) recommendModel.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) recommendModel.subtitle) && Intrinsics.areEqual((Object) this.icon, (Object) recommendModel.icon) && Intrinsics.areEqual((Object) this.originType, (Object) recommendModel.originType) && Intrinsics.areEqual((Object) this.link, (Object) recommendModel.link);
    }

    public int hashCode() {
        LEGORichInfo lEGORichInfo = this.title;
        int i = 0;
        int hashCode = (lEGORichInfo == null ? 0 : lEGORichInfo.hashCode()) * 31;
        LEGORichInfo lEGORichInfo2 = this.subtitle;
        int hashCode2 = (hashCode + (lEGORichInfo2 == null ? 0 : lEGORichInfo2.hashCode())) * 31;
        String str = this.icon;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.originType;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "RecommendModel(title=" + this.title + ", subtitle=" + this.subtitle + ", icon=" + this.icon + ", originType=" + this.originType + ", link=" + this.link + VersionRange.RIGHT_OPEN;
    }

    public RecommendModel(LEGORichInfo lEGORichInfo, LEGORichInfo lEGORichInfo2, String str, String str2, String str3) {
        this.title = lEGORichInfo;
        this.subtitle = lEGORichInfo2;
        this.icon = str;
        this.originType = str2;
        this.link = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecommendModel(com.didi.global.globaluikit.richinfo.LEGORichInfo r4, com.didi.global.globaluikit.richinfo.LEGORichInfo r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = r5
        L_0x000e:
            r4 = r9 & 4
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0016
            r1 = r5
            goto L_0x0017
        L_0x0016:
            r1 = r6
        L_0x0017:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001d
            r2 = r5
            goto L_0x001e
        L_0x001d:
            r2 = r7
        L_0x001e:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0024
            r9 = r5
            goto L_0x0025
        L_0x0024:
            r9 = r8
        L_0x0025:
            r4 = r3
            r5 = r10
            r6 = r0
            r7 = r1
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.recommend.model.RecommendModel.<init>(com.didi.global.globaluikit.richinfo.LEGORichInfo, com.didi.global.globaluikit.richinfo.LEGORichInfo, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final LEGORichInfo getTitle() {
        return this.title;
    }

    public final void setTitle(LEGORichInfo lEGORichInfo) {
        this.title = lEGORichInfo;
    }

    public final LEGORichInfo getSubtitle() {
        return this.subtitle;
    }

    public final void setSubtitle(LEGORichInfo lEGORichInfo) {
        this.subtitle = lEGORichInfo;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final void setOriginType(String str) {
        this.originType = str;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        this.link = str;
    }
}
