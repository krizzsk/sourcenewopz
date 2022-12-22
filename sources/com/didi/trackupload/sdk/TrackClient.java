package com.didi.trackupload.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.util.MD5;
import com.didi.trackupload.sdk.datachannel.protobuf.ClientType;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Locale;

public class TrackClient {

    /* renamed from: a */
    private static final String f36976a = "TrackClient";

    /* renamed from: b */
    private TrackClientType f36977b;

    /* renamed from: c */
    private String f36978c;

    /* renamed from: d */
    private TrackOptions f36979d;

    /* renamed from: e */
    private ITrackDataDelegate f36980e;

    /* renamed from: f */
    private String f36981f;

    TrackClient(TrackClientType trackClientType, String str) {
        this.f36977b = trackClientType;
        this.f36978c = str;
        this.f36981f = m26184a(trackClientType, str);
    }

    public int startTrack() {
        int a = TrackController.getIntance().mo95126a(this);
        TrackLog.m31343d(f36976a, "startTrack err=" + TrackErrInfo.toErrString(a) + " client=" + toString());
        StringBuilder sb = new StringBuilder();
        sb.append("startTrack trace=");
        sb.append(Log.getStackTraceString(new Throwable()));
        TrackLog.m31343d(f36976a, sb.toString());
        return a;
    }

    public int stopTrack() {
        int b = TrackController.getIntance().mo95131b(this);
        TrackLog.m31343d(f36976a, "stopTrack err=" + TrackErrInfo.toErrString(b) + " client=" + toSimpleString());
        StringBuilder sb = new StringBuilder();
        sb.append("stopTrack trace=");
        sb.append(Log.getStackTraceString(new Throwable()));
        TrackLog.m31343d(f36976a, sb.toString());
        return b;
    }

    public int setTrackOptions(TrackOptions trackOptions) {
        this.f36979d = trackOptions;
        int c = TrackController.getIntance().mo95132c(this);
        TrackLog.m31343d(f36976a, "setTrackOptions err=" + TrackErrInfo.toErrString(c) + " client=" + toString());
        return c;
    }

    public int setTrackDataDelegate(ITrackDataDelegate iTrackDataDelegate) {
        this.f36980e = iTrackDataDelegate;
        int c = TrackController.getIntance().mo95132c(this);
        TrackLog.m31343d(f36976a, "setTrackDataDelegate err=" + TrackErrInfo.toErrString(c) + " client=" + toString());
        return c;
    }

    public boolean isRunning() {
        return TrackController.getIntance().mo95133d(this);
    }

    public TrackClientType getClientType() {
        return this.f36977b;
    }

    public String getTrackId() {
        return this.f36978c;
    }

    public TrackOptions getTrackOptions() {
        return this.f36979d;
    }

    public ITrackDataDelegate getTrackDataDelegate() {
        return this.f36980e;
    }

    /* renamed from: a */
    static String m26184a(TrackClientType trackClientType, String str) {
        ClientType protoValue = trackClientType != null ? trackClientType.getProtoValue() : null;
        int value = protoValue != null ? protoValue.getValue() : 0;
        if (!TextUtils.isEmpty(str)) {
            String md5 = MD5.toMD5("" + value + str);
            if (md5 != null && md5.length() == 32) {
                return md5.toLowerCase().substring(12, 20);
            }
        }
        return "(" + value + str + ")";
    }

    public String getTrackTag() {
        return this.f36981f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TrackClient mo95109a() {
        TrackClient trackClient = new TrackClient(this.f36977b, this.f36978c);
        TrackOptions trackOptions = this.f36979d;
        if (trackOptions != null) {
            trackClient.f36979d = new TrackOptions(trackOptions.getGatherIntervalMode(), this.f36979d.getUploadIntervalMode());
        }
        ITrackDataDelegate iTrackDataDelegate = this.f36980e;
        if (iTrackDataDelegate != null) {
            trackClient.f36980e = iTrackDataDelegate;
        }
        return trackClient;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TrackClient) {
            return TextUtils.equals(getTrackTag(), ((TrackClient) obj).getTrackTag());
        }
        return false;
    }

    public int hashCode() {
        String str = this.f36981f;
        return 0 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "TrackClient@%s{type=%s, trackid=%s, tag=%s, options=%s, dataDelegate=%s}", new Object[]{Integer.toHexString(hashCode()), this.f36977b, this.f36978c, this.f36981f, this.f36979d, this.f36980e});
    }

    public String toSimpleString() {
        return String.format(Locale.getDefault(), "TrackClient@%s{tag=%s}", new Object[]{Integer.toHexString(hashCode()), this.f36981f});
    }
}
