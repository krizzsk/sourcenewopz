package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzjl {

    /* renamed from: iv */
    public byte[] f52602iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzaog;
    private int zzaoh;
    private final MediaCodec.CryptoInfo zzaoi;
    private final zzjn zzaoj;

    public zzjl() {
        zzjn zzjn = null;
        this.zzaoi = zzpt.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzaoj = zzpt.SDK_INT >= 24 ? new zzjn(this.zzaoi) : zzjn;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f52602iv = bArr2;
        this.mode = i2;
        this.zzaog = 0;
        this.zzaoh = 0;
        if (zzpt.SDK_INT >= 16) {
            this.zzaoi.numSubSamples = this.numSubSamples;
            this.zzaoi.numBytesOfClearData = this.numBytesOfClearData;
            this.zzaoi.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            this.zzaoi.key = this.key;
            this.zzaoi.iv = this.f52602iv;
            this.zzaoi.mode = this.mode;
            if (zzpt.SDK_INT >= 24) {
                this.zzaoj.set(0, 0);
            }
        }
    }

    public final MediaCodec.CryptoInfo zzgq() {
        return this.zzaoi;
    }
}
