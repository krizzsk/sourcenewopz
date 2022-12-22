package com.didi.soda.home.feedback;

import com.didi.soda.home.feedback.GetPhotoPlugin;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/home/feedback/GetPhotoPlugin$onMethodCall$6", "Lcom/didi/soda/home/feedback/GetPhotoPlugin$CallBack;", "onFailed", "", "errorMsg", "", "onSuccess", "base64Str", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GetPhotoPlugin.kt */
public final class GetPhotoPlugin$onMethodCall$6 implements GetPhotoPlugin.CallBack {
    final /* synthetic */ MethodChannel.Result $result;

    GetPhotoPlugin$onMethodCall$6(MethodChannel.Result result) {
        this.$result = result;
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "base64Str");
        HashMap hashMap = new HashMap();
        hashMap.put("photoBase64", str);
        this.$result.success(hashMap);
    }

    public void onFailed(String str) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        this.$result.error("Failed getPhoto", str, (Object) null);
    }
}
