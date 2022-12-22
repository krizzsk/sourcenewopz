package com.didi.beatles.p099im.access.msg;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f¨\u0006\""}, mo175978d2 = {"Lcom/didi/beatles/im/access/msg/OperationMsgT4;", "", "title", "", "content", "image", "imageDecorate", "imageHeight", "", "imageWidth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getContent", "()Ljava/lang/String;", "getImage", "getImageDecorate", "getImageHeight", "()I", "setImageHeight", "(I)V", "getImageWidth", "setImageWidth", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "im_library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.access.msg.OperationMsgT4 */
/* compiled from: OperationMsgT4.kt */
public final class OperationMsgT4 {

    /* renamed from: a */
    private final String f8764a;

    /* renamed from: b */
    private final String f8765b;

    /* renamed from: c */
    private final String f8766c;

    /* renamed from: d */
    private int f8767d;

    /* renamed from: e */
    private int f8768e;
    @SerializedName("image_decorate")
    private final String imageDecorate;

    public OperationMsgT4() {
        this((String) null, (String) null, (String) null, (String) null, 0, 0, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OperationMsgT4 copy$default(OperationMsgT4 operationMsgT4, String str, String str2, String str3, String str4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = operationMsgT4.f8764a;
        }
        if ((i3 & 2) != 0) {
            str2 = operationMsgT4.f8765b;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = operationMsgT4.f8766c;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = operationMsgT4.imageDecorate;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i = operationMsgT4.f8767d;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = operationMsgT4.f8768e;
        }
        return operationMsgT4.copy(str, str5, str6, str7, i4, i2);
    }

    public final String component1() {
        return this.f8764a;
    }

    public final String component2() {
        return this.f8765b;
    }

    public final String component3() {
        return this.f8766c;
    }

    public final String component4() {
        return this.imageDecorate;
    }

    public final int component5() {
        return this.f8767d;
    }

    public final int component6() {
        return this.f8768e;
    }

    public final OperationMsgT4 copy(String str, String str2, String str3, String str4, int i, int i2) {
        return new OperationMsgT4(str, str2, str3, str4, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OperationMsgT4)) {
            return false;
        }
        OperationMsgT4 operationMsgT4 = (OperationMsgT4) obj;
        return Intrinsics.areEqual((Object) this.f8764a, (Object) operationMsgT4.f8764a) && Intrinsics.areEqual((Object) this.f8765b, (Object) operationMsgT4.f8765b) && Intrinsics.areEqual((Object) this.f8766c, (Object) operationMsgT4.f8766c) && Intrinsics.areEqual((Object) this.imageDecorate, (Object) operationMsgT4.imageDecorate) && this.f8767d == operationMsgT4.f8767d && this.f8768e == operationMsgT4.f8768e;
    }

    public int hashCode() {
        String str = this.f8764a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8765b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8766c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageDecorate;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((((hashCode3 + i) * 31) + this.f8767d) * 31) + this.f8768e;
    }

    public String toString() {
        return "OperationMsgT4(title=" + this.f8764a + ", content=" + this.f8765b + ", image=" + this.f8766c + ", imageDecorate=" + this.imageDecorate + ", imageHeight=" + this.f8767d + ", imageWidth=" + this.f8768e + ")";
    }

    public OperationMsgT4(String str, String str2, String str3, String str4, int i, int i2) {
        this.f8764a = str;
        this.f8765b = str2;
        this.f8766c = str3;
        this.imageDecorate = str4;
        this.f8767d = i;
        this.f8768e = i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OperationMsgT4(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, int r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0008
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
        L_0x0008:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000f
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
        L_0x000f:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0017
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
        L_0x0017:
            r1 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001f
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
        L_0x001f:
            r0 = r8
            r6 = r11 & 16
            r7 = 0
            if (r6 == 0) goto L_0x0027
            r2 = 0
            goto L_0x0028
        L_0x0027:
            r2 = r9
        L_0x0028:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x002e
            r3 = 0
            goto L_0x002f
        L_0x002e:
            r3 = r10
        L_0x002f:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r0
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.access.msg.OperationMsgT4.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.f8764a;
    }

    public final String getContent() {
        return this.f8765b;
    }

    public final String getImage() {
        return this.f8766c;
    }

    public final String getImageDecorate() {
        return this.imageDecorate;
    }

    public final int getImageHeight() {
        return this.f8767d;
    }

    public final void setImageHeight(int i) {
        this.f8767d = i;
    }

    public final int getImageWidth() {
        return this.f8768e;
    }

    public final void setImageWidth(int i) {
        this.f8768e = i;
    }
}
