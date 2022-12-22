package global.didi.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.ConfirmTipsInfo;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.sdk.net.UnipayServiceFactory;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.sdk.net.service.UniPayTripHttpServiceImpl;
import com.taxis99.R;
import global.didi.pay.select.model.RequestPayEvent;
import org.greenrobot.eventbus.EventBus;

public class GlobalConfirmActivity extends FragmentActivity {
    private ImageView iv_left;
    private String mCurrency;
    private IUnipayService mUniPayService;
    /* access modifiers changed from: private */
    public RelativeLayout rl_content;
    /* access modifiers changed from: private */
    public TextView tv_cancel;
    /* access modifiers changed from: private */
    public TextView tv_confirm;
    /* access modifiers changed from: private */
    public TextView tv_content;
    /* access modifiers changed from: private */
    public TextView tv_page_title;
    /* access modifiers changed from: private */
    public TextView tv_title;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
        setContentView((int) R.layout.oc_uni_pay_confirm_pay_layout);
        initView();
        initClickListener();
        initData();
    }

    private void initView() {
        this.iv_left = (ImageView) findViewById(R.id.iv_left);
        this.tv_page_title = (TextView) findViewById(R.id.tv_page_title);
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        this.tv_content = (TextView) findViewById(R.id.tv_content);
        this.tv_confirm = (TextView) findViewById(R.id.tv_confirm);
        this.tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        this.rl_content = (RelativeLayout) findViewById(R.id.rl_content);
        initProgressDialog(this);
    }

    private void initClickListener() {
        this.iv_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalConfirmActivity.this.onBackPressed();
            }
        });
        this.tv_confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalConfirmActivity.this.sendPrePayEvent();
            }
        });
        this.tv_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalConfirmActivity.this.onBackPressed();
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("channelId", 0);
        long longExtra = intent.getLongExtra("totalFee", 0);
        String stringExtra = intent.getStringExtra("oid");
        int intExtra2 = intent.getIntExtra("bid", 0);
        this.mCurrency = intent.getStringExtra("currency");
        IUnipayService service = UnipayServiceFactory.createUnipayServiceFactory(this).getService((PayConstant.PayBillType) intent.getSerializableExtra("billType"));
        this.mUniPayService = service;
        ((UniPayTripHttpServiceImpl) service).init(intExtra2, stringExtra);
        requestConfirmTipsInfo(intExtra, longExtra);
    }

    private void requestConfirmTipsInfo(int i, long j) {
        showProgressDialog();
        C208504 r5 = new PayServiceCallback<ConfirmTipsInfo>() {
            public void onSuccess(ConfirmTipsInfo confirmTipsInfo) {
                GlobalConfirmActivity.this.dismissProgressDialog();
                if (confirmTipsInfo != null) {
                    GlobalConfirmActivity.this.rl_content.setVisibility(0);
                    GlobalConfirmActivity.this.tv_page_title.setText(confirmTipsInfo.page_title);
                    GlobalConfirmActivity.this.tv_title.setText(confirmTipsInfo.title);
                    GlobalConfirmActivity.this.tv_content.setText(confirmTipsInfo.content);
                    if (confirmTipsInfo.buttons != null) {
                        for (ConfirmTipsInfo.Button next : confirmTipsInfo.buttons) {
                            if (next.type == 1) {
                                GlobalConfirmActivity.this.tv_confirm.setText(next.text);
                            } else if (next.type == 2) {
                                GlobalConfirmActivity.this.tv_cancel.setText(next.text);
                            }
                        }
                    }
                }
            }

            public void onFail(Error error) {
                GlobalConfirmActivity.this.dismissProgressDialog();
            }
        };
        IUnipayService iUnipayService = this.mUniPayService;
        if (iUnipayService != null) {
            iUnipayService.getConfirmInfo(i, j, this.mCurrency, r5);
        }
    }

    /* access modifiers changed from: private */
    public void sendPrePayEvent() {
        RequestPayEvent requestPayEvent = new RequestPayEvent();
        requestPayEvent.type = RequestPayEvent.RequestType.PrePay;
        EventBus.getDefault().post(requestPayEvent);
        setResult(-1);
        finish();
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        releaseProgressDialog();
    }

    public void initProgressDialog(final Activity activity) {
        LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                PayGlobalLoading.show(activity, (int) R.id.layout_title_bar, true);
            }

            public void dismissLoading() {
                PayGlobalLoading.hide();
            }
        });
    }

    public void showProgressDialog() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().showLoading();
        }
    }

    public void dismissProgressDialog() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().dismissLoading();
        }
    }

    public void releaseProgressDialog() {
        LoadingProxyHolder.releaseProxy();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }
}
