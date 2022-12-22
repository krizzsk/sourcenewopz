package com.didi.nova.kyc.jumio.module;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010'\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 ¨\u0006*"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/module/JumioParams;", "", "()V", "AUTO_TYPE", "", "getAUTO_TYPE", "()I", "setAUTO_TYPE", "(I)V", "BUTTON_AUTO", "getBUTTON_AUTO", "setBUTTON_AUTO", "BUTTON_BACK", "getBUTTON_BACK", "setBUTTON_BACK", "BUTTON_FLASH", "getBUTTON_FLASH", "setBUTTON_FLASH", "BUTTON_TACK_PIC", "getBUTTON_TACK_PIC", "setBUTTON_TACK_PIC", "BUTTON_TIPS", "getBUTTON_TIPS", "setBUTTON_TIPS", "DOCUMENT_SIDE", "getDOCUMENT_SIDE", "setDOCUMENT_SIDE", "ERROR_CODE", "", "getERROR_CODE", "()Ljava/lang/String;", "setERROR_CODE", "(Ljava/lang/String;)V", "FLASH_STATUS", "getFLASH_STATUS", "setFLASH_STATUS", "REJECT_REASON", "getREJECT_REASON", "setREJECT_REASON", "RETRY_REASON", "getRETRY_REASON", "setRETRY_REASON", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioParams.kt */
public final class JumioParams {
    public static final JumioParams INSTANCE = new JumioParams();

    /* renamed from: a */
    private static int f29348a = 1;

    /* renamed from: b */
    private static int f29349b = 1;

    /* renamed from: c */
    private static int f29350c = 2;

    /* renamed from: d */
    private static String f29351d = "";

    /* renamed from: e */
    private static String f29352e = "";

    /* renamed from: f */
    private static String f29353f = "";

    /* renamed from: g */
    private static int f29354g = 1;

    /* renamed from: h */
    private static int f29355h = 2;

    /* renamed from: i */
    private static int f29356i = 3;

    /* renamed from: j */
    private static int f29357j = 4;

    /* renamed from: k */
    private static int f29358k = 5;

    private JumioParams() {
    }

    public final int getAUTO_TYPE() {
        return f29348a;
    }

    public final void setAUTO_TYPE(int i) {
        f29348a = i;
    }

    public final int getDOCUMENT_SIDE() {
        return f29349b;
    }

    public final void setDOCUMENT_SIDE(int i) {
        f29349b = i;
    }

    public final int getFLASH_STATUS() {
        return f29350c;
    }

    public final void setFLASH_STATUS(int i) {
        f29350c = i;
    }

    public final String getREJECT_REASON() {
        return f29351d;
    }

    public final void setREJECT_REASON(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f29351d = str;
    }

    public final String getRETRY_REASON() {
        return f29352e;
    }

    public final void setRETRY_REASON(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f29352e = str;
    }

    public final String getERROR_CODE() {
        return f29353f;
    }

    public final void setERROR_CODE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f29353f = str;
    }

    public final int getBUTTON_AUTO() {
        return f29354g;
    }

    public final void setBUTTON_AUTO(int i) {
        f29354g = i;
    }

    public final int getBUTTON_FLASH() {
        return f29355h;
    }

    public final void setBUTTON_FLASH(int i) {
        f29355h = i;
    }

    public final int getBUTTON_TIPS() {
        return f29356i;
    }

    public final void setBUTTON_TIPS(int i) {
        f29356i = i;
    }

    public final int getBUTTON_TACK_PIC() {
        return f29357j;
    }

    public final void setBUTTON_TACK_PIC(int i) {
        f29357j = i;
    }

    public final int getBUTTON_BACK() {
        return f29358k;
    }

    public final void setBUTTON_BACK(int i) {
        f29358k = i;
    }
}
