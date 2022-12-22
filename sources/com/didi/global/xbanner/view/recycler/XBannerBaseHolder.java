package com.didi.global.xbanner.view.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.basemodel.XBCardViewData;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class XBannerBaseHolder extends RecyclerView.ViewHolder implements XbCardReloadListener {

    /* renamed from: a */
    private WeakReference<XBannerRecyclerAdapter> f22954a;
    public FrameLayout normal_content_layout;

    public XBannerBaseHolder(View view, XBannerRecyclerAdapter xBannerRecyclerAdapter) {
        super(view);
        this.normal_content_layout = (FrameLayout) view.findViewById(R.id.normal_content_layout);
        this.f22954a = new WeakReference<>(xBannerRecyclerAdapter);
    }

    public void bindData(XBannerItemBean xBannerItemBean, int i) {
        this.normal_content_layout.removeAllViews();
        bindData(this.itemView.getContext(), xBannerItemBean.cardView, xBannerItemBean.data, i);
    }

    public void bindData(Context context, XBCardView xBCardView, XBCardViewData xBCardViewData, int i) {
        View createView = xBCardView.createView(context, xBCardViewData, i);
        if (createView != null) {
            if (createView.getParent() != null) {
                ((ViewGroup) createView.getParent()).removeView(createView);
            }
            this.normal_content_layout.addView(createView);
            return;
        }
        xBCardView.setReloadListener(this);
    }

    public void onViewReload(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.normal_content_layout.addView(view);
        }
    }
}
