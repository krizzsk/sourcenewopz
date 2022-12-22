package com.wallet.flutter.wallet_flutter.function;

import android.content.Intent;
import com.didi.payment.base.utils.FileUtil;
import kotlin.Metadata;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t¸\u0006\u0000"}, mo175978d2 = {"com/wallet/flutter/wallet_flutter/base/FlutterHelperKt$addActivityResultListener$1$1", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.wallet.flutter.wallet_flutter.function.FlutterShareMethod$performShareAction$$inlined$addActivityResultListener$1 */
/* compiled from: FlutterHelper.kt */
public final class C20640xe9efc581 implements PluginRegistry.ActivityResultListener {
    final /* synthetic */ ActivityPluginBinding $binding;
    final /* synthetic */ String $filePath$inlined;
    final /* synthetic */ MethodChannel.Result $result$inlined;

    public C20640xe9efc581(ActivityPluginBinding activityPluginBinding, MethodChannel.Result result, String str) {
        this.$binding = activityPluginBinding;
        this.$result$inlined = result;
        this.$filePath$inlined = str;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        this.$binding.removeActivityResultListener(this);
        if (i == 10000 && i2 == -1 && intent != null) {
            int intExtra = intent.getIntExtra(FlutterShareMethod.shareStatusKey, -1);
            if (intExtra == 0) {
                this.$result$inlined.success("1");
                return false;
            } else if (intExtra == 1) {
                this.$result$inlined.success("0");
                return false;
            } else if (intExtra != 2) {
                return false;
            } else {
                this.$result$inlined.success("0");
                FileUtil.deleteFile(this.$filePath$inlined);
                return false;
            }
        } else {
            this.$result$inlined.success((Object) null);
            return false;
        }
    }
}
