package com.didi.component.framework.pages.promo.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/model/WaiMaiVo;", "", "domain", "", "path", "traceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDomain", "()Ljava/lang/String;", "getPath", "getTraceId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoResponse.kt */
public final class WaiMaiVo {
    private final String domain;
    private final String path;
    private final String traceId;

    public static /* synthetic */ WaiMaiVo copy$default(WaiMaiVo waiMaiVo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = waiMaiVo.domain;
        }
        if ((i & 2) != 0) {
            str2 = waiMaiVo.path;
        }
        if ((i & 4) != 0) {
            str3 = waiMaiVo.traceId;
        }
        return waiMaiVo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.traceId;
    }

    public final WaiMaiVo copy(String str, String str2, String str3) {
        return new WaiMaiVo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WaiMaiVo)) {
            return false;
        }
        WaiMaiVo waiMaiVo = (WaiMaiVo) obj;
        return Intrinsics.areEqual((Object) this.domain, (Object) waiMaiVo.domain) && Intrinsics.areEqual((Object) this.path, (Object) waiMaiVo.path) && Intrinsics.areEqual((Object) this.traceId, (Object) waiMaiVo.traceId);
    }

    public int hashCode() {
        String str = this.domain;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.path;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.traceId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "WaiMaiVo(domain=" + this.domain + ", path=" + this.path + ", traceId=" + this.traceId + VersionRange.RIGHT_OPEN;
    }

    public WaiMaiVo(String str, String str2, String str3) {
        this.domain = str;
        this.path = str2;
        this.traceId = str3;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getTraceId() {
        return this.traceId;
    }
}
