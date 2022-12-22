package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletMainListSettingContract;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class WalletMainListSettingListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f32310a;

    /* renamed from: b */
    private List<WalletMainListSettingContract.SettingItemModel> f32311b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Callback f32312c;

    public interface Callback {
        void onSettingItemClicked(int i, String str, WalletMainListSettingContract.SettingItemModel settingItemModel);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public WalletMainListSettingListAdapter(Context context) {
        this.f32310a = context;
    }

    public void setCallback(Callback callback) {
        this.f32312c = callback;
    }

    public void setData(List<WalletMainListSettingContract.SettingItemModel> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f32311b.clear();
            this.f32311b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void refreshRedDot(int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f32311b)) {
            Iterator<WalletMainListSettingContract.SettingItemModel> it = this.f32311b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WalletMainListSettingContract.SettingItemModel next = it.next();
                if (next.type == i) {
                    next.hasRedPoint = false;
                    break;
                }
            }
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.f32311b.size();
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        List<WalletMainListSettingContract.SettingItemModel> list = this.f32311b;
        if (list != null && i < list.size()) {
            itemViewHolder.bind(this.f32311b.get(i));
        }
    }

    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(m22935a(viewGroup, R.layout.wallet_global_mainlist_setting_item));
    }

    /* renamed from: a */
    private View m22935a(ViewGroup viewGroup, int i) {
        return LayoutInflater.from(this.f32310a).inflate(i, viewGroup, false);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvIcon;
        private ImageView mIvRightIcon;
        private TextView mTvDesc;
        private TextView mTvName;
        private TextView mTvRightLabel1;
        private TextView mTvRightLabel2;
        private TextView mTvSubName;
        private View redDot;

        ItemViewHolder(View view) {
            super(view);
            this.mIvIcon = (ImageView) view.findViewById(R.id.iv_mainlist_item_icon);
            this.mTvName = (TextView) view.findViewById(R.id.tv_mainlist_item_name);
            this.mTvSubName = (TextView) view.findViewById(R.id.tv_mainlist_item_sub_name);
            this.mTvRightLabel1 = (TextView) view.findViewById(R.id.tv_label_1);
            this.mTvRightLabel2 = (TextView) view.findViewById(R.id.tv_label_2);
            this.mIvRightIcon = (ImageView) view.findViewById(R.id.iv_mainlist_item_right_icon);
            this.redDot = view.findViewById(R.id.view_card_dot);
        }

        /* access modifiers changed from: protected */
        public void bind(final WalletMainListSettingContract.SettingItemModel settingItemModel) {
            if (settingItemModel != null) {
                this.mIvIcon.setImageResource(settingItemModel.imgId);
                this.mTvName.setText(TextUtils.isEmpty(settingItemModel.name) ? "" : settingItemModel.name);
                if (TextUtils.isEmpty(settingItemModel.rightLabel1)) {
                    this.mTvRightLabel1.setVisibility(8);
                } else {
                    this.mTvRightLabel1.setVisibility(0);
                    this.mTvRightLabel1.setText(settingItemModel.rightLabel1);
                }
                if (TextUtils.isEmpty(settingItemModel.rightLabel2)) {
                    this.mTvRightLabel2.setVisibility(8);
                } else {
                    this.mTvRightLabel2.setVisibility(0);
                    this.mTvRightLabel2.setText(settingItemModel.rightLabel2);
                    this.mTvRightLabel2.setTextColor(settingItemModel.rightLabel2Color);
                }
                if (settingItemModel.showTopGap) {
                    this.itemView.setPadding(0, UIUtil.dip2px(this.itemView.getContext(), 10.0f), 0, 0);
                } else {
                    this.itemView.setPadding(0, 0, 0, 0);
                }
                if (settingItemModel.f32011id == 2 && TextUtils.isEmpty(settingItemModel.linkUrl)) {
                    this.mIvRightIcon.setVisibility(4);
                }
                if (!settingItemModel.hasRedPoint || WalletSPUtils.getIsShowSettingRedDot(WalletMainListSettingListAdapter.this.f32310a, settingItemModel.type)) {
                    this.redDot.setVisibility(8);
                } else {
                    this.redDot.setVisibility(0);
                }
                if (!TextUtils.isEmpty(settingItemModel.subName)) {
                    this.mTvSubName.setVisibility(0);
                    this.mTvSubName.setText(settingItemModel.subName);
                } else {
                    this.mTvSubName.setVisibility(8);
                }
                final int i = settingItemModel.f32011id;
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (WalletMainListSettingListAdapter.this.f32312c != null) {
                            WalletMainListSettingListAdapter.this.f32312c.onSettingItemClicked(i, settingItemModel.linkUrl, settingItemModel);
                        }
                    }
                });
            }
        }
    }
}
