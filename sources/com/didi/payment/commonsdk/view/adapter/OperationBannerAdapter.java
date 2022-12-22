package com.didi.payment.commonsdk.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.List;

public abstract class OperationBannerAdapter<T> extends RecyclerView.Adapter {
    protected AdapterItemCallback callback;
    protected Context context;
    protected List<T> data;

    public interface AdapterItemCallback<T> {
        void onItemClicked(T t);
    }

    public abstract OperationBannerAdapter<T>.InnerViewHolder newInstanceViewHolder(View view);

    public OperationBannerAdapter() {
    }

    public OperationBannerAdapter(Context context2, AdapterItemCallback adapterItemCallback) {
        this.context = context2;
        this.callback = adapterItemCallback;
    }

    public void setData(List<T> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return newInstanceViewHolder(LayoutInflater.from(this.context).inflate(R.layout.wallet_global_home_operation_banner_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((InnerViewHolder) viewHolder).bindData(this.data.get(i));
    }

    public int getItemCount() {
        List<T> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getItem(int i) {
        List<T> list = this.data;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public abstract class InnerViewHolder extends RecyclerView.ViewHolder {
        protected RoundedImageView mIvIcon;
        private boolean mSingleFlag = false;
        protected TextView mTvSubTitle;
        protected TextView mTvTitle;

        public abstract void bindData(T t);

        public InnerViewHolder(View view) {
            super(view);
            this.mTvTitle = (TextView) view.findViewById(R.id.tv_operation_item_title);
            this.mTvSubTitle = (TextView) view.findViewById(R.id.tv_operation_item_subtitle);
            RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.iv_operation_item_icon);
            this.mIvIcon = roundedImageView;
            roundedImageView.setCornerType(3);
            this.mIvIcon.setRectAdius((float) UIUtil.dip2px(view.getContext(), 20.0f));
        }

        public void resetWidthIfNeed() {
            if (this.mSingleFlag && OperationBannerAdapter.this.getItemCount() == 1) {
                return;
            }
            if (this.mSingleFlag || OperationBannerAdapter.this.getItemCount() <= 1) {
                ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
                if (OperationBannerAdapter.this.getItemCount() == 1) {
                    layoutParams.width = UIUtils.getScreenWidth(this.itemView.getContext()) - UIUtil.dip2px(this.itemView.getContext(), 30.0f);
                    this.mSingleFlag = true;
                } else if (OperationBannerAdapter.this.getItemCount() > 1) {
                    layoutParams.width = UIUtil.dip2px(this.itemView.getContext(), 290.0f);
                    this.mSingleFlag = false;
                }
                this.itemView.setLayoutParams(layoutParams);
            }
        }
    }
}
