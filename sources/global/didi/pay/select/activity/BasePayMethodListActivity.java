package global.didi.pay.select.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.util.DeviceUtil;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaManager;
import global.didi.pay.select.GlobalWalletParam;
import global.didi.pay.select.model.PayMethodItemInfo;
import global.didi.pay.select.model.PayMethodPageInfo;

public abstract class BasePayMethodListActivity extends FragmentActivity implements IViewCallback {
    public static final String PAGE_TYPE = "page_type";
    protected Context mContext;
    protected String mInstallmentAddcard;
    protected GlobalPayOmegaManager mOmegaManager;
    protected PayMethodPageInfo mPageInfo;
    protected int mPageType;
    protected PayParam mPayParam;

    public void callStartActivity(Intent intent) {
    }

    public void closeView() {
    }

    public int requestCode(int i) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.mContext = this;
        getWindow().setFlags(8192, 8192);
        LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                BasePayMethodListActivity.this.showLoadingDialog();
            }

            public void dismissLoading() {
                BasePayMethodListActivity.this.hideLoadingDialog();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (UniPayParamUtil.getResourceConfigurationProxy() != null) {
            UniPayParamUtil.getResourceConfigurationProxy().updateConfiguration(context);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LoadingProxyHolder.releaseProxy();
    }

    /* access modifiers changed from: protected */
    public void initBase() {
        playHelpVoice();
        getIntentParams();
    }

    /* access modifiers changed from: protected */
    public void setResult(PayMethodItemInfo payMethodItemInfo) {
        Intent intent = new Intent();
        intent.putExtra("pay_method_list_result", payMethodItemInfo);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void getIntentParams() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mPageInfo = (PayMethodPageInfo) intent.getSerializableExtra("pay_method_list_param");
            this.mPayParam = (PayParam) intent.getSerializableExtra("pay_param");
            this.mInstallmentAddcard = intent.getStringExtra(GlobalWalletParam.Extra.PAY_ADD_CARD_INSTALLMENT);
            this.mPageType = intent.getIntExtra("page_type", 1);
            initOmegaManager(this.mPayParam);
        }
    }

    /* access modifiers changed from: protected */
    public void initOmegaManager(PayParam payParam) {
        if (payParam != null) {
            this.mOmegaManager = new GlobalPayOmegaManager();
            return;
        }
        GlobalPayOmegaManager globalPayOmegaManager = new GlobalPayOmegaManager(payParam.oid);
        this.mOmegaManager = globalPayOmegaManager;
        globalPayOmegaManager.addOmegaAttr(payParam.omegaAttrs);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar(int i) {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(i));
    }

    private void playHelpVoice() {
        final TextView textView = (TextView) findViewById(R.id.tv_payment_method_title);
        if (textView != null) {
            textView.postDelayed(new Runnable() {
                public void run() {
                    textView.setFocusable(true);
                    textView.sendAccessibilityEvent(128);
                }
            }, 60);
        }
    }

    public void showLoadingDialog() {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar);
    }

    public void hideLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void callStartActivityForResult(Intent intent, int i) {
        intent.setPackage(DeviceUtil.getPackageName(this));
        startActivityForResult(intent, i);
    }
}
