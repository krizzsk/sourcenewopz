package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class WalletHomeAccountSectionBlockedView extends WalletHomeAbsSectionView<WalletHomeResp.AccountSection, WalletHomeContract.Listener> implements View.OnClickListener {

    /* renamed from: a */
    private TextView f32545a;

    /* renamed from: b */
    private TextView f32546b;

    /* renamed from: c */
    private WalletHomeOpCardButton f32547c;

    /* renamed from: d */
    private TextView f32548d;

    /* renamed from: e */
    private WalletHomeResp.AccountSection f32549e;

    public WalletHomeAccountSectionBlockedView(Context context) {
        super(context);
    }

    public WalletHomeAccountSectionBlockedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeAccountSectionBlockedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        WalletHomeResp.AccountSection accountSection = this.f32549e;
        if (accountSection != null && accountSection.accountFreezeData != null && this.f32549e.accountFreezeData.isBlocked()) {
            if (id == R.id.wallet_blocked_unblock_btn) {
                ((WalletHomeContract.Listener) this.mListener).onAccountBlocked2UnBlock(this.f32549e.accountFreezeData.dialogData.landingUrl);
            } else if (id == R.id.wallet_blocked_title_tv) {
                ((WalletHomeContract.Listener) this.mListener).onAccountFrozenDetailClick(this.f32549e.accountFreezeData.link);
                FinOmegaSDK.trackEvent("ibt_didipay_unblock_faq_ck");
            } else if (id == R.id.wallet_blocked_balance_amount_tv) {
                ((WalletHomeContract.Listener) this.mListener).onAccountBlocked2BalanceWithData(this.f32549e);
            }
        }
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_home_account_blocked_section, this, true);
        this.f32545a = (TextView) findViewById(R.id.wallet_blocked_title_tv);
        this.f32546b = (TextView) findViewById(R.id.wallet_blocked_desc_tv);
        this.f32547c = (WalletHomeOpCardButton) findViewById(R.id.wallet_blocked_unblock_btn);
        this.f32548d = (TextView) findViewById(R.id.wallet_blocked_balance_amount_tv);
        this.f32545a.setOnClickListener(this);
        this.f32547c.setOnClickListener(this);
        this.f32548d.setOnClickListener(this);
    }

    public void updateContent(WalletHomeResp.AccountSection accountSection) {
        this.f32549e = accountSection;
        if (accountSection.accountFreezeData != null && accountSection.accountFreezeData.isBlocked()) {
            this.f32545a.setText(accountSection.accountFreezeData.title);
            this.f32546b.setText(accountSection.accountFreezeData.subTitle);
            this.f32547c.setText(ResourcesHelper.getString(this.mContext, R.string.wallet_balance_type_unblock));
            if (accountSection.statusMsg != null) {
                accountSection.statusMsg.bindTextView(this.f32548d);
            }
        }
    }
}
