package com.didi.component.comp_selectseat.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;

public class SeatsViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout mHybridIconAndTextLayout;
    public RelativeLayout mItemRoot;
    public View mLoadingBottomView;
    public View mLoadingTopView;
    public LinearLayout mPriceContainer;
    public LinearLayout mPriceLayout;
    public TextView mSeatCount;
    public ImageView mSelectIcon;

    public SeatsViewHolder(View view) {
        super(view);
        this.mSeatCount = (TextView) view.findViewById(R.id.tv_seatCount);
        this.mPriceContainer = (LinearLayout) view.findViewById(R.id.ll_price_list);
        this.mHybridIconAndTextLayout = (LinearLayout) view.findViewById(R.id.ll_hybrid_icon_and_text);
        this.mSelectIcon = (ImageView) view.findViewById(R.id.iv_select_icon);
        this.mItemRoot = (RelativeLayout) view.findViewById(R.id.rl_item_root);
        this.mLoadingBottomView = view.findViewById(R.id.v_loading_bottom_view);
        this.mLoadingTopView = view.findViewById(R.id.v_loading_top_view);
        this.mPriceLayout = (LinearLayout) view.findViewById(R.id.ll_price_layout);
    }
}
