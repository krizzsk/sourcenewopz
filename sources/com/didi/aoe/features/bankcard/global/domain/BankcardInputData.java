package com.didi.aoe.features.bankcard.global.domain;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, mo175978d2 = {"Lcom/didi/aoe/features/bankcard/global/domain/BankcardInputData;", "", "imageData", "", "imageType", "", "imageWidth", "imageHeight", "degree", "result", "Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "([BIIIILcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;)V", "getDegree", "()I", "getImageData", "()[B", "getImageHeight", "getImageType", "getImageWidth", "getResult", "()Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "global-ocr_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BankcardInputData.kt */
public final class BankcardInputData {

    /* renamed from: a */
    private final byte[] f8154a;

    /* renamed from: b */
    private final int f8155b;

    /* renamed from: c */
    private final int f8156c;

    /* renamed from: d */
    private final int f8157d;

    /* renamed from: e */
    private final int f8158e;

    /* renamed from: f */
    private final DetectCardInfo f8159f;

    public static /* synthetic */ BankcardInputData copy$default(BankcardInputData bankcardInputData, byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bArr = bankcardInputData.f8154a;
        }
        if ((i5 & 2) != 0) {
            i = bankcardInputData.f8155b;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = bankcardInputData.f8156c;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = bankcardInputData.f8157d;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = bankcardInputData.f8158e;
        }
        int i9 = i4;
        if ((i5 & 32) != 0) {
            detectCardInfo = bankcardInputData.f8159f;
        }
        return bankcardInputData.copy(bArr, i6, i7, i8, i9, detectCardInfo);
    }

    public final byte[] component1() {
        return this.f8154a;
    }

    public final int component2() {
        return this.f8155b;
    }

    public final int component3() {
        return this.f8156c;
    }

    public final int component4() {
        return this.f8157d;
    }

    public final int component5() {
        return this.f8158e;
    }

    public final DetectCardInfo component6() {
        return this.f8159f;
    }

    public final BankcardInputData copy(byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(bArr, "imageData");
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "result");
        return new BankcardInputData(bArr, i, i2, i3, i4, detectCardInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankcardInputData)) {
            return false;
        }
        BankcardInputData bankcardInputData = (BankcardInputData) obj;
        return Intrinsics.areEqual((Object) this.f8154a, (Object) bankcardInputData.f8154a) && this.f8155b == bankcardInputData.f8155b && this.f8156c == bankcardInputData.f8156c && this.f8157d == bankcardInputData.f8157d && this.f8158e == bankcardInputData.f8158e && Intrinsics.areEqual((Object) this.f8159f, (Object) bankcardInputData.f8159f);
    }

    public int hashCode() {
        byte[] bArr = this.f8154a;
        int i = 0;
        int hashCode = (((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.f8155b) * 31) + this.f8156c) * 31) + this.f8157d) * 31) + this.f8158e) * 31;
        DetectCardInfo detectCardInfo = this.f8159f;
        if (detectCardInfo != null) {
            i = detectCardInfo.hashCode();
        }
        return hashCode + i;
    }

    public BankcardInputData(byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo) {
        Intrinsics.checkParameterIsNotNull(bArr, "imageData");
        Intrinsics.checkParameterIsNotNull(detectCardInfo, "result");
        this.f8154a = bArr;
        this.f8155b = i;
        this.f8156c = i2;
        this.f8157d = i3;
        this.f8158e = i4;
        this.f8159f = detectCardInfo;
    }

    public final byte[] getImageData() {
        return this.f8154a;
    }

    public final int getImageType() {
        return this.f8155b;
    }

    public final int getImageWidth() {
        return this.f8156c;
    }

    public final int getImageHeight() {
        return this.f8157d;
    }

    public final int getDegree() {
        return this.f8158e;
    }

    public final DetectCardInfo getResult() {
        return this.f8159f;
    }

    public String toString() {
        return "BankcardInputData[" + this.f8155b + ", " + this.f8156c + " * " + this.f8157d + ", degree: " + this.f8158e + VersionRange.RIGHT_CLOSED;
    }
}
