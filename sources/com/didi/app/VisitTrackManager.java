package com.didi.app;

import android.net.Uri;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.SystemUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u001b\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/app/VisitTrackManager;", "", "()V", "fromBackGround", "", "isColdStart", "isShowMain", "lastUploadTime", "", "type", "", "uri", "Landroid/net/Uri;", "getColdStart", "getFromBackGround", "isFirstOpen", "setColdStart", "", "coldStart", "setFromBackGround", "fromBackGroundValue", "setShowMainMain", "isShowMainValue", "setType", "source", "setUri", "scheme", "track", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VisitTrackManager.kt */
public final class VisitTrackManager {
    public static final VisitTrackManager INSTANCE = new VisitTrackManager();

    /* renamed from: a */
    private static String f8233a = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;

    /* renamed from: b */
    private static boolean f8234b;

    /* renamed from: c */
    private static boolean f8235c;

    /* renamed from: d */
    private static Uri f8236d;

    /* renamed from: e */
    private static boolean f8237e;

    /* renamed from: f */
    private static long f8238f;

    private VisitTrackManager() {
    }

    static {
        Object obj = SPUtils.get(DIDIApplication.getAppContext(), "visit_track_last_upload_time", 0L);
        if (obj != null) {
            f8238f = ((Long) obj).longValue();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public final boolean isShowMain() {
        return f8235c;
    }

    public final void setShowMainMain(boolean z) {
        f8235c = z;
    }

    public final void setColdStart(boolean z) {
        f8234b = z;
    }

    public final void setUri(Uri uri) {
        f8236d = uri;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        f8233a = str;
    }

    public final void setFromBackGround(boolean z) {
        f8237e = z;
    }

    public final boolean getFromBackGround() {
        return f8237e;
    }

    public final boolean getColdStart() {
        return f8234b;
    }

    public final void track() {
        if (!(System.currentTimeMillis() - f8238f <= 30000)) {
            f8238f = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("type", f8233a);
            if (f8234b) {
                hashMap.put("style", "cold");
            } else {
                hashMap.put("style", "hot");
            }
            if (INSTANCE.m5370a()) {
                hashMap.put("otherid", ServerParam.PARAM_FIRST);
            } else {
                hashMap.put("otherid", "");
            }
            hashMap.put("k", "visit");
            Uri uri = f8236d;
            if (uri != null) {
                hashMap.put("gibt_channel_h5", uri.toString());
                f8236d = null;
            }
            f8233a = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            SystemUtils.log(3, "ibt_gp_appvisit_sw", hashMap.toString(), (Throwable) null, "com.didi.app.VisitTrackManager", 88);
            SPUtils.put(DIDIApplication.getAppContext(), "visit_track_last_upload_time", Long.valueOf(f8238f));
            OmegaSDKAdapter.trackEvent("ibt_gp_appvisit_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private final boolean m5370a() {
        String str = (String) SPUtils.get(DIDIApplication.getAppContext(), "visit_track_version", "");
        String version = SystemUtil.getVersion();
        if (str != null && Intrinsics.areEqual((Object) str, (Object) version)) {
            return false;
        }
        SPUtils.put(DIDIApplication.getAppContext(), "visit_track_version", version);
        return true;
    }
}
