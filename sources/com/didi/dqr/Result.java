package com.didi.dqr;

import java.util.EnumMap;
import java.util.Map;

public final class Result {

    /* renamed from: a */
    private final String f18507a;

    /* renamed from: b */
    private final byte[] f18508b;

    /* renamed from: c */
    private final int f18509c;
    public int contourDilateCount;

    /* renamed from: d */
    private ResultPoint[] f18510d;

    /* renamed from: e */
    private final BarcodeFormat f18511e;

    /* renamed from: f */
    private Map<ResultMetadataType, Object> f18512f;

    /* renamed from: g */
    private final long f18513g;

    /* renamed from: h */
    private boolean f18514h;
    public boolean isQRCode;
    public int realContourDilateCount;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, System.currentTimeMillis());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, resultPointArr, barcodeFormat, j);
    }

    public Result(String str, byte[] bArr, int i, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this.f18514h = true;
        this.f18507a = str;
        this.f18508b = bArr;
        this.f18509c = i;
        this.f18510d = resultPointArr;
        this.f18511e = barcodeFormat;
        this.f18512f = null;
        this.f18513g = j;
    }

    public String getText() {
        return this.f18507a;
    }

    public byte[] getRawBytes() {
        return this.f18508b;
    }

    public int getNumBits() {
        return this.f18509c;
    }

    public ResultPoint[] getResultPoints() {
        return this.f18510d;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.f18511e;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.f18512f;
    }

    public void putMetadata(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f18512f == null) {
            this.f18512f = new EnumMap(ResultMetadataType.class);
        }
        this.f18512f.put(resultMetadataType, obj);
    }

    public void putAllMetadata(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f18512f;
            if (map2 == null) {
                this.f18512f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void addResultPoints(ResultPoint[] resultPointArr) {
        ResultPoint[] resultPointArr2 = this.f18510d;
        if (resultPointArr2 == null) {
            this.f18510d = resultPointArr;
        } else if (resultPointArr != null && resultPointArr.length > 0) {
            ResultPoint[] resultPointArr3 = new ResultPoint[(resultPointArr2.length + resultPointArr.length)];
            System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
            System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
            this.f18510d = resultPointArr3;
        }
    }

    public boolean isFromZxing() {
        return this.f18514h;
    }

    public void setFromZxing(boolean z) {
        this.f18514h = z;
    }

    public long getTimestamp() {
        return this.f18513g;
    }

    public String toString() {
        return this.f18507a;
    }
}
