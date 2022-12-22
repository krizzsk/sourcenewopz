package com.wallet.flutter.wallet_flutter.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001c"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/base/FlutterProxyActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "pluginBindingId", "", "proxyCall", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterProxyActivityCall;", "getProxyCall", "()Lcom/wallet/flutter/wallet_flutter/base/IFlutterProxyActivityCall;", "setProxyCall", "(Lcom/wallet/flutter/wallet_flutter/base/IFlutterProxyActivityCall;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRestart", "onResume", "onStart", "onStop", "Companion", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterProxyActivity.kt */
public final class FlutterProxyActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String methodNameKey = "methodNameKey";
    public static final String methodParamsKey = "methodParamsKey";
    public static final String otherParamsKey = "otherParamsKey";
    public static final String pluginBindingIdKey = "pluginBindingIdKey";

    /* renamed from: a */
    private IFlutterProxyActivityCall f56045a;

    /* renamed from: b */
    private String f56046b;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/base/FlutterProxyActivity$Companion;", "", "()V", "methodNameKey", "", "methodParamsKey", "otherParamsKey", "pluginBindingIdKey", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FlutterProxyActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final IFlutterProxyActivityCall getProxyCall() {
        return this.f56045a;
    }

    public final void setProxyCall(IFlutterProxyActivityCall iFlutterProxyActivityCall) {
        this.f56045a = iFlutterProxyActivityCall;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String stringExtra;
        IFlutterProxyActivityCall iFlutterProxyActivityCall;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (!(getIntent() == null || (stringExtra = getIntent().getStringExtra(methodNameKey)) == null)) {
            try {
                Class cls = FlutterHelperKt.getMethodProxyMap().get(stringExtra);
                iFlutterProxyActivityCall = cls == null ? null : (IFlutterProxyActivityCall) cls.newInstance();
            } catch (Exception unused) {
                iFlutterProxyActivityCall = null;
            }
            if (iFlutterProxyActivityCall == null) {
                Void voidR = null;
            } else {
                this.f56046b = getIntent().getStringExtra(pluginBindingIdKey);
                iFlutterProxyActivityCall.onCreate(bundle, this, getIntent().getStringExtra(methodParamsKey), getIntent().getStringExtra(otherParamsKey), this.f56046b);
                setProxyCall(iFlutterProxyActivityCall);
                return;
            }
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        IFlutterProxyActivityCall iFlutterProxyActivityCall = this.f56045a;
        if (iFlutterProxyActivityCall != null) {
            iFlutterProxyActivityCall.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        FlutterHelper.Companion.forceFlutterResumed(this.f56046b);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IFlutterProxyActivityCall iFlutterProxyActivityCall = this.f56045a;
        if (iFlutterProxyActivityCall != null) {
            iFlutterProxyActivityCall.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        IFlutterProxyActivityCall iFlutterProxyActivityCall = this.f56045a;
        if (iFlutterProxyActivityCall != null) {
            iFlutterProxyActivityCall.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        IFlutterProxyActivityCall iFlutterProxyActivityCall = this.f56045a;
        if (iFlutterProxyActivityCall != null) {
            iFlutterProxyActivityCall.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        IFlutterProxyActivityCall iFlutterProxyActivityCall = this.f56045a;
        if (iFlutterProxyActivityCall != null) {
            iFlutterProxyActivityCall.onDestroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        IFlutterProxyActivityCall iFlutterProxyActivityCall = this.f56045a;
        if (iFlutterProxyActivityCall != null) {
            iFlutterProxyActivityCall.onActivityResult(i, i2, intent);
        }
    }
}
