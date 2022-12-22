package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.HashMap;

public class WalletHomeAccountSectionFrozenView extends WalletHomeAbsSectionView<WalletHomeResp.AccountSection, WalletHomeContract.Listener> implements View.OnClickListener {

    /* renamed from: a */
    private TextView f32550a;

    /* renamed from: b */
    private TextView f32551b;

    /* renamed from: c */
    private TextView f32552c;

    /* renamed from: d */
    private TextView f32553d;

    /* renamed from: e */
    private WalletHomeResp.AccountSection f32554e;

    /* renamed from: f */
    private View f32555f;

    public WalletHomeAccountSectionFrozenView(Context context) {
        super(context);
    }

    public WalletHomeAccountSectionFrozenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeAccountSectionFrozenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_home_account_frozen_section, this, true);
        this.f32555f = findViewById(R.id.frozen_header_view);
        this.f32550a = (TextView) findViewById(R.id.frozen_header_main_title_tv);
        this.f32551b = (TextView) findViewById(R.id.frozen_header_subtitle_tv);
        this.f32552c = (TextView) findViewById(R.id.frozen_header_extra_tv);
        TextView textView = (TextView) findViewById(R.id.wallet_blocked_balance_amount_tv);
        this.f32553d = textView;
        textView.setOnClickListener(this);
        findViewById(R.id.wallet_blocked_balance_card_rl).setOnClickListener(this);
    }

    public void updateContent(WalletHomeResp.AccountSection accountSection) {
        if (accountSection == null || accountSection.accountFreezeData == null) {
            setVisibility(8);
            return;
        }
        this.f32554e = accountSection;
        setVisibility(0);
        AccountFreezeData accountFreezeData = accountSection.accountFreezeData;
        this.f32550a.setText(accountFreezeData.title);
        this.f32551b.setText(accountFreezeData.subTitle);
        this.f32552c.setText(accountFreezeData.desc);
        if (!accountFreezeData.isJumpable(0)) {
            this.f32555f.setOnClickListener((View.OnClickListener) null);
            this.f32550a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            this.f32555f.setOnClickListener(this);
        }
        if (accountSection.statusMsg != null) {
            accountSection.statusMsg.updateTextColor("#99FFFFFF");
            accountSection.statusMsg.bindTextView(this.f32553d);
            this.f32553d.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_FFFFFF_60Alpha));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_status", Integer.valueOf(accountFreezeData.freezeStatus));
        hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(this.mContext, "uid"));
        PayTracker.trackEvent("pax_freezen_banner_sw", hashMap);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null) {
            if (view.getId() == R.id.frozen_header_view) {
                WalletHomeResp.AccountSection accountSection = this.f32554e;
                if (accountSection != null && accountSection.accountFreezeData != null) {
                    String link = this.f32554e.accountFreezeData.getLink(0);
                    if (!TextUtils.isEmpty(link)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("passenger_status", Integer.valueOf(this.f32554e.accountFreezeData.freezeStatus));
                        hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(this.mContext, "uid"));
                        PayTracker.trackEvent("pax_freezen_banner_ck", hashMap);
                        ((WalletHomeContract.Listener) this.mListener).onAccountFrozenDetailClick(link);
                    }
                }
            } else if (view.getId() == R.id.wallet_blocked_balance_amount_tv) {
                ((WalletHomeContract.Listener) this.mListener).onStatusMsgClicked(this.f32554e);
            } else if (view.getId() == R.id.wallet_blocked_balance_card_rl) {
                ((WalletHomeContract.Listener) this.mListener).onWholeCardClicked(this.f32554e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setBackgroudStyle(int i) {
        super.setBackgroudStyle(i);
    }
}
