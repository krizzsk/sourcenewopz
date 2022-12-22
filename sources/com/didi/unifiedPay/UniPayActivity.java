package com.didi.unifiedPay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifiedPay.component.AbsUnifiedPaymentPresenter;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.presenter.impl.ManhattanUniPayPresenter;
import com.didi.unifiedPay.component.presenter.impl.TripUniPayPresenter;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.view.PaymentView;
import com.didi.unifiedPay.sdk.net.C14489Util;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class UniPayActivity extends FragmentActivity implements IViewCallback {
    public static final String UNI_PAY_PARAM = "uni_pay_param";

    /* renamed from: a */
    private FrameLayout f44355a;

    /* renamed from: b */
    private AbsUnifiedPaymentPresenter f44356b;

    /* renamed from: c */
    private PayParam f44357c;

    /* renamed from: d */
    private String f44358d;

    /* renamed from: e */
    private boolean f44359e;

    public int requestCode(int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        SystemUtil.init(this);
        Bundle extras = getIntent().getExtras();
        this.f44359e = false;
        m31497a(extras);
        setContentView((int) R.layout.oc_uni_pay_activity_layout);
        m31496a();
        extras.putSerializable("pay_param", this.f44357c);
        this.f44356b.onAdd(extras);
        EventBus.getDefault().register(this);
    }

    /* renamed from: a */
    private void m31497a(Bundle bundle) {
        if (bundle != null) {
            String str = (String) bundle.getSerializable("uni_pay_param");
            if (TextUtils.isEmpty(str)) {
                finish();
            }
            PayParam payParam = (PayParam) C14489Util.objectFromJson(str, PayParam.class);
            this.f44357c = payParam;
            if (payParam != null) {
                this.f44358d = payParam.sid;
            }
        }
    }

    /* renamed from: a */
    private void m31496a() {
        this.f44355a = (FrameLayout) findViewById(R.id.oc_uni_fl_component_container);
        PaymentView paymentView = getPaymentView();
        this.f44355a.addView(paymentView);
        m31499b();
        m31498a(paymentView, this.f44356b);
    }

    /* access modifiers changed from: protected */
    public PaymentView getPaymentView() {
        return new PaymentView(this);
    }

    /* renamed from: b */
    private void m31499b() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (this.f44357c.bid <= 0 || TextUtils.isEmpty(this.f44357c.oid)) {
            this.f44356b = new ManhattanUniPayPresenter(this, supportFragmentManager, this.f44358d, this);
            return;
        }
        this.f44356b = new TripUniPayPresenter(this, supportFragmentManager, this.f44358d, this.f44357c.bid, this.f44357c.oid, this);
    }

    /* renamed from: a */
    private void m31498a(IPayView iPayView, AbsUnifiedPaymentPresenter absUnifiedPaymentPresenter) {
        this.f44356b.setIView(iPayView);
        iPayView.setListener(absUnifiedPaymentPresenter);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AbsUnifiedPaymentPresenter absUnifiedPaymentPresenter;
        if (m31500c() || keyEvent.getKeyCode() != 4 || (absUnifiedPaymentPresenter = this.f44356b) == null) {
            return false;
        }
        return absUnifiedPaymentPresenter.onBackPressed(BackKeyType.BackKey);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        AbsUnifiedPaymentPresenter absUnifiedPaymentPresenter = this.f44356b;
        if (absUnifiedPaymentPresenter != null) {
            absUnifiedPaymentPresenter.onRemove();
        }
        super.onDestroy();
        this.f44359e = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.f44356b.onPageStart();
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f44356b.onPageStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.f44356b.onPageResume();
        this.f44356b.onPageShow();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f44356b.onPagePause();
        this.f44356b.onPageHide();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f44356b.onActivityResult(i, i2, intent);
    }

    public void closeView() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("code", 2);
        bundle.putString("message", "");
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    @Subscribe
    public void onEvent(PayErrorEvent payErrorEvent) {
        if (payErrorEvent != null && payErrorEvent.errorCode == 1059) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("code", 3);
            bundle.putInt("errCode", payErrorEvent.errorCode);
            bundle.putString("message", payErrorEvent.message);
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: c */
    private boolean m31500c() {
        return this.f44359e;
    }
}
