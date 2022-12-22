package com.datadog.android.rum.internal.domain;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/RumContext;", "", "applicationId", "", "sessionId", "viewId", "viewName", "viewUrl", "actionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/String;", "getApplicationId", "getSessionId", "getViewId", "getViewName", "getViewUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumContext.kt */
public final class RumContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final String f3686g;

    /* renamed from: a */
    private final String f3687a;

    /* renamed from: b */
    private final String f3688b;

    /* renamed from: c */
    private final String f3689c;

    /* renamed from: d */
    private final String f3690d;

    /* renamed from: e */
    private final String f3691e;

    /* renamed from: f */
    private final String f3692f;

    public RumContext() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RumContext copy$default(RumContext rumContext, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rumContext.f3687a;
        }
        if ((i & 2) != 0) {
            str2 = rumContext.f3688b;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = rumContext.f3689c;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = rumContext.f3690d;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = rumContext.f3691e;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = rumContext.f3692f;
        }
        return rumContext.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.f3687a;
    }

    public final String component2() {
        return this.f3688b;
    }

    public final String component3() {
        return this.f3689c;
    }

    public final String component4() {
        return this.f3690d;
    }

    public final String component5() {
        return this.f3691e;
    }

    public final String component6() {
        return this.f3692f;
    }

    public final RumContext copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        return new RumContext(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RumContext)) {
            return false;
        }
        RumContext rumContext = (RumContext) obj;
        return Intrinsics.areEqual((Object) this.f3687a, (Object) rumContext.f3687a) && Intrinsics.areEqual((Object) this.f3688b, (Object) rumContext.f3688b) && Intrinsics.areEqual((Object) this.f3689c, (Object) rumContext.f3689c) && Intrinsics.areEqual((Object) this.f3690d, (Object) rumContext.f3690d) && Intrinsics.areEqual((Object) this.f3691e, (Object) rumContext.f3691e) && Intrinsics.areEqual((Object) this.f3692f, (Object) rumContext.f3692f);
    }

    public int hashCode() {
        int hashCode = ((this.f3687a.hashCode() * 31) + this.f3688b.hashCode()) * 31;
        String str = this.f3689c;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f3690d;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f3691e;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f3692f;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "RumContext(applicationId=" + this.f3687a + ", sessionId=" + this.f3688b + ", viewId=" + this.f3689c + ", viewName=" + this.f3690d + ", viewUrl=" + this.f3691e + ", actionId=" + this.f3692f + VersionRange.RIGHT_OPEN;
    }

    public RumContext(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        this.f3687a = str;
        this.f3688b = str2;
        this.f3689c = str3;
        this.f3690d = str4;
        this.f3691e = str5;
        this.f3692f = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RumContext(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.lang.String r5 = f3686g
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            java.lang.String r6 = f3686g
        L_0x000c:
            r12 = r6
            r6 = r11 & 4
            r0 = 0
            if (r6 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r7
        L_0x0015:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r8
        L_0x001c:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0022
            r3 = r0
            goto L_0x0023
        L_0x0022:
            r3 = r9
        L_0x0023:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r10
        L_0x0029:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.domain.RumContext.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getApplicationId() {
        return this.f3687a;
    }

    public final String getSessionId() {
        return this.f3688b;
    }

    public final String getViewId() {
        return this.f3689c;
    }

    public final String getViewName() {
        return this.f3690d;
    }

    public final String getViewUrl() {
        return this.f3691e;
    }

    public final String getActionId() {
        return this.f3692f;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/RumContext$Companion;", "", "()V", "NULL_UUID", "", "getNULL_UUID", "()Ljava/lang/String;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumContext.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getNULL_UUID() {
            return RumContext.f3686g;
        }
    }

    static {
        String uuid = new UUID(0, 0).toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID(0, 0).toString()");
        f3686g = uuid;
    }
}
