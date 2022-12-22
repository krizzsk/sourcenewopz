package global.didi.pay;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.util.LogUtil;
import com.taxis99.R;
import global.didi.pay.model.CancelFeePayParam;
import global.didi.pay.presenter.CancelFeePayPresenter;
import global.didi.pay.view.PayCancelFeeView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class UniCancelFeePayActivity extends FragmentActivity implements IViewCallback {
    public static final String CANCEL_FEE_PAY_PARAM = "uni_pay_param";
    private String TAG = "UniCancelFeePayActivity";
    private FrameLayout frameLayout;
    private boolean isDestroyed;
    private CancelFeePayParam mPayParam;
    private CancelFeePayPresenter mPayPresenter;

    public void callStartActivity(Intent intent) {
    }

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
        setContentView((int) R.layout.oc_uni_cancel_pay_activity_layout);
        initPayComponent();
        this.mPayPresenter.onAdd(extras);
        EventBus.getDefault().register(this);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
    }

    private void getBundleData(Bundle bundle) {
        CancelFeePayParam cancelFeePayParam = (CancelFeePayParam) bundle.getSerializable("uni_pay_param");
        this.mPayParam = cancelFeePayParam;
        if (cancelFeePayParam == null) {
            LogUtil.m31684d(this.TAG, "mPayParam is null");
            finish();
        }
    }

    private void initPayComponent() {
        this.frameLayout = (FrameLayout) findViewById(R.id.oc_uni_fl_component_container);
        PayCancelFeeView payCancelFeeView = new PayCancelFeeView(this, getSupportFragmentManager());
        this.frameLayout.addView(payCancelFeeView);
        createPresenter();
        bind(payCancelFeeView, this.mPayPresenter);
    }

    private void createPresenter() {
        CancelFeePayPresenter cancelFeePayPresenter = new CancelFeePayPresenter(this, getSupportFragmentManager(), this.mPayParam.sid, this);
        this.mPayPresenter = cancelFeePayPresenter;
        cancelFeePayPresenter.setPayParam(this.mPayParam);
    }

    private void bind(IPayView iPayView, CancelFeePayPresenter cancelFeePayPresenter) {
        this.mPayPresenter.setIView(iPayView);
        iPayView.setListener(cancelFeePayPresenter);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        CancelFeePayPresenter cancelFeePayPresenter;
        if (isActivityDestroyed() || keyEvent.getKeyCode() != 4 || (cancelFeePayPresenter = this.mPayPresenter) == null) {
            return false;
        }
        return cancelFeePayPresenter.onBackPressed(BackKeyType.BackKey);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        CancelFeePayPresenter cancelFeePayPresenter = this.mPayPresenter;
        if (cancelFeePayPresenter != null) {
            cancelFeePayPresenter.onRemove();
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

    public void callStartActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
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
        if (payErrorEvent != null) {
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
