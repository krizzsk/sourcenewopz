package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;

public abstract class WalletHomeAbsSectionView<T, L> extends LinearLayout implements WalletCommonContract.View<T, L> {
    public static final int STYLE_DEFAULT = 0;
    public static final int STYLE_PIX_EXIST = 1;
    protected Context mContext;
    protected L mListener;

    public abstract void init(Context context);

    /* access modifiers changed from: protected */
    public void setBackgroudStyle(int i) {
    }

    public WalletHomeAbsSectionView(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    public WalletHomeAbsSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init(context);
    }

    public WalletHomeAbsSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(context);
    }

    public void setListener(L l) {
        this.mListener = l;
    }
}
