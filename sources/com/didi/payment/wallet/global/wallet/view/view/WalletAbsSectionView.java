package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class WalletAbsSectionView<T, L> extends LinearLayout {
    protected Context mContext;
    protected L mListener;

    public abstract void init(Context context);

    public abstract void updateContent(T t);

    public WalletAbsSectionView(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    public WalletAbsSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init(context);
    }

    public WalletAbsSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(context);
    }

    public void setListener(L l) {
        this.mListener = l;
    }
}
