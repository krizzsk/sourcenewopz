package com.didiglobal.scan.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.scan.event.ScanCloseEvent;
import com.didiglobal.scan.view.fragment.QrScanFragment;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\bH\u0014J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/scan/view/activity/GlobalScanActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "container", "Landroid/view/ViewGroup;", "qrScanFragment", "Lcom/didiglobal/scan/view/fragment/QrScanFragment;", "initView", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEvent", "event", "Lcom/didiglobal/scan/event/ScanCloseEvent;", "register", "unregister", "Companion", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GlobalScanActivity.kt */
public class GlobalScanActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_FROM = "key_from";
    public static final String KEY_INPUT_INFO = "key_input_info";
    public static final String KEY_USERTYPE = "key_usertype";

    /* renamed from: a */
    private ViewGroup f51369a;

    /* renamed from: b */
    private QrScanFragment f51370b;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/scan/view/activity/GlobalScanActivity$Companion;", "", "()V", "KEY_FROM", "", "KEY_INPUT_INFO", "KEY_USERTYPE", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: GlobalScanActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_activity_global_scan);
        m36783c();
        m36781a();
    }

    /* renamed from: a */
    private final void m36781a() {
        EventBus.getDefault().register(this);
    }

    /* renamed from: b */
    private final void m36782b() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ScanCloseEvent scanCloseEvent) {
        Intrinsics.checkParameterIsNotNull(scanCloseEvent, "event");
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m36782b();
        super.onDestroy();
    }

    /* renamed from: c */
    private final void m36783c() {
        Bundle extras;
        this.f51369a = (ViewGroup) findViewById(R.id.container);
        QrScanFragment qrScanFragment = new QrScanFragment();
        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            bundle.putAll(extras);
        }
        qrScanFragment.setArguments(bundle);
        this.f51370b = qrScanFragment;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        QrScanFragment qrScanFragment2 = this.f51370b;
        if (qrScanFragment2 == null) {
            Intrinsics.throwNpe();
        }
        beginTransaction.replace(R.id.container, qrScanFragment2).commit();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        QrScanFragment qrScanFragment = this.f51370b;
        if (qrScanFragment != null) {
            qrScanFragment.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPress() {
        finish();
    }

    public void onBackPressed() {
        QrScanFragment qrScanFragment = this.f51370b;
        if (qrScanFragment != null) {
            if (qrScanFragment == null) {
                Intrinsics.throwNpe();
            }
            if (qrScanFragment.onBackPress()) {
                return;
            }
        }
        onBackPress();
    }
}
