package global.didi.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.net.C14489Util;
import com.didi.unifiedPay.util.ABTestProxyHolder;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.taxis99.R;
import global.didi.pay.newview.NewGlobalPaymentView;
import global.didi.pay.p236ui.theme.UnifiedPayTheme;
import global.didi.pay.presenter.GlobalAbsPaymentPresenter;
import global.didi.pay.presenter.GlobalUniPayPresenter;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class GlobalUniPayActivity extends FragmentActivity implements IViewCallback {
    public static final String UNI_PAY_PARAM = "uni_pay_param";
    private boolean isDestroyed;
    protected PayParam mPayParam;
    protected GlobalAbsPaymentPresenter mPayPresenter;
    protected IGlobalPayView mPaymentView;
    private String mSid;

    public int requestCode(int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.isDestroyed = false;
        getBundleData(extras);
        setContentView((int) R.layout.oc_uni_pay_activity_layout);
        initPayComponent();
        extras.putSerializable("pay_param", this.mPayParam);
        this.mPayPresenter.onAdd(extras);
        EventBus.getDefault().register(this);
    }

    /* access modifiers changed from: protected */
    public void setBackground(UnifiedPayTheme unifiedPayTheme) {
        if (unifiedPayTheme != null) {
            View findViewById = findViewById(R.id.oc_uni_rl_rootview);
            findViewById(R.id.oc_uni_view_gray).setVisibility(8);
            findViewById.setBackgroundResource(unifiedPayTheme.getMainColor());
            ((ImageView) findViewById(R.id.oc_uni_center_logo)).setImageResource(unifiedPayTheme.getLogo());
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (UniPayParamUtil.getResourceConfigurationProxy() != null) {
            UniPayParamUtil.getResourceConfigurationProxy().updateConfiguration(context);
        }
    }

    /* access modifiers changed from: protected */
    public void getBundleData(Bundle bundle) {
        if (bundle == null) {
            finish();
            return;
        }
        try {
            String str = (String) bundle.getSerializable("uni_pay_param");
            if (TextUtils.isEmpty(str)) {
                finish();
            }
            PayParam payParam = (PayParam) C14489Util.objectFromJson(str, PayParam.class);
            this.mPayParam = payParam;
            if (payParam != null) {
                this.mSid = payParam.sid;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initPayComponent() {
        this.mPaymentView = createPaymentView();
        this.mPayPresenter = createPresenter();
        ((FrameLayout) findViewById(R.id.oc_uni_fl_component_container)).addView((View) this.mPaymentView);
        bind(this.mPaymentView, this.mPayPresenter);
    }

    /* access modifiers changed from: protected */
    public IGlobalPayView createPaymentView() {
        if (ABTestProxyHolder.getNewUISwitch() == null || !ABTestProxyHolder.getNewUISwitch().isNewTrip()) {
            return new GlobalPaymentView(this);
        }
        return new NewGlobalPaymentView(this);
    }

    /* access modifiers changed from: protected */
    public GlobalAbsPaymentPresenter createPresenter() {
        return new GlobalUniPayPresenter(this, getSupportFragmentManager(), this.mSid, this);
    }

    private void bind(IGlobalPayView iGlobalPayView, GlobalAbsPaymentPresenter globalAbsPaymentPresenter) {
        this.mPayPresenter.setIView(iGlobalPayView);
        iGlobalPayView.setListener(globalAbsPaymentPresenter);
        iGlobalPayView.setPixViewListener(globalAbsPaymentPresenter);
        iGlobalPayView.setInstallmentListener(globalAbsPaymentPresenter);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        GlobalAbsPaymentPresenter globalAbsPaymentPresenter;
        if (isActivityDestroyed() || keyEvent.getKeyCode() != 4 || (globalAbsPaymentPresenter = this.mPayPresenter) == null) {
            return false;
        }
        return globalAbsPaymentPresenter.onBackPressed(BackKeyType.BackKey);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.bottom_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = this.mPayPresenter;
        if (globalAbsPaymentPresenter != null) {
            globalAbsPaymentPresenter.onRemove();
        }
        super.onDestroy();
        this.isDestroyed = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.mPayPresenter.onPageStart();
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.mPayPresenter.onPageStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.mPayPresenter.onPageResume();
        this.mPayPresenter.onPageShow();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.mPayPresenter.onPagePause();
        this.mPayPresenter.onPageHide();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mPayPresenter.onActivityResult(i, i2, intent);
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

    private boolean isActivityDestroyed() {
        return this.isDestroyed;
    }
}
