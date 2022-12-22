package com.wallet.flutter.wallet_flutter.function;

import android.content.Intent;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.PluginRegistry;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t¸\u0006\u0000"}, mo175978d2 = {"com/wallet/flutter/wallet_flutter/base/FlutterHelperKt$addActivityResultListener$1$1", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder$onCall$$inlined$addActivityResultListener$1 */
/* compiled from: FlutterHelper.kt */
public final class C20641x9f4b6c0d implements PluginRegistry.ActivityResultListener {
    final /* synthetic */ ActivityPluginBinding $binding;
    final /* synthetic */ FlutterToTopUpCreateOrder this$0;

    public C20641x9f4b6c0d(ActivityPluginBinding activityPluginBinding, FlutterToTopUpCreateOrder flutterToTopUpCreateOrder) {
        this.$binding = activityPluginBinding;
        this.this$0 = flutterToTopUpCreateOrder;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        this.$binding.removeActivityResultListener(this);
        this.this$0.m40380a(true);
        if (i2 == -1) {
            Integer num = null;
            if (i == 100) {
                if (intent != null) {
                    num = Integer.valueOf(intent.getIntExtra("code", 3));
                }
                if (CollectionsKt.contains(CollectionsKt.listOf(1, 3), num)) {
                    this.this$0.m40381b();
                    WalletTopUpPayResultActivity.launchFromFlutterTopUp(this.this$0.getActivity(), 101, this.this$0.getMProductLine(), this.this$0.getViewModel().getOrderId(), 0);
                } else if (num != null) {
                    int intValue = num.intValue();
                }
            } else if (i == 101) {
                this.this$0.getActivity().finish();
            } else if (i == 200) {
                Iterable listOf = CollectionsKt.listOf(1, 3);
                if (intent != null) {
                    num = Integer.valueOf(intent.getIntExtra("code", 3));
                }
                if (CollectionsKt.contains(listOf, num)) {
                    this.this$0.m40381b();
                    WalletTopUpPayResultActivity.launchFromFlutterTopUp(this.this$0.getActivity(), 101, this.this$0.getMProductLine(), this.this$0.getViewModel().getOrderId(), 0);
                }
            }
        }
        return false;
    }
}
