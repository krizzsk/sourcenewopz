package com.datadog.android.core.configuration;

import com.datadog.android.rum.RumAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Credentials;", "", "clientToken", "", "envName", "variant", "rumApplicationId", "serviceName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientToken", "()Ljava/lang/String;", "getEnvName", "getRumApplicationId", "getServiceName", "getVariant", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Credentials.kt */
public final class Credentials {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NO_VARIANT = "";

    /* renamed from: a */
    private final String f3409a;

    /* renamed from: b */
    private final String f3410b;

    /* renamed from: c */
    private final String f3411c;

    /* renamed from: d */
    private final String f3412d;

    /* renamed from: e */
    private final String f3413e;

    public static /* synthetic */ Credentials copy$default(Credentials credentials, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = credentials.f3409a;
        }
        if ((i & 2) != 0) {
            str2 = credentials.f3410b;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = credentials.f3411c;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = credentials.f3412d;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = credentials.f3413e;
        }
        return credentials.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.f3409a;
    }

    public final String component2() {
        return this.f3410b;
    }

    public final String component3() {
        return this.f3411c;
    }

    public final String component4() {
        return this.f3412d;
    }

    public final String component5() {
        return this.f3413e;
    }

    public final Credentials copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "clientToken");
        Intrinsics.checkNotNullParameter(str2, "envName");
        Intrinsics.checkNotNullParameter(str3, RumAttributes.VARIANT);
        return new Credentials(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credentials)) {
            return false;
        }
        Credentials credentials = (Credentials) obj;
        return Intrinsics.areEqual((Object) this.f3409a, (Object) credentials.f3409a) && Intrinsics.areEqual((Object) this.f3410b, (Object) credentials.f3410b) && Intrinsics.areEqual((Object) this.f3411c, (Object) credentials.f3411c) && Intrinsics.areEqual((Object) this.f3412d, (Object) credentials.f3412d) && Intrinsics.areEqual((Object) this.f3413e, (Object) credentials.f3413e);
    }

    public int hashCode() {
        int hashCode = ((((this.f3409a.hashCode() * 31) + this.f3410b.hashCode()) * 31) + this.f3411c.hashCode()) * 31;
        String str = this.f3412d;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f3413e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Credentials(clientToken=" + this.f3409a + ", envName=" + this.f3410b + ", variant=" + this.f3411c + ", rumApplicationId=" + this.f3412d + ", serviceName=" + this.f3413e + VersionRange.RIGHT_OPEN;
    }

    public Credentials(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "clientToken");
        Intrinsics.checkNotNullParameter(str2, "envName");
        Intrinsics.checkNotNullParameter(str3, RumAttributes.VARIANT);
        this.f3409a = str;
        this.f3410b = str2;
        this.f3411c = str3;
        this.f3412d = str4;
        this.f3413e = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Credentials(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : str5);
    }

    public final String getClientToken() {
        return this.f3409a;
    }

    public final String getEnvName() {
        return this.f3410b;
    }

    public final String getVariant() {
        return this.f3411c;
    }

    public final String getRumApplicationId() {
        return this.f3412d;
    }

    public final String getServiceName() {
        return this.f3413e;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Credentials$Companion;", "", "()V", "NO_VARIANT", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Credentials.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
