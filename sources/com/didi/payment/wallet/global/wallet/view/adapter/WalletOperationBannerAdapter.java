package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.commonsdk.view.adapter.OperationBannerAdapter;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;
import com.taxis99.R;
import java.util.List;

public class WalletOperationBannerAdapter extends OperationBannerAdapter<WalletOperationItem> {
    public WalletOperationBannerAdapter(Context context, OperationBannerAdapter.AdapterItemCallback adapterItemCallback) {
        super(context, adapterItemCallback);
    }

    public void setData(List<WalletOperationItem> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return super.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((CardViewHolder) viewHolder).bindData((WalletOperationItem) this.data.get(i));
    }

    public int getItemCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    public WalletOperationItem getItem(int i) {
        if (this.data == null || i < 0 || i >= this.data.size()) {
            return null;
        }
        return (WalletOperationItem) this.data.get(i);
    }

    public OperationBannerAdapter<WalletOperationItem>.InnerViewHolder newInstanceViewHolder(View view) {
        return new CardViewHolder(view);
    }

    class CardViewHolder extends OperationBannerAdapter<WalletOperationItem>.InnerViewHolder {
        private RoundedImageView mIvIcon;
        private boolean mSingleFlag = false;
        private TextView mTvSubTitle;
        private TextView mTvTitle;

        public CardViewHolder(View view) {
            super(view);
            this.mTvTitle = (TextView) view.findViewById(R.id.tv_operation_item_title);
            this.mTvSubTitle = (TextView) view.findViewById(R.id.tv_operation_item_subtitle);
            RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.iv_operation_item_icon);
            this.mIvIcon = roundedImageView;
            roundedImageView.setCornerType(3);
            this.mIvIcon.setRectAdius((float) UIUtil.dip2px(view.getContext(), 20.0f));
        }

        public void bindData(final WalletOperationItem walletOperationItem) {
            if (walletOperationItem != null) {
                resetWidthIfNeed();
                if (!TextUtils.isEmpty(walletOperationItem.title)) {
                    TextView textView = this.mTvTitle;
                    textView.setText(walletOperationItem.title + "  >");
                } else {
                    this.mTvTitle.setText("");
                }
                if (!TextUtils.isEmpty(walletOperationItem.subTitle)) {
                    this.mTvSubTitle.setText(walletOperationItem.subTitle);
                    this.mTvSubTitle.setVisibility(0);
                } else {
                    this.mTvSubTitle.setVisibility(8);
                }
                if (!TextUtils.isEmpty(walletOperationItem.imageUrl)) {
                    GlideUtils.with2load2SkipMemCache2into(this.itemView.getContext(), walletOperationItem.imageUrl, this.mIvIcon);
                }
                if (walletOperationItem.bgColor == null || walletOperationItem.bgColor.length <= 1) {
                    this.itemView.setBackgroundResource(R.drawable.wallet_global_home_operation_item_bg);
                } else {
                    int[] iArr = new int[walletOperationItem.bgColor.length];
                    int i = 0;
                    while (i < walletOperationItem.bgColor.length) {
                        try {
                            iArr[i] = Color.parseColor(walletOperationItem.bgColor[i]);
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
                        if (WalletOperationBannerAdapter.this.callback != null) {
                            WalletOperationBannerAdapter.this.callback.onItemClicked(walletOperationItem);
                        }
                    }
                });
            }
        }
    }
}
