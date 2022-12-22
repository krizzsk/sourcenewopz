package com.wallet.flutter.wallet_flutter.function;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.wallet.flutter.wallet_flutter.base.FlutterHelper;
import com.wallet.flutter.wallet_flutter.base.FlutterHelperKt;
import com.wallet.flutter.wallet_flutter.base.FlutterProxyActivityCallAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterShareProxyCall;", "Lcom/wallet/flutter/wallet_flutter/base/FlutterProxyActivityCallAdapter;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "activity", "Landroidx/fragment/app/FragmentActivity;", "params", "", "otherParams", "pluginBindingId", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterShareProxyCall.kt */
public final class FlutterShareProxyCall extends FlutterProxyActivityCallAdapter {
    public void onCreate(Bundle bundle, FragmentActivity fragmentActivity, String str, String str2, String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Map<String, Object> jsonToMap = FlutterHelperKt.jsonToMap(str2);
        if (jsonToMap == null) {
            FlutterHelper.Companion.callbackMethodFail$default(FlutterHelper.Companion, fragmentActivity, (Intent) null, 2, (Object) null);
            return;
        }
        Object obj = jsonToMap.get(FlutterShareMethod.filePathKey);
        if (obj == null || (str4 = obj.toString()) == null) {
            str4 = "";
        }
        NCommonShareManager.showCommonShareWindow(fragmentActivity, "", "WEB_99_DOWN_PAGE", str4, new FlutterShareProxyCall$onCreate$1$1(fragmentActivity));
    }
}
