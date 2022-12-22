package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.payment.base.utils.UIUtil;
import com.taxis99.R;

public class WalletHomeOpCardButton extends AppCompatTextView {
    public WalletHomeOpCardButton(Context context) {
        super(context);
    }

    public WalletHomeOpCardButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeOpCardButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void showTopUpStyle() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wallet_global_home_account_op_btn_bg));
        setTextColor(getResources().getColor(R.color.pay_base_black));
    }

    /* renamed from: a */
    private void m23066a(float f, float f2) {
        int dip2px = UIUtil.dip2px(getContext(), f);
        int dip2px2 = UIUtil.dip2px(getContext(), f2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.height = dip2px;
        marginLayoutParams.topMargin = dip2px2;
        setLayoutParams(marginLayoutParams);
    }
}
