package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.taxis99.R;
import java.util.List;

public class WalletStatusHistoryAdapter extends RecyclerView.Adapter<CsStatusHistoryViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CsStatusHistoryListItemClickListener f32329a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f32330b;

    /* renamed from: c */
    private CsStatusHistoryListCallback f32331c;

    /* renamed from: d */
    private List<CsHistoryItem> f32332d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f32333e;

    public interface CsStatusHistoryListCallback {
        void onLastItemShowed();

        void onListEmpty();
    }

    public interface CsStatusHistoryListItemClickListener {
        void onCancelClick(CsHistoryItem csHistoryItem, int i);

        void onItemClick(CsHistoryItem csHistoryItem, boolean z, int i);

        void onPayClick(CsHistoryItem csHistoryItem, int i);
    }

    public WalletStatusHistoryAdapter(Context context, CsStatusHistoryListCallback csStatusHistoryListCallback, CsStatusHistoryListItemClickListener csStatusHistoryListItemClickListener) {
        this.f32330b = context;
        this.f32331c = csStatusHistoryListCallback;
        this.f32329a = csStatusHistoryListItemClickListener;
    }

    public void addData(List<CsHistoryItem> list, boolean z) {
        this.f32333e = z;
        List<CsHistoryItem> list2 = this.f32332d;
        if (list2 == null) {
            this.f32332d = list;
            notifyDataSetChanged();
            return;
        }
        int size = list2.size();
        this.f32332d.addAll(list);
        notifyItemInserted(size);
    }

    public void clearData() {
        List<CsHistoryItem> list = this.f32332d;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    public void removeItem(int i) {
        CsStatusHistoryListCallback csStatusHistoryListCallback;
        List<CsHistoryItem> list = this.f32332d;
        if (list != null && i >= 0 && i < list.size()) {
            CsHistoryItem remove = this.f32332d.remove(i);
            notifyItemRemoved(i);
            if (i < this.f32332d.size()) {
                notifyItemRangeChanged(i, this.f32332d.size() - i);
            }
            List<CsHistoryItem> list2 = this.f32332d;
            if ((list2 == null || list2.size() == 0) && (csStatusHistoryListCallback = this.f32331c) != null) {
                csStatusHistoryListCallback.onListEmpty();
            }
        }
    }

    public CsStatusHistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CsStatusHistoryViewHolder(LayoutInflater.from(this.f32330b).inflate(R.layout.wallet_status_history_list_item, viewGroup, false));
    }

    public void onBindViewHolder(CsStatusHistoryViewHolder csStatusHistoryViewHolder, final int i) {
        CsStatusHistoryListCallback csStatusHistoryListCallback;
        final CsHistoryItem csHistoryItem = this.f32332d.get(i);
        csStatusHistoryViewHolder.bindData(csHistoryItem);
        if (i == this.f32332d.size() - 1 && (csStatusHistoryListCallback = this.f32331c) != null) {
            csStatusHistoryListCallback.onLastItemShowed();
        }
        if (this.f32329a != null) {
            csStatusHistoryViewHolder.mCancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletStatusHistoryAdapter.this.f32329a.onCancelClick(csHistoryItem, i);
                }
            });
            csStatusHistoryViewHolder.mPay.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletStatusHistoryAdapter.this.f32329a.onPayClick(csHistoryItem, i);
                }
            });
            csStatusHistoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletStatusHistoryAdapter.this.f32329a.onItemClick(csHistoryItem, WalletStatusHistoryAdapter.this.f32333e, i);
                }
            });
        }
    }

    public int getItemCount() {
        List<CsHistoryItem> list = this.f32332d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class CsStatusHistoryViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView mCancel;
        private TextView mCashbackAmount;
        private TextView mCouponAmount;
        private CsHistoryItem mItem;
        private TextView mNameTv;
        private TextView mOrderTimeTv;
        private TextView mOriginAmount;
        /* access modifiers changed from: private */
        public TextView mPay;
        private TextView mPriceTv;
        private TextView mStatusDescTv;
        private ImageView mTimeIcon;
        private TextView mUnPaidStatusDesc;
        private View mUnpaidLayout;

        public CsStatusHistoryViewHolder(View view) {
            super(view);
            this.mNameTv = (TextView) view.findViewById(R.id.cs_history_item_name_tv);
            this.mStatusDescTv = (TextView) view.findViewById(R.id.cs_history_item_pay_status_tv);
            this.mOrderTimeTv = (TextView) view.findViewById(R.id.cs_history_item_time_tv);
            this.mPriceTv = (TextView) view.findViewById(R.id.cs_history_item_price_tv);
            this.mUnpaidLayout = view.findViewById(R.id.history_unpaid_layout);
            this.mCancel = (TextView) view.findViewById(R.id.wallet_history_cancel);
            this.mPay = (TextView) view.findViewById(R.id.wallet_history_pay);
            this.mTimeIcon = (ImageView) view.findViewById(R.id.cs_history_item_time_icon);
            this.mOriginAmount = (TextView) view.findViewById(R.id.boleto_origin_amount);
            this.mCouponAmount = (TextView) view.findViewById(R.id.cs_coupon_amount);
            this.mUnPaidStatusDesc = (TextView) view.findViewById(R.id.boleto_unpaid_status);
            this.mCashbackAmount = (TextView) view.findViewById(R.id.cs_cashback_amount);
        }

        public void bindData(CsHistoryItem csHistoryItem) {
            this.mItem = csHistoryItem;
            this.mNameTv.setText(csHistoryItem.name);
            this.mOrderTimeTv.setText(csHistoryItem.statusTime);
            this.mPriceTv.setText(String.format(WalletStatusHistoryAdapter.this.f32330b.getString(R.string.wallet_topup_item_symbal_formater), new Object[]{csHistoryItem.currencySymbol, csHistoryItem.amount}));
            PayRichInfo payRichInfo = WalletStatusHistoryAdapter.this.f32333e ? csHistoryItem.content : csHistoryItem.statusDesc;
            if (payRichInfo != null) {
                payRichInfo.bindTextView(this.mStatusDescTv);
                this.mStatusDescTv.setVisibility(0);
            } else {
                this.mStatusDescTv.setVisibility(8);
            }
            if (!WalletStatusHistoryAdapter.this.f32333e || csHistoryItem.content == null) {
                this.mTimeIcon.setVisibility(8);
            } else {
                this.mTimeIcon.setImageResource(csHistoryItem.content.infoList == null ? R.drawable.wallet_history_time_icon_grey : R.drawable.wallet_history_time_icon_light);
                this.mTimeIcon.setVisibility(0);
            }
            this.mUnpaidLayout.setVisibility(WalletStatusHistoryAdapter.this.f32333e ? 0 : 8);
            ((RelativeLayout.LayoutParams) this.mOrderTimeTv.getLayoutParams()).topMargin = WalletStatusHistoryAdapter.this.f32333e ? UIUtil.dip2px(WalletStatusHistoryAdapter.this.f32330b, 6.0f) : UIUtil.dip2px(WalletStatusHistoryAdapter.this.f32330b, 12.0f);
            ((RelativeLayout.LayoutParams) this.mStatusDescTv.getLayoutParams()).topMargin = WalletStatusHistoryAdapter.this.f32333e ? UIUtil.dip2px(WalletStatusHistoryAdapter.this.f32330b, 6.0f) : UIUtil.dip2px(WalletStatusHistoryAdapter.this.f32330b, 12.0f);
            if (!WalletStatusHistoryAdapter.this.f32333e || TextUtils.isEmpty(csHistoryItem.couponId)) {
                this.mOriginAmount.setVisibility(8);
                this.mCouponAmount.setVisibility(4);
            } else {
                this.mOriginAmount.setVisibility(0);
                this.mCouponAmount.setVisibility(0);
                if (!TextUtils.isEmpty(csHistoryItem.afterDiscountAmountDisplay)) {
                    this.mPriceTv.setText(csHistoryItem.afterDiscountAmountDisplay);
                }
                if (!TextUtils.isEmpty(csHistoryItem.originalAmountDisplay)) {
                    this.mOriginAmount.setText(csHistoryItem.originalAmountDisplay);
                }
                if (!TextUtils.isEmpty(csHistoryItem.couponAmountDisplay)) {
                    this.mCouponAmount.setText(String.format(WalletStatusHistoryAdapter.this.f32330b.getString(R.string.wallet_boleto_history_item_symbal), new Object[]{csHistoryItem.couponAmountDisplay}));
                } else {
                    this.mCouponAmount.setVisibility(8);
                }
                if (payRichInfo == null) {
                    this.mStatusDescTv.setVisibility(4);
                }
            }
            this.mOriginAmount.getPaint().setFlags(16);
            this.mUnPaidStatusDesc.setVisibility(8);
            if (!WalletStatusHistoryAdapter.this.f32333e && payRichInfo != null) {
                this.mStatusDescTv.setVisibility(8);
                this.mUnPaidStatusDesc.setVisibility(0);
                payRichInfo.bindTextView(this.mUnPaidStatusDesc);
            }
            if (!WalletStatusHistoryAdapter.this.f32333e || TextUtils.isEmpty(csHistoryItem.cashbackAmountDisplay)) {
                this.mCashbackAmount.setVisibility(8);
            } else {
                this.mCashbackAmount.setVisibility(0);
                this.mCashbackAmount.setText(String.format(WalletStatusHistoryAdapter.this.f32330b.getString(R.string.Fintech_Payment_perception__ssUt), new Object[]{csHistoryItem.cashbackAmountDisplay}));
                if (payRichInfo == null) {
                    this.mStatusDescTv.setVisibility(4);
                }
            }
            if (!WalletStatusHistoryAdapter.this.f32333e || !TextUtils.isEmpty(csHistoryItem.couponId)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCouponAmount.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = UIUtil.dp2px(6.0f);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mCouponAmount.getLayoutParams();
            layoutParams2.width = UIUtil.dp2px(0.0f);
            layoutParams2.leftMargin = UIUtil.dp2px(0.0f);
        }
    }
}
