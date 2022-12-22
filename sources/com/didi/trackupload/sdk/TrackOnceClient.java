package com.didi.trackupload.sdk;

import android.text.TextUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Locale;
import rui.config.RConfigConstants;

public class TrackOnceClient {

    /* renamed from: a */
    private static final String f36994a = "TrackOnceClient";

    /* renamed from: b */
    private TrackClientType f36995b;

    /* renamed from: c */
    private String f36996c;

    /* renamed from: d */
    private ITrackDataDelegate f36997d;

    /* renamed from: e */
    private String f36998e;

    TrackOnceClient(TrackClientType trackClientType, String str) {
        this.f36995b = trackClientType;
        this.f36996c = str;
        this.f36998e = m26209a(trackClientType, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo95160a() {
        int a = TrackController.getIntance().mo95127a(this);
        TrackLog.m31343d(f36994a, "startTrackOnce err=" + TrackErrInfo.toErrString(a) + " client=" + toString());
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo95161a(ITrackDataDelegate iTrackDataDelegate) {
        this.f36997d = iTrackDataDelegate;
        return 0;
    }

    public TrackClientType getClientType() {
        return this.f36995b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo95162b() {
        return this.f36996c;
    }

    public ITrackDataDelegate getTrackDataDelegate() {
        return this.f36997d;
    }

    /* renamed from: a */
    private static String m26209a(TrackClientType trackClientType, String str) {
        return RConfigConstants.KEYWORD_COLOR_SIGN + TrackClient.m26184a(trackClientType, str);
    }

    public String getTrackTag() {
        return this.f36998e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TrackOnceClient) {
            return TextUtils.equals(getTrackTag(), ((TrackOnceClient) obj).getTrackTag());
        }
        return false;
    }

    public int hashCode() {
        String str = this.f36998e;
        return 0 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "TrackOnceClient@%s{type=%s, trackid=%s, tag=%s, dataDelegate=%s}", new Object[]{Integer.toHexString(hashCode()), this.f36995b, this.f36996c, this.f36998e, this.f36997d});
    }

    public String toSimpleString() {
        return String.format(Locale.getDefault(), "TrackOnceClient@%s{tag=%s}", new Object[]{Integer.toHexString(hashCode()), this.f36998e});
    }
}
