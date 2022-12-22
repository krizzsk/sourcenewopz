package com.didi.payment.wallet.global.useraccount.balance.view.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private int mCurrentPosition;

    /* access modifiers changed from: protected */
    public abstract void clear();

    public BaseViewHolder(View view) {
        super(view);
    }

    public void onBind(int i) {
        this.mCurrentPosition = i;
        clear();
    }

    public int getmCurrentPosition() {
        return this.mCurrentPosition;
    }
}
