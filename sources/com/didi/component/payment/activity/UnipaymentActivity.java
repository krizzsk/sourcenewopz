package com.didi.component.payment.activity;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\tH\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/component/payment/activity/UnipaymentActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "payEventListener", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "", "paymentTemplateFragment", "Lcom/didi/component/payment/activity/PaymentTemplateFragment;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "comp-payment_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UnipaymentActivity.kt */
public final class UnipaymentActivity extends FragmentActivity {

    /* renamed from: a */
    private PaymentTemplateFragment f15094a;

    /* renamed from: b */
    private final BaseEventPublisher.OnEventListener<String> f15095b = new UnipaymentActivity$payEventListener$1(this);

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_payment_activity);
        PaymentTemplateFragment paymentTemplateFragment = new PaymentTemplateFragment();
        this.f15094a = paymentTemplateFragment;
        Intrinsics.checkNotNull(paymentTemplateFragment);
        paymentTemplateFragment.setArguments(getIntent().getExtras());
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        m10781a();
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Pay.CATEGORY, this.f15095b, String.class);
    }

    /* renamed from: a */
    private final void m10781a() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        PaymentTemplateFragment paymentTemplateFragment = this.f15094a;
        Intrinsics.checkNotNull(paymentTemplateFragment);
        beginTransaction.replace(R.id.main_fragment_container, paymentTemplateFragment).commit();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Pay.CATEGORY, this.f15095b, String.class);
    }
}
