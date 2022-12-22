package com.google.android.play.core.assetpacks.model;

import com.didi.payment.base.tracker.ErrorName;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.model.a */
public final class C18405a {

    /* renamed from: a */
    private static final Map<Integer, String> f53098a = new HashMap();

    /* renamed from: b */
    private static final Map<Integer, String> f53099b = new HashMap();

    static {
        f53098a.put(-1, "The requesting app is unavailable (e.g. unpublished, nonexistent version code).");
        f53098a.put(-2, "The requested pack is not available.");
        f53098a.put(-3, "The request is invalid.");
        f53098a.put(-4, "The requested download is not found.");
        f53098a.put(-5, "The Asset Delivery API is not available.");
        f53098a.put(-6, "Network error. Unable to obtain the asset pack details.");
        f53098a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f53098a.put(-10, "Asset pack download failed due to insufficient storage.");
        f53098a.put(-11, "The Play Store app is either not installed or not the official version.");
        f53098a.put(-12, "Tried to show the cellular data confirmation but no asset packs are waiting for Wi-Fi.");
        f53098a.put(-13, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        f53098a.put(-100, "Unknown error downloading an asset pack.");
        f53099b.put(-1, "APP_UNAVAILABLE");
        f53099b.put(-2, "PACK_UNAVAILABLE");
        f53099b.put(-3, "INVALID_REQUEST");
        f53099b.put(-4, "DOWNLOAD_NOT_FOUND");
        f53099b.put(-5, "API_NOT_AVAILABLE");
        f53099b.put(-6, ErrorName.NETWORK_ERROR);
        f53099b.put(-7, "ACCESS_DENIED");
        f53099b.put(-10, "INSUFFICIENT_STORAGE");
        f53099b.put(-11, "PLAY_STORE_NOT_FOUND");
        f53099b.put(-12, "NETWORK_UNRESTRICTED");
        f53099b.put(-13, "APP_NOT_OWNED");
        f53099b.put(-100, "INTERNAL_ERROR");
    }

    /* renamed from: a */
    public static String m37706a(int i) {
        Map<Integer, String> map = f53098a;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return "";
        }
        String str = f53098a.get(valueOf);
        String str2 = f53099b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 113 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/assetpacks/model/AssetPackErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}
