package com.adyen.checkout.adyen3ds2.model;

import android.os.Parcel;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 +2\u00020\u0001:\u0001+BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020$H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006,"}, mo175978d2 = {"Lcom/adyen/checkout/adyen3ds2/model/ChallengeToken;", "Lcom/adyen/checkout/core/model/ModelObject;", "acsReferenceNumber", "", "acsSignedContent", "acsTransID", "acsURL", "messageVersion", "threeDSServerTransID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAcsReferenceNumber", "()Ljava/lang/String;", "setAcsReferenceNumber", "(Ljava/lang/String;)V", "getAcsSignedContent", "setAcsSignedContent", "getAcsTransID", "setAcsTransID", "getAcsURL", "setAcsURL", "getMessageVersion", "setMessageVersion", "getThreeDSServerTransID", "setThreeDSServerTransID", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "3ds2_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChallengeToken.kt */
public final class ChallengeToken extends ModelObject {
    public static final ModelObject.Creator<ChallengeToken> CREATOR = new ModelObject.Creator<>(ChallengeToken.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ModelObject.Serializer<ChallengeToken> SERIALIZER = new ChallengeToken$Companion$SERIALIZER$1();

    /* renamed from: g */
    private static final String f550g = "acsReferenceNumber";

    /* renamed from: h */
    private static final String f551h = "acsSignedContent";

    /* renamed from: i */
    private static final String f552i = "acsTransID";

    /* renamed from: j */
    private static final String f553j = "acsURL";

    /* renamed from: k */
    private static final String f554k = "messageVersion";

    /* renamed from: l */
    private static final String f555l = "threeDSServerTransID";

    /* renamed from: a */
    private String f556a;

    /* renamed from: b */
    private String f557b;

    /* renamed from: c */
    private String f558c;

    /* renamed from: d */
    private String f559d;

    /* renamed from: e */
    private String f560e;

    /* renamed from: f */
    private String f561f;

    public ChallengeToken() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChallengeToken copy$default(ChallengeToken challengeToken, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = challengeToken.f556a;
        }
        if ((i & 2) != 0) {
            str2 = challengeToken.f557b;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = challengeToken.f558c;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = challengeToken.f559d;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = challengeToken.f560e;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = challengeToken.f561f;
        }
        return challengeToken.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.f556a;
    }

    public final String component2() {
        return this.f557b;
    }

    public final String component3() {
        return this.f558c;
    }

    public final String component4() {
        return this.f559d;
    }

    public final String component5() {
        return this.f560e;
    }

    public final String component6() {
        return this.f561f;
    }

    public final ChallengeToken copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new ChallengeToken(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChallengeToken)) {
            return false;
        }
        ChallengeToken challengeToken = (ChallengeToken) obj;
        return Intrinsics.areEqual((Object) this.f556a, (Object) challengeToken.f556a) && Intrinsics.areEqual((Object) this.f557b, (Object) challengeToken.f557b) && Intrinsics.areEqual((Object) this.f558c, (Object) challengeToken.f558c) && Intrinsics.areEqual((Object) this.f559d, (Object) challengeToken.f559d) && Intrinsics.areEqual((Object) this.f560e, (Object) challengeToken.f560e) && Intrinsics.areEqual((Object) this.f561f, (Object) challengeToken.f561f);
    }

    public int hashCode() {
        String str = this.f556a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f557b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f558c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f559d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f560e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f561f;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ChallengeToken(acsReferenceNumber=" + this.f556a + ", acsSignedContent=" + this.f557b + ", acsTransID=" + this.f558c + ", acsURL=" + this.f559d + ", messageVersion=" + this.f560e + ", threeDSServerTransID=" + this.f561f + VersionRange.RIGHT_OPEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChallengeToken(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.adyen3ds2.model.ChallengeToken.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAcsReferenceNumber() {
        return this.f556a;
    }

    public final void setAcsReferenceNumber(String str) {
        this.f556a = str;
    }

    public final String getAcsSignedContent() {
        return this.f557b;
    }

    public final void setAcsSignedContent(String str) {
        this.f557b = str;
    }

    public final String getAcsTransID() {
        return this.f558c;
    }

    public final void setAcsTransID(String str) {
        this.f558c = str;
    }

    public final String getAcsURL() {
        return this.f559d;
    }

    public final void setAcsURL(String str) {
        this.f559d = str;
    }

    public final String getMessageVersion() {
        return this.f560e;
    }

    public final void setMessageVersion(String str) {
        this.f560e = str;
    }

    public final String getThreeDSServerTransID() {
        return this.f561f;
    }

    public final void setThreeDSServerTransID(String str) {
        this.f561f = str;
    }

    public ChallengeToken(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f556a = str;
        this.f557b = str2;
        this.f558c = str3;
        this.f559d = str4;
        this.f560e = str5;
        this.f561f = str6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/adyen/checkout/adyen3ds2/model/ChallengeToken$Companion;", "", "()V", "ACS_REFERENCE_NUMBER", "", "ACS_SIGNED_CONTENT", "ACS_TRANS_ID", "ACS_URL", "CREATOR", "Lcom/adyen/checkout/core/model/ModelObject$Creator;", "Lcom/adyen/checkout/adyen3ds2/model/ChallengeToken;", "kotlin.jvm.PlatformType", "MESSAGE_VERSION", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "THREEDS_SERVER_TRANS_ID", "3ds2_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ChallengeToken.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
