package com.wallet.flutter.wallet_flutter.function;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.wallet.flutter.wallet_flutter.base.FlutterHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/wallet/flutter/wallet_flutter/function/FlutterShareProxyCall$onCreate$1$1", "Lcom/didi/payment/commonsdk/utils/NCommonShareManager$CommonShareCallback;", "onCancel", "", "platform", "Lcom/didi/onekeyshare/entity/SharePlatform;", "onComplete", "onError", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterShareProxyCall.kt */
public final class FlutterShareProxyCall$onCreate$1$1 implements NCommonShareManager.CommonShareCallback {
    final /* synthetic */ FragmentActivity $activity;

    FlutterShareProxyCall$onCreate$1$1(FragmentActivity fragmentActivity) {
        this.$activity = fragmentActivity;
    }

    public void onComplete(SharePlatform sharePlatform) {
        Intrinsics.checkNotNullParameter(sharePlatform, "platform");
        FlutterHelper.Companion.callbackMethod(this.$activity, -1, new Intent().putExtra(FlutterShareMethod.shareStatusKey, 0));
    }

    public void onError(SharePlatform sharePlatform) {
        Intrinsics.checkNotNullParameter(sharePlatform, "platform");
        FlutterHelper.Companion.callbackMethod(this.$activity, -1, new Intent().putExtra(FlutterShareMethod.shareStatusKey, 1));
    }

    public void onCancel(SharePlatform sharePlatform) {
        Intrinsics.checkNotNullParameter(sharePlatform, "platform");
        FlutterHelper.Companion.callbackMethod(this.$activity, -1, new Intent().putExtra(FlutterShareMethod.shareStatusKey, 2));
    }
}
