package com.didi.jacoco.p120ec;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/jacoco/ec/JenkinsInfo;", "", "build_id", "", "build_url", "(Ljava/lang/String;Ljava/lang/String;)V", "getBuild_id", "()Ljava/lang/String;", "setBuild_id", "(Ljava/lang/String;)V", "getBuild_url", "setBuild_url", "toJson", "kotlin.jvm.PlatformType", "jacoco-store"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.jacoco.ec.JenkinsInfo */
/* compiled from: JenkinsInfo.kt */
public final class JenkinsInfo {
    private String build_id;
    private String build_url;

    public JenkinsInfo() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public JenkinsInfo(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "build_id");
        Intrinsics.checkParameterIsNotNull(str2, "build_url");
        this.build_id = str;
        this.build_url = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JenkinsInfo(java.lang.String r2, java.lang.String r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r1 = this;
            r5 = r4 & 1
            java.lang.String r0 = ""
            if (r5 == 0) goto L_0x0010
            java.lang.String r2 = "BUILD_ID"
            java.lang.String r2 = java.lang.System.getenv(r2)
            if (r2 == 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r0
        L_0x0010:
            r4 = r4 & 2
            if (r4 == 0) goto L_0x001e
            java.lang.String r3 = "BUILD_URL"
            java.lang.String r3 = java.lang.System.getenv(r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r3 = r0
        L_0x001e:
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.jacoco.p120ec.JenkinsInfo.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getBuild_id() {
        return this.build_id;
    }

    public final void setBuild_id(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.build_id = str;
    }

    public final String getBuild_url() {
        return this.build_url;
    }

    public final void setBuild_url(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.build_url = str;
    }

    public final String toJson() {
        return new Gson().toJson((Object) this);
    }
}
