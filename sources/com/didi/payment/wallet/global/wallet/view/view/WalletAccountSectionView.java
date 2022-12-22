package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.taxis99.R;
import java.util.HashMap;

public class WalletAccountSectionView extends WalletAbsSectionView<WalletPageQueryResp.AccountSectionItem, IWalletMainListEventListener> implements View.OnClickListener {

    /* renamed from: a */
    private TextView f32392a;

    /* renamed from: b */
    private TextView f32393b;

    /* renamed from: c */
    private TextView f32394c;

    /* renamed from: d */
    private WalletCardButton f32395d;

    /* renamed from: e */
    private ImageView f32396e;

    /* renamed from: f */
    private ImageView f32397f;

    /* renamed from: g */
    private WalletPageQueryResp.AccountSectionItem f32398g;

    /* renamed from: h */
    private View f32399h;

    public WalletAccountSectionView(Context context) {
        super(context);
    }

    public WalletAccountSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletAccountSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f32399h = LayoutInflater.from(context).inflate(R.layout.wallet_account_section, this, true);
        this.f32392a = (TextView) findViewById(R.id.account_main_title_tv);
        this.f32393b = (TextView) findViewById(R.id.account_sub_title_tv);
        this.f32394c = (TextView) findViewById(R.id.account_desc_tv);
        this.f32395d = (WalletCardButton) findViewById(R.id.account_btn_tv);
        this.f32396e = (ImageView) findViewById(R.id.account_more_iv);
        this.f32397f = (ImageView) findViewById(R.id.account_status_iv);
    }

    public void updateContent(WalletPageQueryResp.AccountSectionItem accountSectionItem) {
        if (accountSectionItem == null) {
            setVisibility(8);
            return;
        }
        this.f32398g = accountSectionItem;
        setVisibility(0);
        this.f32392a.setText(accountSectionItem.name);
        if (accountSectionItem.richText != null) {
            accountSectionItem.richText.bindTextView(this.f32393b);
        }
        if (!TextUtils.isEmpty(accountSectionItem.buttonText)) {
            this.f32395d.setText(accountSectionItem.buttonText);
            this.f32395d.setVisibility(0);
        } else {
            this.f32395d.setVisibility(8);
        }
        this.f32395d.updateStatus(accountSectionItem.status);
        this.f32394c.setText(accountSectionItem.promotionText);
        this.f32395d.setOnClickListener(this);
        this.f32396e.setOnClickListener(this);
        this.f32399h.setOnClickListener(this);
        setWalletStatusImageView(accountSectionItem.status);
    }

    private void setWalletStatusImageView(int i) {
        this.f32397f.setImageResource(i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : R.drawable.wallet_card_status_failed : R.drawable.wallet_card_status_on_check : R.drawable.wallet_card_status_succeed : R.drawable.wallet_card_status_init);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.account_btn_tv) {
            m22994a();
        } else if (view.getId() == R.id.account_more_iv) {
            m22997c();
        } else if (view.getId() == R.id.v_account_section) {
            m22996b();
        }
    }

    /* renamed from: a */
    private void m22994a() {
        int i = this.f32398g.status;
        if (i == 0) {
            m23000f();
        } else if (i == 1) {
            m22998d();
        } else if (i == 2) {
            WalletRouter.gotoSignUpWaitingPage(getContext(), this.f32398g.accountStatus);
        } else if (i == 3) {
            m22999e();
        }
        m22995a("gp_99pay_payment_btn_ck");
    }

    /* renamed from: a */
    private void m22995a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f32398g.status));
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    /* renamed from: b */
    private void m22996b() {
        m22995a("gp_99pay_payment_blank_ck");
        WalletRouter.gotoAccountBalancePage(getContext(), this.f32398g.richText, this.f32398g.channelId, this.f32398g.detailsText, this.f32398g.balanceAmount, this.f32398g.status, this.f32398g.accountStatus, this.f32398g.hasInterest, 6);
    }

    /* renamed from: c */
    private void m22997c() {
        m22995a("gp_99pay_payment_detail_ck");
        WalletRouter.gotoAccountBalancePage(getContext(), this.f32398g.richText, this.f32398g.channelId, this.f32398g.detailsText, this.f32398g.balanceAmount, this.f32398g.status, this.f32398g.accountStatus, this.f32398g.hasInterest, 6);
    }

    /* renamed from: d */
    private void m22998d() {
        WalletRouter.gotoTopUpPage(getContext(), 3);
    }

    /* renamed from: e */
    private void m22999e() {
        if (this.f32398g.accountStatus != null) {
            WalletRouter.gotoFailedReasonPage(getContext(), this.f32398g.accountStatus);
        }
    }

    /* renamed from: f */
    private void m23000f() {
        if (WalletSPUtils.needShowGetAccountGuide(getContext())) {
            WalletRouter.gotoSignUpGuidePage(getContext(), this.f32398g.accountStatus);
            WalletSPUtils.getAccountGuideHasShowed(getContext());
            return;
        }
        WalletRouter.gotoApplyAccountPage(getContext());
    }
}
