package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.payment.base.utils.UIUtil;
import com.taxis99.R;

public class WalletHomeCardButton extends AppCompatTextView {
    public WalletHomeCardButton(Context context) {
        super(context);
    }

    public WalletHomeCardButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeCardButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void showTopUpStyle() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wallet_global_home_account_btn_big_bg));
        setTextColor(getResources().getColor(R.color.pay_base_black));
    }

    private void setLayoutHeight(float f) {
        int dip2px = UIUtil.dip2px(getContext(), f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = dip2px;
        setLayoutParams(layoutParams);
    }
}
