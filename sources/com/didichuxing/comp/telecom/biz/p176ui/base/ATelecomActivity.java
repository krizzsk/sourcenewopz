package com.didichuxing.comp.telecom.biz.p176ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H$J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/base/ATelecomActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "FRAGMENT_TAG", "", "mFragment", "Landroidx/fragment/app/Fragment;", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "genFragment", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.base.ATelecomActivity */
/* compiled from: BaseActivity.kt */
public abstract class ATelecomActivity extends AppCompatActivity {

    /* renamed from: a */
    private final String f46282a = "singleFragment";

    /* renamed from: b */
    private Fragment f46283b;

    /* access modifiers changed from: protected */
    public abstract Fragment genFragment();

    /* access modifiers changed from: protected */
    public final Fragment getMFragment() {
        return this.f46283b;
    }

    /* access modifiers changed from: protected */
    public final void setMFragment(Fragment fragment) {
        this.f46283b = fragment;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(R.id.voip_call_page_activity_fragment);
        setContentView((View) frameLayout);
        if (bundle != null) {
            bundle2 = bundle;
        } else {
            Intent intent = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
            bundle2 = intent.getExtras();
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "supportFragmentManager.beginTransaction()");
        if (bundle != null) {
            this.f46283b = getSupportFragmentManager().findFragmentByTag(this.f46282a);
        }
        if (this.f46283b == null) {
            this.f46283b = genFragment();
        }
        Fragment fragment = this.f46283b;
        if (fragment == null) {
            Intrinsics.throwNpe();
        }
        fragment.setArguments(bundle2);
        Fragment fragment2 = this.f46283b;
        if (fragment2 == null) {
            Intrinsics.throwNpe();
        }
        beginTransaction.replace(R.id.voip_call_page_activity_fragment, fragment2, this.f46282a);
        beginTransaction.commitAllowingStateLoss();
    }
}
