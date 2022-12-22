package com.didi.onekeyshare.callback;

import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.track.OmegaTrack;
import java.util.Map;

public class ShareCallbackDelegate implements ICallback.IPlatformShareCallback {

    /* renamed from: a */
    private ICallback.IPlatformShareCallback f29763a;

    /* renamed from: b */
    private Map<String, String> f29764b;

    public ShareCallbackDelegate(ICallback.IPlatformShareCallback iPlatformShareCallback, Map<String, String> map) {
        this.f29763a = iPlatformShareCallback;
        this.f29764b = map;
    }

    public void onComplete(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f29764b, "success");
        }
        ICallback.IPlatformShareCallback iPlatformShareCallback = this.f29763a;
        if (iPlatformShareCallback != null) {
            iPlatformShareCallback.onComplete(sharePlatform);
        }
    }

    public void onError(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f29764b, "fail");
        }
        ICallback.IPlatformShareCallback iPlatformShareCallback = this.f29763a;
        if (iPlatformShareCallback != null) {
            iPlatformShareCallback.onError(sharePlatform);
        }
    }

    public void onCancel(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f29764b, "cancel");
        }
        ICallback.IPlatformShareCallback iPlatformShareCallback = this.f29763a;
        if (iPlatformShareCallback != null) {
            iPlatformShareCallback.onCancel(sharePlatform);
        }
    }
}
