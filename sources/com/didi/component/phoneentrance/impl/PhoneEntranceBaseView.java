package com.didi.component.phoneentrance.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.phoneentrance.AbsPhoneEntrancePresenter;
import com.didi.component.phoneentrance.IPhoneEntranceView;
import com.taxis99.R;

public abstract class PhoneEntranceBaseView implements View.OnClickListener, IPhoneEntranceView {

    /* renamed from: a */
    private AbsPhoneEntrancePresenter f15232a;

    /* renamed from: b */
    private IPhoneEntranceView.OnPhoneEntranceClickListener f15233b;
    protected boolean isBigCard;
    protected ImageView mPhoneIcon;
    protected View mView;

    /* access modifiers changed from: protected */
    public abstract View inflateView(Context context, ViewGroup viewGroup);

    public void setPhoneGray() {
    }

    public PhoneEntranceBaseView(Context context, ViewGroup viewGroup, boolean z) {
        this.isBigCard = z;
        View inflateView = inflateView(context, viewGroup);
        this.mView = inflateView;
        ImageView imageView = (ImageView) inflateView.findViewById(R.id.phone_entrance_icon);
        this.mPhoneIcon = imageView;
        imageView.setOnClickListener(this);
    }

    public void setPhoneIcon(int i) {
        this.mPhoneIcon.setImageResource(i);
    }

    public void setPhoneClickable(boolean z) {
        this.mPhoneIcon.setEnabled(z);
    }

    public void setOnPhoneEntranceClickListener(IPhoneEntranceView.OnPhoneEntranceClickListener onPhoneEntranceClickListener) {
        this.f15233b = onPhoneEntranceClickListener;
    }

    public View getView() {
        return this.mView;
    }

    public void setPresenter(AbsPhoneEntrancePresenter absPhoneEntrancePresenter) {
        this.f15232a = absPhoneEntrancePresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IPhoneEntranceView.OnPhoneEntranceClickListener onPhoneEntranceClickListener = this.f15233b;
        if (onPhoneEntranceClickListener != null) {
            onPhoneEntranceClickListener.onPhoneEntranceClick();
        }
    }
}
