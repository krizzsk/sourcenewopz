package com.didi.component.dispatchfee.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.dispatchfee.AbsDispatchFeePresenter;
import com.didi.component.dispatchfee.IDispatchFeeView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;

public class DispatchFeeView implements View.OnClickListener, IDispatchFeeView {

    /* renamed from: a */
    private View f12794a;

    /* renamed from: b */
    private ImageView f12795b = ((ImageView) this.f12794a.findViewById(R.id.iv_dispatch_fee));

    /* renamed from: c */
    private AbsDispatchFeePresenter f12796c;

    /* renamed from: d */
    private Context f12797d;
    public TextView mDispatchFeeTv;

    public DispatchFeeView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f12797d = componentParams.bizCtx.getContext();
        View inflate = LayoutInflater.from(componentParams.bizCtx.getContext()).inflate(R.layout.global_dispatch_fee_new_ui_layout, viewGroup, false);
        this.f12794a = inflate;
        this.mDispatchFeeTv = (TextView) inflate.findViewById(R.id.tv_dispatch_fee_msg);
        this.f12794a.setOnClickListener(this);
    }

    public View getView() {
        return this.f12794a;
    }

    public void setPresenter(AbsDispatchFeePresenter absDispatchFeePresenter) {
        this.f12796c = absDispatchFeePresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        AbsDispatchFeePresenter absDispatchFeePresenter = this.f12796c;
        if (absDispatchFeePresenter != null) {
            absDispatchFeePresenter.onClick(view);
        }
    }

    public void setDispatchFee(String str) {
        TextView textView = this.mDispatchFeeTv;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTextColor(int i) {
        TextView textView = this.mDispatchFeeTv;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setClickable(boolean z) {
        View view = this.f12794a;
        if (view != null) {
            view.setClickable(z);
        }
    }

    public void bindDispatchFee(GlobalRichInfo globalRichInfo) {
        TextView textView = this.mDispatchFeeTv;
        if (textView != null) {
            globalRichInfo.bindTextView(textView);
        }
    }

    public void setDispatchIcon(String str) {
        if (this.f12795b != null) {
            ((RequestBuilder) Glide.with(this.f12797d).load(str).placeholder((int) R.drawable.global_dispatchfee_service_icon_dispatching_fee)).into(this.f12795b);
        }
    }
}
