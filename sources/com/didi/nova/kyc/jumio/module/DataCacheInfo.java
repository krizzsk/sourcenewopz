package com.didi.nova.kyc.jumio.module;

import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioScanSide;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/module/DataCacheInfo;", "", "()V", "credentialInfoCard", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "getCredentialInfoCard", "()Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "setCredentialInfoCard", "(Lcom/jumio/sdk/credentials/JumioCredentialInfo;)V", "credentialInfoFace", "getCredentialInfoFace", "setCredentialInfoFace", "credentialPartBack", "Lcom/jumio/sdk/enums/JumioScanSide;", "getCredentialPartBack", "()Lcom/jumio/sdk/enums/JumioScanSide;", "setCredentialPartBack", "(Lcom/jumio/sdk/enums/JumioScanSide;)V", "credentialPartFace", "getCredentialPartFace", "setCredentialPartFace", "credentialPartFront", "getCredentialPartFront", "setCredentialPartFront", "currentPartName", "", "getCurrentPartName", "()Ljava/lang/String;", "setCurrentPartName", "(Ljava/lang/String;)V", "Companion", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataCacheInfo.kt */
public final class DataCacheInfo {
    public static final String BACK = "BACK";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FACE = "FACE";
    public static final String FRONT = "FRONT";

    /* renamed from: a */
    private String f29342a = "";

    /* renamed from: b */
    private JumioScanSide f29343b;

    /* renamed from: c */
    private JumioScanSide f29344c;

    /* renamed from: d */
    private JumioScanSide f29345d;

    /* renamed from: e */
    private JumioCredentialInfo f29346e;

    /* renamed from: f */
    private JumioCredentialInfo f29347f;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/module/DataCacheInfo$Companion;", "", "()V", "BACK", "", "FACE", "FRONT", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DataCacheInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getCurrentPartName() {
        return this.f29342a;
    }

    public final void setCurrentPartName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f29342a = str;
    }

    public final JumioScanSide getCredentialPartFront() {
        return this.f29343b;
    }

    public final void setCredentialPartFront(JumioScanSide jumioScanSide) {
        this.f29343b = jumioScanSide;
    }

    public final JumioScanSide getCredentialPartBack() {
        return this.f29344c;
    }

    public final void setCredentialPartBack(JumioScanSide jumioScanSide) {
        this.f29344c = jumioScanSide;
    }

    public final JumioScanSide getCredentialPartFace() {
        return this.f29345d;
    }

    public final void setCredentialPartFace(JumioScanSide jumioScanSide) {
        this.f29345d = jumioScanSide;
    }

    public final JumioCredentialInfo getCredentialInfoFace() {
        return this.f29346e;
    }

    public final void setCredentialInfoFace(JumioCredentialInfo jumioCredentialInfo) {
        this.f29346e = jumioCredentialInfo;
    }

    public final JumioCredentialInfo getCredentialInfoCard() {
        return this.f29347f;
    }

    public final void setCredentialInfoCard(JumioCredentialInfo jumioCredentialInfo) {
        this.f29347f = jumioCredentialInfo;
    }
}
