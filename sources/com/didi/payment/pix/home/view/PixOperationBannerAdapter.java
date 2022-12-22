package com.didi.payment.pix.home.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.view.adapter.OperationBannerAdapter;
import com.didi.payment.pix.home.PixChannelResp;
import com.taxis99.R;

public class PixOperationBannerAdapter extends OperationBannerAdapter<PixChannelResp.PanelEntry> {
    public PixOperationBannerAdapter(Context context, OperationBannerAdapter.AdapterItemCallback adapterItemCallback) {
        super(context, adapterItemCallback);
    }

    public OperationBannerAdapter<PixChannelResp.PanelEntry>.InnerViewHolder newInstanceViewHolder(View view) {
        return new CardViewHolder(view);
    }

    class CardViewHolder extends OperationBannerAdapter<PixChannelResp.PanelEntry>.InnerViewHolder {
        public CardViewHolder(View view) {
            super(view);
        }

        public void bindData(final PixChannelResp.PanelEntry panelEntry) {
            if (panelEntry != null) {
                resetWidthIfNeed();
                if (!TextUtils.isEmpty(panelEntry.title)) {
                    TextView textView = this.mTvTitle;
                    textView.setText(panelEntry.title + "  >");
                } else {
                    this.mTvTitle.setText("");
                }
                if (!TextUtils.isEmpty(panelEntry.subTitle)) {
                    this.mTvSubTitle.setText(panelEntry.subTitle);
                    this.mTvSubTitle.setVisibility(0);
                } else {
                    this.mTvSubTitle.setVisibility(8);
                }
                if (!TextUtils.isEmpty(panelEntry.imageUrl)) {
                    GlideUtils.with2load2SkipMemCache2into(this.itemView.getContext(), panelEntry.imageUrl, this.mIvIcon);
                }
                if (panelEntry.bgColor == null || panelEntry.bgColor.size() <= 1) {
                    this.itemView.setBackgroundResource(R.drawable.wallet_global_home_operation_item_bg);
                } else {
                    int[] iArr = new int[panelEntry.bgColor.size()];
                    int i = 0;
                    while (i < panelEntry.bgColor.size()) {
                        try {
                            iArr[i] = Color.parseColor(panelEntry.bgColor.get(i));
                            i++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
                    gradientDrawable.setCornerRadius((float) UIUtil.dip2px(this.itemView.getContext(), 20.0f));
                    gradientDrawable.setShape(0);
                    gradientDrawable.setGradientCenter(0.5f, 0.5f);
                    this.itemView.setBackground(gradientDrawable);
                }
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (PixOperationBannerAdapter.this.callback != null) {
                            PixOperationBannerAdapter.this.callback.onItemClicked(panelEntry);
                        }
                    }
                });
            }
        }
    }
}
