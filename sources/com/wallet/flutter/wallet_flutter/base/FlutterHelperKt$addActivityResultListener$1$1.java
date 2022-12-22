package com.wallet.flutter.wallet_flutter.base;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.PluginRegistry;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/wallet/flutter/wallet_flutter/base/FlutterHelperKt$addActivityResultListener$1$1", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterHelper.kt */
public final class FlutterHelperKt$addActivityResultListener$1$1 implements PluginRegistry.ActivityResultListener {
    final /* synthetic */ ActivityPluginBinding $binding;
    final /* synthetic */ Function3<Integer, Integer, Intent, Boolean> $block;

    public FlutterHelperKt$addActivityResultListener$1$1(ActivityPluginBinding activityPluginBinding, Function3<? super Integer, ? super Integer, ? super Intent, Boolean> function3) {
        this.$binding = activityPluginBinding;
        this.$block = function3;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        this.$binding.removeActivityResultListener(this);
        return this.$block.invoke(Integer.valueOf(i), Integer.valueOf(i2), intent).booleanValue();
    }
}
