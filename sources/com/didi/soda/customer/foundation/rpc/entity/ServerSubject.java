package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 *2\u00020\u0001:\u0001*Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jy\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006+"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ServerSubject;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "type", "", "name", "", "tag", "tagTextColor", "tagBackgroundColor", "headPic", "isOpenIm", "isOpenPhone", "uid", "deliveryType", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V", "getDeliveryType", "()I", "getHeadPic", "()Ljava/lang/String;", "getName", "getTag", "getTagBackgroundColor", "getTagTextColor", "getType", "getUid", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class ServerSubject implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 7087756049785586567L;
    private final int deliveryType;
    private final String headPic;
    private final int isOpenIm;
    private final int isOpenPhone;
    private final String name;
    private final String tag;
    private final String tagBackgroundColor;
    private final String tagTextColor;
    private final int type;
    private final String uid;

    public ServerSubject() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ServerSubject copy$default(ServerSubject serverSubject, int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, int i4, int i5, Object obj) {
        ServerSubject serverSubject2 = serverSubject;
        int i6 = i5;
        return serverSubject.copy((i6 & 1) != 0 ? serverSubject2.type : i, (i6 & 2) != 0 ? serverSubject2.name : str, (i6 & 4) != 0 ? serverSubject2.tag : str2, (i6 & 8) != 0 ? serverSubject2.tagTextColor : str3, (i6 & 16) != 0 ? serverSubject2.tagBackgroundColor : str4, (i6 & 32) != 0 ? serverSubject2.headPic : str5, (i6 & 64) != 0 ? serverSubject2.isOpenIm : i2, (i6 & 128) != 0 ? serverSubject2.isOpenPhone : i3, (i6 & 256) != 0 ? serverSubject2.uid : str6, (i6 & 512) != 0 ? serverSubject2.deliveryType : i4);
    }

    public final int component1() {
        return this.type;
    }

    public final int component10() {
        return this.deliveryType;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.tag;
    }

    public final String component4() {
        return this.tagTextColor;
    }

    public final String component5() {
        return this.tagBackgroundColor;
    }

    public final String component6() {
        return this.headPic;
    }

    public final int component7() {
        return this.isOpenIm;
    }

    public final int component8() {
        return this.isOpenPhone;
    }

    public final String component9() {
        return this.uid;
    }

    public final ServerSubject copy(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, int i4) {
        return new ServerSubject(i, str, str2, str3, str4, str5, i2, i3, str6, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServerSubject)) {
            return false;
        }
        ServerSubject serverSubject = (ServerSubject) obj;
        return this.type == serverSubject.type && Intrinsics.areEqual((Object) this.name, (Object) serverSubject.name) && Intrinsics.areEqual((Object) this.tag, (Object) serverSubject.tag) && Intrinsics.areEqual((Object) this.tagTextColor, (Object) serverSubject.tagTextColor) && Intrinsics.areEqual((Object) this.tagBackgroundColor, (Object) serverSubject.tagBackgroundColor) && Intrinsics.areEqual((Object) this.headPic, (Object) serverSubject.headPic) && this.isOpenIm == serverSubject.isOpenIm && this.isOpenPhone == serverSubject.isOpenPhone && Intrinsics.areEqual((Object) this.uid, (Object) serverSubject.uid) && this.deliveryType == serverSubject.deliveryType;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tag;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tagTextColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tagBackgroundColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.headPic;
        int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.isOpenIm) * 31) + this.isOpenPhone) * 31;
        String str6 = this.uid;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return ((hashCode5 + i2) * 31) + this.deliveryType;
    }

    public String toString() {
        return "ServerSubject(type=" + this.type + ", name=" + this.name + ", tag=" + this.tag + ", tagTextColor=" + this.tagTextColor + ", tagBackgroundColor=" + this.tagBackgroundColor + ", headPic=" + this.headPic + ", isOpenIm=" + this.isOpenIm + ", isOpenPhone=" + this.isOpenPhone + ", uid=" + this.uid + ", deliveryType=" + this.deliveryType + VersionRange.RIGHT_OPEN;
    }

    public ServerSubject(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, int i4) {
        this.type = i;
        this.name = str;
        this.tag = str2;
        this.tagTextColor = str3;
        this.tagBackgroundColor = str4;
        this.headPic = str5;
        this.isOpenIm = i2;
        this.isOpenPhone = i3;
        this.uid = str6;
        this.deliveryType = i4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ServerSubject(int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.String r21, int r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r12 = this;
            r0 = r23
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0012
        L_0x0011:
            r3 = r14
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            r5 = r4
            goto L_0x0019
        L_0x0018:
            r5 = r15
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = r4
            goto L_0x0021
        L_0x001f:
            r6 = r16
        L_0x0021:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0027
            r7 = r4
            goto L_0x0029
        L_0x0027:
            r7 = r17
        L_0x0029:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002f
            r8 = r4
            goto L_0x0031
        L_0x002f:
            r8 = r18
        L_0x0031:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0037
            r9 = 0
            goto L_0x0039
        L_0x0037:
            r9 = r19
        L_0x0039:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003f
            r10 = 0
            goto L_0x0041
        L_0x003f:
            r10 = r20
        L_0x0041:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r4 = r21
        L_0x0048:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r2 = r22
        L_0x004f:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r4
            r23 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.ServerSubject.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getTagTextColor() {
        return this.tagTextColor;
    }

    public final String getTagBackgroundColor() {
        return this.tagBackgroundColor;
    }

    public final String getHeadPic() {
        return this.headPic;
    }

    public final int isOpenIm() {
        return this.isOpenIm;
    }

    public final int isOpenPhone() {
        return this.isOpenPhone;
    }

    public final String getUid() {
        return this.uid;
    }

    public final int getDeliveryType() {
        return this.deliveryType;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ServerSubject$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
