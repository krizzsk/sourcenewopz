package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.WalletTriangleView;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class WalletHomeAccountSectionView extends WalletHomeAbsSectionView<WalletHomeResp.AccountSection, WalletHomeContract.Listener> implements View.OnClickListener {

    /* renamed from: a */
    private View f32574a;

    /* renamed from: b */
    private View f32575b;

    /* renamed from: c */
    private TextView f32576c;

    /* renamed from: d */
    private TextView f32577d;

    /* renamed from: e */
    private TextView f32578e;

    /* renamed from: f */
    private WalletTriangleView f32579f;

    /* renamed from: g */
    private TextView f32580g;

    /* renamed from: h */
    private WalletHomeCardButton f32581h;

    /* renamed from: i */
    private View f32582i;

    /* renamed from: j */
    private View f32583j;

    /* renamed from: k */
    private WalletHomeResp.AccountSection f32584k;

    public WalletHomeAccountSectionView(Context context) {
        super(context);
    }

    public WalletHomeAccountSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeAccountSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f32583j = LayoutInflater.from(context).inflate(R.layout.wallet_global_home_account_section, this, true);
        this.f32574a = findViewById(R.id.wallet_home_account_root_view);
        this.f32575b = findViewById(R.id.v_account_card_bg);
        this.f32576c = (TextView) findViewById(R.id.tv_account_title);
        this.f32577d = (TextView) findViewById(R.id.tv_account_msg);
        this.f32578e = (TextView) findViewById(R.id.tv_account_details);
        this.f32580g = (TextView) findViewById(R.id.tv_account_interest_msg);
        this.f32581h = (WalletHomeCardButton) findViewById(R.id.wb_account_btn);
        this.f32582i = findViewById(R.id.v_account_btn_mask);
        WalletTriangleView walletTriangleView = (WalletTriangleView) findViewById(R.id.wt_account_details_arrow);
        this.f32579f = walletTriangleView;
        walletTriangleView.setColor(ResourcesHelper.getColor(this.mContext, R.color.wallet_color_B2E4FFD8));
        this.f32581h.setOnClickListener(this);
        this.f32574a.setOnClickListener(this);
        this.f32577d.setOnClickListener(this);
        this.f32578e.setOnClickListener(this);
    }

    public void updateContent(WalletHomeResp.AccountSection accountSection) {
        if (accountSection == null) {
            setVisibility(8);
            return;
        }
        this.f32584k = accountSection;
        setVisibility(0);
        this.f32576c.setText(accountSection.title);
        if (accountSection.statusMsg != null) {
            accountSection.statusMsg.bindTextView(this.f32577d);
        }
        if (TextUtils.isEmpty(accountSection.detailsMsg)) {
            this.f32579f.setVisibility(8);
            this.f32578e.setVisibility(8);
        } else {
            this.f32579f.setVisibility(0);
            this.f32578e.setVisibility(0);
            TextView textView = this.f32578e;
            textView.setText(accountSection.detailsMsg + " >");
        }
        if (accountSection.interestMsg != null) {
            accountSection.interestMsg.bindTextView(this.f32580g);
        }
        if (TextUtils.isEmpty(accountSection.detailsMsg) && accountSection.interestMsg == null) {
            setCardHeight(195);
        } else if (accountSection.interestMsg == null) {
            setCardHeight(235);
        } else if (!TextUtils.isEmpty(accountSection.detailsMsg) && accountSection.interestMsg != null) {
            setCardHeight(241);
        }
        if (!TextUtils.isEmpty(accountSection.buttonText)) {
            this.f32581h.setText(accountSection.buttonText);
            this.f32581h.setVisibility(0);
            this.f32581h.showTopUpStyle();
        } else {
            this.f32581h.setVisibility(8);
        }
        setMsgStatusDrawable(accountSection.status);
    }

    private void setCardHeight(int i) {
        int dip2px = UIUtil.dip2px(getContext(), (float) i);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32575b.getLayoutParams();
        marginLayoutParams.height = dip2px;
        this.f32575b.setLayoutParams(marginLayoutParams);
    }

    private void setMsgStatusDrawable(int i) {
        this.f32577d.setCompoundDrawablesWithIntrinsicBounds(0, 0, (i == 0 || i == 1 || i == 2 || i == 3) ? R.drawable.wallet_global_home_status_msg_arrow : 0, 0);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null) {
            if (view.getId() == R.id.wb_account_btn) {
                ((WalletHomeContract.Listener) this.mListener).onAccountMainEnterClicked(this.f32584k);
            } else if (view.getId() == R.id.wallet_home_account_root_view) {
                ((WalletHomeContract.Listener) this.mListener).onWholeCardClicked(this.f32584k);
            } else if (view.getId() == R.id.tv_account_msg) {
                ((WalletHomeContract.Listener) this.mListener).onStatusMsgClicked(this.f32584k);
            } else if (view.getId() == R.id.tv_account_details) {
                ((WalletHomeContract.Listener) this.mListener).onDetailsClicked(this.f32584k);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setBackgroudStyle(int i) {
        if (i == 1) {
            this.f32574a.setBackgroundColor(getResources().getColor(R.color.wallet_color_EEFAF1));
        }
    }
}
