package com.didi.wallet.dimina.pay;

import android.content.Intent;
import android.os.Bundle;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.apm.SystemUtils;
import global.didi.pay.GlobalUniPayActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/wallet/dimina/pay/InternationalPaymentActivity;", "Lglobal/didi/pay/GlobalUniPayActivity;", "()V", "callStartActivity", "", "intent", "Landroid/content/Intent;", "callStartActivityForResult", "requestCode", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InternationalPaymentActivity.kt */
public final class InternationalPaymentActivity extends GlobalUniPayActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "InternationalPaymentActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        LogUtil.iRelease(TAG, "onCreate()");
    }

    public void callStartActivityForResult(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        startActivityForResult(intent, i);
        LogUtil.iRelease(TAG, "callStartActivityForResult()");
    }

    public void callStartActivity(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        startActivity(intent);
        LogUtil.iRelease(TAG, "callStartActivity()");
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/wallet/dimina/pay/InternationalPaymentActivity$Companion;", "", "()V", "TAG", "", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InternationalPaymentActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
