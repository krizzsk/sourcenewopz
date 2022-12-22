package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.wallet.global.constant.ProtocolType;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletUserProtocolsResp;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpChannelContractOldServer;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpChannelPresenterOldServer;
import com.didi.payment.wallet.global.wallet.view.widget.TermsAndConditionsDialogFragment;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class WalletTopUpChannelActivityOldServer extends WalletBaseActivity implements WalletTopUpChannelContractOldServer.View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletTopUpChannelContractOldServer.Presenter f32240a;

    /* renamed from: b */
    private View f32241b;

    /* renamed from: c */
    private View f32242c;

    /* renamed from: d */
    private TextView f32243d;

    /* renamed from: e */
    private TextView f32244e;

    /* renamed from: f */
    private TextView f32245f;

    /* renamed from: g */
    private TextView f32246g;

    /* renamed from: h */
    private LinearLayout f32247h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletUserProtocolsResp.DataBean f32248i;

    /* renamed from: j */
    private String f32249j;

    public Context getContext() {
        return this;
    }

    public static void launch(Context context, boolean z) {
        Intent intent = new Intent(context, WalletTopUpChannelActivityOldServer.class);
        intent.putExtra("key_from_wallet", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, int i, boolean z) {
        Intent intent = new Intent(context, WalletTopUpChannelActivityOldServer.class);
        intent.putExtra("key_from_wallet", z);
        boolean z2 = context instanceof Activity;
        if (!z2) {
            intent.addFlags(268435456);
        }
        if (z2) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_topup_channel_old_server);
        m22885a();
        m22886a((Activity) this);
        WalletTopUpChannelPresenterOldServer walletTopUpChannelPresenterOldServer = new WalletTopUpChannelPresenterOldServer(this, this);
        this.f32240a = walletTopUpChannelPresenterOldServer;
        walletTopUpChannelPresenterOldServer.requestData();
        this.f32240a.requestTACProtocolInfo(ProtocolType.TOP_UP.name());
    }

    /* renamed from: a */
    private void m22886a(final Activity activity) {
        LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                PayGlobalLoading.show(activity, (int) R.id.layout_title_bar, true);
            }

            public void dismissLoading() {
                PayGlobalLoading.hide();
            }
        });
    }

    /* renamed from: a */
    private void m22885a() {
        this.f32241b = findViewById(R.id.ll_content);
        this.f32242c = findViewById(R.id.ll_empty);
        this.f32247h = (LinearLayout) findViewById(R.id.ll_channels);
        this.f32243d = (TextView) findViewById(R.id.tv_title);
        this.f32244e = (TextView) findViewById(R.id.tv_desc);
        this.f32245f = (TextView) findViewById(R.id.tv_rule);
        this.f32246g = (TextView) findViewById(R.id.tv_condition);
        this.f32242c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpChannelActivityOldServer.this.f32240a.requestData();
                WalletTopUpChannelActivityOldServer.this.f32240a.requestTACProtocolInfo(ProtocolType.TOP_UP.name());
            }
        });
        findViewById(R.id.iv_left).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpChannelActivityOldServer.this.finish();
            }
        });
    }

    public void showLoadingDialog() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().showLoading();
        }
    }

    public void dismissLoadingDialog() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().dismissLoading();
        }
    }

    public void refreshUI(WalletTopUpChannelRespOldServer.DataBean dataBean) {
        this.f32241b.setVisibility(0);
        this.f32243d.setText(dataBean.channelPageTitle);
        this.f32244e.setText(dataBean.channelDesc);
        this.f32245f.setText(dataBean.channelRuleText);
        this.f32246g.setText(dataBean.conditionText);
        this.f32246g.setOnClickListener(new DoubleCheckOnClickListener(500) {
            public void doClick(View view) {
                if (WalletTopUpChannelActivityOldServer.this.f32248i != null) {
                    if (WalletTopUpChannelActivityOldServer.this.f32248i.unAcceptProtocol != null) {
                        WalletTopUpChannelActivityOldServer walletTopUpChannelActivityOldServer = WalletTopUpChannelActivityOldServer.this;
                        walletTopUpChannelActivityOldServer.m22887a(walletTopUpChannelActivityOldServer.f32248i.unAcceptProtocol);
                    } else if (WalletTopUpChannelActivityOldServer.this.f32248i.acceptedProtocol != null) {
                        WebBrowserUtil.startInternalWebActivity(WalletTopUpChannelActivityOldServer.this.getContext(), WalletTopUpChannelActivityOldServer.this.f32248i.acceptedProtocol.link, "");
                    }
                }
            }
        });
        m22889a(dataBean.channels);
        this.f32249j = dataBean.conditionText;
    }

    /* renamed from: a */
    private void m22889a(List<WalletTopUpChannelRespOldServer.ChannelBean> list) {
        this.f32247h.removeAllViews();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                final WalletTopUpChannelRespOldServer.ChannelBean channelBean = list.get(i);
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_global_v_topup_channel_item, (ViewGroup) null, false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this, 60.0f));
                TextView textView = (TextView) inflate.findViewById(R.id.tv_channel_extra);
                GlideUtils.with2load2into(getContext(), channelBean.icon, (ImageView) inflate.findViewById(R.id.iv_channel_icon));
                ((TextView) inflate.findViewById(R.id.tv_channel_name)).setText(channelBean.name);
                if (TextUtils.isEmpty(channelBean.extraInfo)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(channelBean.extraInfo);
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (WalletTopUpChannelActivityOldServer.this.f32248i == null || WalletTopUpChannelActivityOldServer.this.f32248i.unAcceptProtocol == null) {
                            WalletTopUpChannelActivityOldServer.this.f32240a.handleChannelClick(channelBean);
                            return;
                        }
                        WalletTopUpChannelActivityOldServer walletTopUpChannelActivityOldServer = WalletTopUpChannelActivityOldServer.this;
                        walletTopUpChannelActivityOldServer.m22887a(walletTopUpChannelActivityOldServer.f32248i.unAcceptProtocol);
                    }
                });
                this.f32247h.addView(inflate, layoutParams);
            }
        }
    }

    public void onNetworkError() {
        this.f32241b.setVisibility(8);
        this.f32242c.setVisibility(0);
    }

    public void showTACDialog(WalletUserProtocolsResp.DataBean dataBean) {
        this.f32248i = dataBean;
        String stringParam = PayBaseParamUtil.getStringParam(this, "phone");
        if (dataBean.unAcceptProtocol != null && PaySharedPreferencesUtil.isFirstEnteringTopUpPage(this, stringParam)) {
            m22887a(dataBean.unAcceptProtocol);
            PaySharedPreferencesUtil.setFirstEnteringTopUpPage(this, stringParam, false);
            PaySharedPreferencesUtil.setAgreeTopUpProtocol(this, stringParam, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22887a(final WalletUserProtocolsResp.UnAcceptProtocol unAcceptProtocol) {
        TermsAndConditionsDialogFragment termsAndConditionsDialogFragment = new TermsAndConditionsDialogFragment(this.f32249j, new TermsAndConditionsDialogFragment.DialogBtnClickListener() {
            public void onClicked(TextView textView) {
                WalletTopUpChannelActivityOldServer.this.f32240a.handleTACDialogBtnClick(unAcceptProtocol);
            }
        });
        termsAndConditionsDialogFragment.setData(unAcceptProtocol.link);
        termsAndConditionsDialogFragment.show(getSupportFragmentManager(), "terms_and_conditions_fragment_dialog");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 200) {
                if (intent.getIntExtra("code", 3) == 1) {
                    finish();
                }
            } else if (intent.getIntExtra("code", 3) == 1) {
                finish();
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
