package com.didi.payment.wallet.global.wallet.view.view.mainlist;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.helper.IViewFreezeApplyer;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.view.IWalletMainListEventListener;
import com.didi.payment.wallet.global.wallet.view.view.WalletAbsSectionView;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;
import java.util.HashMap;

public class WalletMainListAccountSectionView extends WalletAbsSectionView<WalletPageQueryResp.AccountSectionItem, IWalletMainListEventListener> implements View.OnClickListener, IViewFreezeApplyer {

    /* renamed from: a */
    private View f32800a;

    /* renamed from: b */
    private TextView f32801b;

    /* renamed from: c */
    private TextView f32802c;

    /* renamed from: d */
    private TextView f32803d;

    /* renamed from: e */
    private TextView f32804e;

    /* renamed from: f */
    private TextView f32805f;

    /* renamed from: g */
    private TextView f32806g;

    /* renamed from: h */
    private RoundedImageView f32807h;

    /* renamed from: i */
    private WalletPageQueryResp.AccountSectionItem f32808i;

    /* renamed from: j */
    private View f32809j;

    /* renamed from: k */
    private AccountFreezeData f32810k = null;

    public WalletMainListAccountSectionView(Context context) {
        super(context);
    }

    public WalletMainListAccountSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletMainListAccountSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f32809j = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_mainlist_account_section, this, true);
        this.f32800a = findViewById(R.id.v_account_card_bg);
        this.f32801b = (TextView) findViewById(R.id.tv_account_title);
        this.f32802c = (TextView) findViewById(R.id.tv_account_name);
        this.f32803d = (TextView) findViewById(R.id.tv_account_msg);
        this.f32804e = (TextView) findViewById(R.id.tv_account_btn);
        this.f32805f = (TextView) findViewById(R.id.tv_account_tag);
        this.f32806g = (TextView) findViewById(R.id.tv_account_details);
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(R.id.iv_account_card_left_icon);
        this.f32807h = roundedImageView;
        roundedImageView.setCornerType(3);
        this.f32807h.setRectAdius((float) UIUtil.dip2px(this.mContext, 20.0f));
        this.f32801b.setOnClickListener(this);
        this.f32800a.setOnClickListener(this);
        this.f32804e.setOnClickListener(this);
        this.f32806g.setOnClickListener(this);
    }

    public void updateContent(final WalletPageQueryResp.AccountSectionItem accountSectionItem) {
        int i;
        if (accountSectionItem == null) {
            setVisibility(8);
            return;
        }
        this.f32808i = accountSectionItem;
        setVisibility(0);
        if (TextUtils.isEmpty(accountSectionItem.title)) {
            this.f32801b.setVisibility(8);
        } else {
            this.f32801b.setVisibility(0);
            this.f32801b.setText(accountSectionItem.title);
            if (TextUtils.isEmpty(accountSectionItem.helpUrl)) {
                this.f32801b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f32801b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wallet_global_main_list_help_icon, 0);
            }
        }
        this.f32802c.setText(accountSectionItem.name);
        if (accountSectionItem.richText != null) {
            accountSectionItem.richText.bindTextView(this.f32803d);
        }
        if (accountSectionItem.freezeData == null || !accountSectionItem.freezeData.isBlocked()) {
            if (!TextUtils.isEmpty(accountSectionItem.buttonText)) {
                this.f32804e.setText(accountSectionItem.buttonText);
                this.f32804e.setVisibility(0);
            } else {
                this.f32804e.setVisibility(8);
            }
            if (TextUtils.isEmpty(accountSectionItem.detailsText)) {
                this.f32806g.setVisibility(8);
            } else {
                TextView textView = this.f32806g;
                textView.setText(accountSectionItem.detailsText + " >");
                this.f32806g.setVisibility(0);
            }
            if (TextUtils.isEmpty(accountSectionItem.promotionText)) {
                this.f32805f.setVisibility(8);
                i = UIUtil.dip2px(this.mContext, 86.0f);
            } else {
                this.f32805f.setVisibility(0);
                this.f32805f.setText(accountSectionItem.promotionText);
                i = UIUtil.dip2px(this.mContext, 113.0f);
            }
        } else {
            this.f32810k = accountSectionItem.freezeData;
            this.f32803d.setTextColor(ResUtils.getColor(R.color.wallet_color_FFFFFF_60Alpha));
            this.f32804e.setText(ResourcesHelper.getString(this.mContext, R.string.wallet_balance_type_unblock));
            this.f32804e.setVisibility(0);
            this.f32805f.setVisibility(0);
            this.f32805f.setBackgroundResource(R.drawable.wallet_global_mainlist_account_blocked_tag_bg);
            this.f32805f.setTextColor(ResUtils.getColor(R.color.wallet_color_FF4060));
            this.f32805f.setText(accountSectionItem.freezeData.title);
            this.f32805f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletMainListAccountSectionView.this.mContext, accountSectionItem.freezeData.link, "");
                }
            });
            i = UIUtil.dip2px(this.mContext, 113.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.f32800a.getLayoutParams();
        layoutParams.height = i;
        this.f32800a.setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.tv_account_btn) {
            AccountFreezeData accountFreezeData = this.f32810k;
            if (accountFreezeData == null || accountFreezeData.dialogData == null) {
                m23153a();
            } else {
                DRouter.build(this.f32810k.dialogData.landingUrl).start((Context) null);
            }
        } else if (view.getId() == R.id.v_account_card_bg) {
            if (this.f32810k != null) {
                WalletRouter.gotoAccountBalancePageWithBlockData(getContext(), this.f32808i.richText, this.f32808i.channelId, this.f32808i.detailsText, this.f32808i.balanceAmount, this.f32808i.status, this.f32808i.accountStatus, this.f32808i.hasInterest, 6, this.f32810k);
            } else {
                m23155b();
            }
        } else if (view.getId() == R.id.tv_account_title) {
            if (this.mListener != null && !TextUtils.isEmpty(this.f32808i.helpUrl)) {
                ((IWalletMainListEventListener) this.mListener).onPayMethodHelpEvent(this.f32808i.helpUrl);
            }
        } else if (view.getId() == R.id.tv_account_details) {
            m23157d();
        }
    }

    /* renamed from: a */
    private void m23153a() {
        int i = this.f32808i.status;
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            m23156c();
        }
        m23154a("gp_99pay_payment_btn_ck");
    }

    /* renamed from: a */
    private void m23154a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f32808i.status));
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    /* renamed from: b */
    private void m23155b() {
        m23154a("gp_99pay_payment_blank_ck");
        WalletRouter.gotoAccountBalancePage(getContext(), this.f32808i.richText, this.f32808i.channelId, this.f32808i.detailsText, this.f32808i.balanceAmount, this.f32808i.status, this.f32808i.accountStatus, this.f32808i.hasInterest, 6);
    }

    /* renamed from: c */
    private void m23156c() {
        WalletRouter.gotoTopUpPage(getContext(), 5);
    }

    /* renamed from: d */
    private void m23157d() {
        WalletPageQueryResp.AccountSectionItem accountSectionItem = this.f32808i;
        if (accountSectionItem != null) {
            if (accountSectionItem.status != 1) {
                HashMap hashMap = new HashMap();
                hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(this.f32808i.status));
                hashMap.put("interest_status", Integer.valueOf(this.f32808i.interestStatus));
                PayTracker.trackEvent("ibt_didipay_sidebar_interest_signup_ck", hashMap);
            }
            if (this.f32808i.status == 0) {
                DRouter.build("99pay://one/register").start((Context) null);
            } else if (this.f32808i.status == 3) {
                WalletRouter.gotoFailedReasonPage(getContext(), this.f32808i.accountStatus);
            } else if (this.f32808i.status == 2) {
                WalletRouter.gotoSignUpWaitingPage(getContext(), this.f32808i.accountStatus);
            } else if (this.f32808i.status != 1) {
            } else {
                if (this.f32808i.balanceAmount == 0.0d) {
                    DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_TOPUP).start((Context) null);
                } else {
                    WalletRouter.gotoAccountBalancePage(getContext(), this.f32808i.richText, this.f32808i.channelId, this.f32808i.detailsText, this.f32808i.balanceAmount, this.f32808i.status, this.f32808i.accountStatus, this.f32808i.hasInterest, 7);
                }
            }
        }
    }

    public void apply(IViewFreezeApplyer.FreezeState freezeState) {
        if (freezeState != null && freezeState.isFreeze) {
            this.f32802c.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_FFFFFF_60Alpha));
            this.f32803d.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_FFFFFF_60Alpha));
            this.f32804e.setBackground(ResourcesHelper.getDrawable(getContext(), R.drawable.wallet_global_mainlist_account_btn_disable_bg));
            this.f32804e.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_D4D7D9));
            this.f32804e.setOnClickListener((View.OnClickListener) null);
            this.f32806g.setVisibility(4);
            if (this.f32805f.getVisibility() == 0) {
                this.f32805f.setVisibility(8);
                int dip2px = UIUtil.dip2px(this.mContext, 86.0f);
                ViewGroup.LayoutParams layoutParams = this.f32800a.getLayoutParams();
                layoutParams.height = dip2px;
                this.f32800a.setLayoutParams(layoutParams);
            }
        }
    }
}
