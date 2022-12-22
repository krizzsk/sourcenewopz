package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.payment.base.utils.UIUtil;
import com.taxis99.R;

public class WalletCardButton extends AppCompatTextView {
    public WalletCardButton(Context context) {
        super(context);
    }

    public WalletCardButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletCardButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void updateStatus(int i) {
        if (i == 0) {
            m23007c();
        } else if (i == 1) {
            m23005a();
        } else if (i == 2 || i == 3) {
            m23006b();
        }
    }

    /* renamed from: a */
    private void m23005a() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wallet_account_card_orange_btn_bg));
        setTextColor(getResources().getColor(R.color.pay_base_black));
        setPadding(UIUtil.dip2px(getContext(), 10.0f), 0, UIUtil.dip2px(getContext(), 10.0f), 0);
        setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.wallet_top_up, 0, 0, 0);
        setCompoundDrawablePadding(UIUtil.dip2px(getContext(), 5.0f));
    }

    /* renamed from: b */
    private void m23006b() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wallet_account_card_white_btn_bg));
        setTextColor(getResources().getColor(R.color.white));
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(UIUtil.dip2px(getContext(), 15.0f), 0, UIUtil.dip2px(getContext(), 15.0f), 0);
    }

    /* renamed from: c */
    private void m23007c() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wallet_account_card_orange_btn_bg));
        setTextColor(getResources().getColor(R.color.pay_base_black));
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(UIUtil.dip2px(getContext(), 43.0f), 0, UIUtil.dip2px(getContext(), 43.0f), 0);
    }
}
