package com.wallet.flutter.wallet_flutter.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J8\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0017"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/base/IFlutterProxyActivityCall;", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "activity", "Landroidx/fragment/app/FragmentActivity;", "params", "", "otherParams", "pluginBindingId", "onDestroy", "onPause", "onResume", "onStart", "onStop", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFlutterProxyActivityCall.kt */
public interface IFlutterProxyActivityCall {
    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle, FragmentActivity fragmentActivity, String str, String str2, String str3);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
