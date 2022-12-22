package com.didi.map.sdk.sharetrack.callback;

import com.didi.map.sdk.proto.driver_gl.OrderFeatureRes;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/callback/IOrderFeatureDataCallback;", "", "onBeginToFetch", "", "onFetchFailed", "code", "", "msg", "", "onFetchSuccess", "res", "Lcom/didi/map/sdk/proto/driver_gl/OrderFeatureRes;", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: IOrderFeatureDataCallback.kt */
public interface IOrderFeatureDataCallback {
    void onBeginToFetch();

    void onFetchFailed(int i, String str);

    void onFetchSuccess(OrderFeatureRes orderFeatureRes);
}
